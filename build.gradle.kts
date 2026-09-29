// when the Gradle version changes:
// -> execute ./gradlew wrapper, then remove .gradle directory, then execute ./gradlew wrapper again
tasks.wrapper {
    gradleVersion = "9.8.0"
    distributionType = Wrapper.DistributionType.ALL
}
