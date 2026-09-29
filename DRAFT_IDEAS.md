# Draft ideas
A few code and design ideas that may or may not be implemented

# Nice Java features Oolang will or could use

## [JEP 526: Lazy Constants](https://openjdk.org/jeps/526) (preview)
Introduce an API for lazy constants, which are objects that hold unmodifiable data. Lazy constants are treated as true
constants by the JVM, enabling the same performance optimizations that are enabled by declaring a field final. Compared
to final fields, however, lazy constants offer greater flexibility as to the timing of their initialization. This is a
preview API.

Goals
* Enable application state to be initialized incrementally, on demand, rather than monolithically, thereby reducing
application startup time.
* Decouple the creation of lazy constants from their initialization, without significant performance penalties.
* Guarantee that lazy constants are initialized at most once, even in multithreaded programs.
* Enable user code to benefit from constant-folding optimizations previously applicable only to JDK-internal code.

Oolang will use a `LazyConstant` internally for its `by lazy` deferred initialization.

```
val logger: Logger by lazy { LoggerFactory.getLogger(UserService.class) }
```

## Valhalla

[Complete Valhalla explained article](https://www.jvm-weekly.com/p/project-valhalla-explained-how-a).

### [JEP 401: Value Classes and Objects](https://openjdk.org/jeps/401) (preview)
Introduce value objects, which are immutable and lack object identity. Value objects are distinguished solely by the
values of their fields, and can be represented by Java Virtual Machines in ways that improve performance. This is a
preview language and VM feature.

Goals
* Enable developers to opt in to a programming model for immutable data in which the == operator, and all other
operations, distinguish objects by the values of their fields rather than their identities.
* Support the compatible migration of existing classes that represent immutable data to this model. Migrate suitable
existing classes in the Java Platform API, such as Integer and LocalDate, to have value object instances.
* Do not ask developers to learn new semantics for memory management or variable storage. The Java language should
continue to operate on just two kinds of data: primitives and object references.
* Maximize the freedom of JVM implementors to represent immutable data in ways that improve memory footprint, locality,
and garbage collection efficiency.

### [JEP 539: Strict Field Initialization in the JVM](https://openjdk.org/jeps/539) (preview)
Introduce strictly initialized fields in the Java Virtual Machine. Such fields must be initialized before they are read,
thus default values such as `0` or `null` are never observed. For strictly initialized fields that are final, the same
value is always observed. This is a preview VM feature, available for use by compilers that emit class files.

Goals
* Offer designers of JVM-based programming languages a model for field initialization which has stronger integrity
guarantees than the present model.
* Give these designers the flexibility to choose, for each static and instance field in a class, whether to opt in to
the new model or continue with the present model.

### [JEP draft: Null-Restricted and Nullable Types](https://openjdk.org/jeps/8303099) (preview)
Support *nullness* markers on Java types to indicate that a type rejects or deliberately allows nulls. This is a preview
language feature.

Goals
* Enhance Java's reference types to let programmers express whether null references are expected as values of the type
* Support conversions between types with different nullness properties, accompanied by warnings about
possibly-mishandled null values
* Compatibly interoperate with traditional Java code that makes no assertions about the null compatibility of its types,
and support gradual adoption of these new features without introducing source or binary incompatibilities
* Ensure that variables with types that reject null are initialized before they are first read
* Enforce types that reject null at run time, even when classes are compiled separately
* Provide the metadata and integrity guarantees necessary for run-time optimizations (such as the flattening of value
objects) to rely on types that claim to exclude null

### [JEP 371: Hidden Classes](https://openjdk.org/jeps/371)
Introduce hidden classes, which are classes that cannot be used directly by the bytecode of other classes. Hidden
classes are intended for use by frameworks that generate classes at run time and use them indirectly, via reflection.
A hidden class may be defined as a member of an access control nest, and may be unloaded independently of other classes.

Goals
* Allow frameworks to define classes as non-discoverable implementation details of the framework, so that they cannot be
linked against by other classes nor discovered through reflection.
* Support extending an access control nest with non-discoverable classes.
* Support aggressive unloading of non-discoverable classes, so that frameworks have the flexibility to define as many as
they need.
