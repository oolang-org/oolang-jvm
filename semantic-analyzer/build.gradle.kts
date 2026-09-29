import kotlin.jvm.optionals.getOrNull

plugins {
    id("oolang-commons")
    `java-test-fixtures`
}

val versionCatalog: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
fun catalogVersion(lib: String) =
    versionCatalog.findVersion(lib).getOrNull()?.requiredVersion
        ?: throw GradleException("Version '$lib' is not specified in the toml version catalog")

dependencies {
    api(project(":oolang-ast"))

    testImplementation(project(":oolang-parser"))

    testFixturesImplementation("org.junit.jupiter:junit-jupiter-api:${catalogVersion("junit")}")
}
