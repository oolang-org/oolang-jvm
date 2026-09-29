pluginManagement {
    includeBuild("build-logic")
}

rootProject.name = "oolang-jvm"

include(":oolang-ast")
include(":oolang-compiler")
include(":oolang-parser")
include(":oolang-semantic-analyzer")

project(":oolang-ast").projectDir = file("ast")
project(":oolang-compiler").projectDir = file("compiler")
project(":oolang-parser").projectDir = file("parser")
project(":oolang-semantic-analyzer").projectDir = file("semantic-analyzer")
