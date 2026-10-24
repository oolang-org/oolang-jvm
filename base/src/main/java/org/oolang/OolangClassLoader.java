/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.InputStream;
import java.lang.classfile.Annotation;
import java.lang.classfile.AnnotationElement;
import java.lang.classfile.AnnotationValue;
import java.lang.classfile.ClassFile;
import java.lang.classfile.attribute.RuntimeVisibleAnnotationsAttribute;
import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDescs;
import java.lang.reflect.AccessFlag;
import java.util.Objects;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public final class OolangClassLoader {
    // un-instantiable
    private OolangClassLoader() {
    }

    private static final @NonNull String OOLANG_GET_ANNOTATION = "org.oolang.OolangGet";
    private static final @NonNull String OOLANG_SET_ANNOTATION = "org.oolang.OolangSet";

    private static final @NonNull SimpleClassLoader OOLANG_CLASS_LOADER;

    static {
        final var classLoader = new SimpleClassLoader();
        classLoader.define(OOLANG_GET_ANNOTATION, annotationBytes(OOLANG_GET_ANNOTATION));
        classLoader.define(OOLANG_SET_ANNOTATION, annotationBytes(OOLANG_SET_ANNOTATION));
        OOLANG_CLASS_LOADER = classLoader;
    }

    private static byte @NonNull [] annotationBytes(final @NonNull String annotation) {
        assert annotation != null;

        return ClassFile.of()
                .build(ClassDesc.of(annotation), classBuilder -> {
                    classBuilder.withFlags(AccessFlag.PUBLIC, AccessFlag.INTERFACE, AccessFlag.ANNOTATION);
                    classBuilder.withSuperclass(ConstantDescs.CD_Object);
                    classBuilder.withInterfaceSymbols(ClassDesc.of("java.lang.annotation.Annotation"));

                    // Add meta-annotations: @Retention(RetentionPolicy.RUNTIME) & @Target(ElementType.METHOD)
                    classBuilder.with(RuntimeVisibleAnnotationsAttribute.of(
                            // 1. Retention config is RetentionPolicy.RUNTIME
                            Annotation.of(ClassDesc.of("java.lang.annotation.Retention"),
                                    AnnotationElement.of("value",
                                            AnnotationValue.ofEnum(
                                                    ClassDesc.of("java.lang.annotation.RetentionPolicy"),
                                                    "RUNTIME")
                                    )
                            ),
                            // 2. Target restriction config (strictly ElementType.METHOD array payload)
                            Annotation.of(ClassDesc.of("java.lang.annotation.Target"),
                                    AnnotationElement.of("value",
                                            AnnotationValue.ofArray(AnnotationValue.ofEnum(
                                                    ClassDesc.of("java.lang.annotation.ElementType"),
                                                    "METHOD")
                                            ))
                            )
                    ));
                });
    }

    /// Resolves any class needed during the symbol table construction phase. It handles standard JDK library classes
    /// and our virtual annotations [OOLANG_GET_ANNOTATION] and [OOLANG_SET_ANNOTATION].
    public static @Nullable Class<?> resolveClass(final @NonNull String className) {
        Objects.requireNonNull(className);

        try {
            // Drop-in replacement routing through our custom class loader
            return Class.forName(className, true, OOLANG_CLASS_LOADER);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /**
     * Utility to dynamically register class bytes compiled from disk/JARs
     * directly into the resolution scope.
     */
    public static @NonNull Class<?> registerCompiledClass(final @NonNull String className,
                                                          final byte @NonNull [] classBytes) {
        Objects.requireNonNull(className);
        Objects.requireNonNull(classBytes);

        return OOLANG_CLASS_LOADER.define(className, classBytes);
    }

    private static class SimpleClassLoader extends ClassLoader {
        private SimpleClassLoader() {
            // Parent-delegation: sets the current application's classloader as the parent.
            // This ensures java.lang.String, java.util.List, etc. are loaded normally via the JDK.
            super(OolangClassLoader.class.getClassLoader());
        }

        private @NonNull Class<?> define(final @NonNull String name, final byte @NonNull [] bytes) {
            assert name != null;
            assert bytes != null;

            return defineClass(name, bytes, 0, bytes.length);
        }
    }

    static void main() throws Exception {
        String jarPath = "target/my-output-archive.jar";
        String targetClassNameInJar = "MyCompiledProgram.class";

        byte[] classBytesFromFile;

        try (JarFile jarFile = new JarFile(jarPath)) {
            ZipEntry entry = jarFile.getEntry(targetClassNameInJar);
            if (entry == null) {
                System.out.println("Target class not found inside the JAR.");
                return;
            }
            try (InputStream is = jarFile.getInputStream(entry)) {
                classBytesFromFile = is.readAllBytes();
            }
        }

        String binaryClassName = targetClassNameInJar.replace(".class", "");
        Class<?> parsedJarClass = OOLANG_CLASS_LOADER.define(binaryClassName, classBytesFromFile);

        @SuppressWarnings("unchecked") final var oolangGetAnnotation =
                (Class<? extends java.lang.annotation.Annotation>) OOLANG_CLASS_LOADER.loadClass(OOLANG_GET_ANNOTATION);

        // Scan methods inside the loaded class via standard reflection
        for (java.lang.reflect.Method method : parsedJarClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(oolangGetAnnotation)) {
                System.out.println("Method '" + method.getName() + "' successfully matched the virtual annotation!");
            }
        }
    }
}
