plugins {
    id("oolang-commons")
}

dependencies {
    api(project(":oolang-ast"))

    testImplementation(project(":oolang-parser"))
    testImplementation(project(":oolang-semantic-analyzer"))
    testImplementation(testFixtures(project(":oolang-semantic-analyzer")))
}
