import kotlin.jvm.optionals.getOrNull

plugins {
    id("oolang-commons")
    antlr
}

val versionCatalog: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
fun catalogVersion(lib: String) =
    versionCatalog.findVersion(lib).getOrNull()?.requiredVersion
        ?: throw GradleException("Version '$lib' is not specified in the toml version catalog")

dependencies {
    api(project(":oolang-ast"))
    antlr("org.antlr:antlr4:${catalogVersion("antlr4")}")
}

tasks.generateGrammarSource {
    packageName = "org.oolang.parser.generated"
    outputDirectory = File("$projectDir/src/main/java")
//    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor", "-no-listener")
}
