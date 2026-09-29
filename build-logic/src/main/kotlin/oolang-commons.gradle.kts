import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import kotlin.jvm.optionals.getOrNull

plugins {
    `java-library`
    `maven-publish`
    signing
}

val versionCatalog: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
fun catalogVersion(lib: String) =
    versionCatalog.findVersion(lib).getOrNull()?.requiredVersion
        ?: throw GradleException("Version '$lib' is not specified in the toml version catalog")

val javaVersion = catalogVersion("java").toInt()

repositories {
    mavenCentral()
}

dependencies {
    api("org.jspecify:jspecify:${catalogVersion("jspecify")}")

    testImplementation("org.junit.jupiter:junit-jupiter:${catalogVersion("junit")}")
    testImplementation("org.assertj:assertj-core:${catalogVersion("assertj")}")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher:${catalogVersion("junit")}")
    testRuntimeOnly("org.slf4j:slf4j-jdk-platform-logging:${catalogVersion("slf4j")}")
    testRuntimeOnly("ch.qos.logback:logback-classic:${catalogVersion("logback")}")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion)
    }

    withSourcesJar()
    withJavadocJar()
}

tasks {
    withType<Jar> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }

    withType<JavaCompile> {
        options.compilerArgs.add("--enable-preview")
    }

    withType<Javadoc> {
        val javadocOptions = options as CoreJavadocOptions

        javadocOptions.addStringOption("source", javaVersion.toString())
        javadocOptions.addBooleanOption("-enable-preview", true)
    }

    val testJavaVersion = System.getProperty("test.java.version", "").toIntOrNull()
    withType<Test> {
        if (testJavaVersion != null) {
            javaLauncher = javaToolchains.launcherFor {
                languageVersion = JavaLanguageVersion.of(testJavaVersion)
            }
        }

        useJUnitPlatform()

        testLogging {
            events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)
            exceptionFormat = TestExceptionFormat.FULL
            showStandardStreams = true
        }
        jvmArgs("--enable-preview")
    }
}

publishing {
    repositories {
        maven {
            url = uri(layout.buildDirectory.dir("repos/releases"))
        }
    }

    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name = project.name
                description = "The Oolang programming language for the JVM"
                url = "https://github.com/oolang-org/oolang-jvm"

                licenses {
                    license {
                        name = "Apache-2.0"
                        url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }

                developers {
                    developer {
                        name.set("pull-vert")
                        url.set("https://github.com/pull-vert")
                    }
                }

                scm {
                    connection = "scm:git:git://github.com/oolang-org/oolang-jvm"
                    developerConnection = "scm:git:git://github.com/oolang-org/oolang-jvm.git"
                    url = "https://github.com/oolang-org/oolang-jvm.git"
                }
            }
        }
    }
}

signing {
    // Require signing.keyId, signing.password and signing.secretKeyRingFile
    sign(publishing.publications)
}
