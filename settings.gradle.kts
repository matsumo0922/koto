rootProject.name = "koto"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven("https://www.jetbrains.com/intellij-repository/releases")
        maven("https://www.jetbrains.com/intellij-repository/snapshots")
        maven("https://packages.jetbrains.team/maven/p/kpm/public/")
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
include(":feature:setting")
