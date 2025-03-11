plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.compose")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.detekt")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:common"))
            implementation(project(":core:domain"))
            implementation(project(":core:repository"))
            implementation(project(":core:datasource"))
            implementation(project(":core:resources"))

            api(libs.bundles.ui.common)
            api(libs.bundles.cupertino)
            api(libs.bundles.jewel)

            // Compose
            api(compose.runtime)
            api(compose.runtimeSaveable)
            api(compose.foundation)
            api(compose.animation)
            api(compose.animationGraphics)
            api(compose.material)
            api(compose.material3)
            api(compose.ui)
            api(compose.materialIconsExtended)
        }

        jvmMain.dependencies {
            api(compose.desktop.currentOs) {
                exclude(group = "org.jetbrains.compose.material")
            }
        }
    }
}
