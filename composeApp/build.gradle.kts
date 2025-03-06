import org.gradle.declarative.dsl.schema.FqName.Empty.packageName
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree
import java.util.Properties

plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.compose")
    id("matsumo.primitive.kmp.android.application")
    id("matsumo.primitive.kmp.android")
    id("matsumo.primitive.kmp.ios")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.ktorfit")
    id("matsumo.primitive.detekt")
}

android {
    namespace = "me.matsumo.koto"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
        }

        androidMain.dependencies {
            implementation(compose.uiTooling)
            implementation(libs.androidx.activity.compose)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "koto"
            packageVersion = "1.0.0"

            linux {
                iconFile.set(project.file("desktopAppIcons/LinuxIcon.png"))
            }
            windows {
                iconFile.set(project.file("desktopAppIcons/WindowsIcon.ico"))
            }
            macOS {
                iconFile.set(project.file("desktopAppIcons/MacosIcon.icns"))
                bundleID = "me.matsumo.koto.desktopApp"
            }
        }
    }
}

buildkonfig {
    packageName = "me.matsumo.koto"

    defaultConfigs {

    }
}
