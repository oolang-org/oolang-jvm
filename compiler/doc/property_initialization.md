In the official Java Class-File API (java.lang.classfile), a class field declaration cannot hold an expression
initializer directly at the bytecode level.

In a Java class file, fields only accept static constant values via the ConstantValue attribute (and only for primitive
types or Strings). Dynamic expressions or runtime calculations must be executed via bytecode instructions inside an
initializer method.

# 1. Static Fields with Constant Initializers

If your initializer is a static constant expression (like a fixed primitive or string), you can pass a
Consumer<FieldBuilder> to withField and attach a ConstantValue attribute:
```java
javaclassBuilder.withField("MAX_COUNT", ConstantDescs.CD_int, fieldBuilder -> fieldBuilder
  .withFlags(AccessFlag.PUBLIC, AccessFlag.STATIC, AccessFlag.FINAL)
  .with(ConstantValueAttribute.of(42)) // Attaches the constant value initializer
);
```
# 2. Fields with Expression Initializers

If your initializer is a dynamic or computational expression (e.g., new ArrayList<>() or System.currentTimeMillis()),
you must define the field structure using withField and then generate the code evaluating the expression inside the
appropriate initializer method:

## For Instance Fields (Initialized in `init`)

Instance field expressions must be evaluated and assigned via putfield within the class constructor (`init`):
```java
// 1. Define the field signature
classBuilder.withField("myList", ClassDesc.of("java.util.List"), AccessFlag.PRIVATE);

// 2. Evaluate expression and assign it inside the constructor method
classBuilder.withMethodBody(
  ConstantDescs.INIT_NAME,
  MethodTypeDesc.of(ConstantDescs.CD_void),
  AccessFlag.PUBLIC.mask(),
  codeBuilder -> codeBuilder
    .aload(0) // Push 'this' onto the stack
    .invokespecial(ConstantDescs.CD_Object, ConstantDescs.INIT_NAME, MethodTypeDesc.of(ConstantDescs.CD_void)) // super()

    // --- Field Expression Initializer: new ArrayList() ---
    .aload(0) // Push 'this' again for the putfield target
    .new_(ClassDesc.of("java.util.ArrayList"))
    .dup()
    .invokespecial(ClassDesc.of("java.util.ArrayList"), ConstantDescs.INIT_NAME, MethodTypeDesc.of(ConstantDescs.CD_void))
    .putfield(classBuilder.thisClass().asSymbol(), "myList", ClassDesc.of("java.util.List"))
    // ----------------------------------------------------
        
    .return_()
);
```
## For Static Fields (Initialized in `clinit`)

Static field expressions must be evaluated and assigned via putstatic inside the static initializer block (`clinit`):
```java
// 1. Define the static field signature
classBuilder.withField("startTime", ConstantDescs.CD_long, AccessFlag.PRIVATE.mask() | AccessFlag.STATIC.mask());

// 2. Evaluate expression and assign it inside the static block
classBuilder.withMethodBody(
  ConstantDescs.CLASS_INIT_NAME,
  MethodTypeDesc.of(ConstantDescs.CD_void),
  AccessFlag.STATIC.mask(),
    codeBuilder -> codeBuilder
    // --- Field Expression Initializer: System.currentTimeMillis() ---
    .invokestatic(ClassDesc.of("java.lang.System"), "currentTimeMillis", MethodTypeDesc.of(ConstantDescs.CD_long))
    .putstatic(classBuilder.thisClass().asSymbol(), "startTime", ConstantDescs.CD_long)
    // ----------------------------------------------------------------

    .return_()
);
```
