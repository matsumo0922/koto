rootProject.name = "koto"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
        maven("https://www.jitpack.io")
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        maven("https://www.jitpack.io")
    }
}

include(":composeApp")
include(":core:domain")
include(":core:common")
include(":core:datasource")
include(":core:repository")
include(":core:ui")
include(":core:resources")
include(":feature:home")
