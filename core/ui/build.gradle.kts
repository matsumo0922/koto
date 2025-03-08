plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.android.library")
    id("matsumo.primitive.kmp.compose")
    id("matsumo.primitive.kmp.android")
    id("matsumo.primitive.kmp.ios")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.detekt")
}

android {
    namespace = "me.matsumo.koto.core.ui"
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

        androidMain.dependencies {
            api(libs.bundles.ui.android)
        }
    }
}
