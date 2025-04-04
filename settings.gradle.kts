plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "user"
include("core")
include("usecase")
include("application")
include("infrastructure")
