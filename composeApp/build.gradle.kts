import org.gradle.declarative.dsl.schema.FqName.Empty.packageName
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    id("matsumo.primitive.kmp.common")
    // id("matsumo.primitive.kmp.android.application")
    id("matsumo.primitive.kmp.compose")
    // id("matsumo.primitive.kmp.android")
    // id("matsumo.primitive.kmp.ios")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.ktorfit")
    id("matsumo.primitive.detekt")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:common"))
            implementation(project(":core:domain"))
            implementation(project(":core:datasource"))
            implementation(project(":core:repository"))
            implementation(project(":core:ui"))
            implementation(project(":core:resources"))

            implementation(project(":feature:home"))
        }
    }
}

compose.desktop {
    application {
        mainClass = "KotoAppKt"

        buildTypes.release.proguard{
            version.set("7.6.1")
            isEnabled = false
        }

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "koto"
            packageVersion = "1.0.0"

            linux {
                iconFile.set(project.file("desktopAppIcons/LinuxIcon.png"))
            }
            windows {
                iconFile.set(project.file("desktopAppIcons/WindowsIcon.ico"))
                perUserInstall = true
            }
            macOS {
                iconFile.set(project.file("desktopAppIcons/MacosIcon.icns"))
                bundleID = "me.matsumo.koto"
            }
        }
    }
}
