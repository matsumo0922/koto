plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.compose")
    id("matsumo.primitive.kmp.android.library")
    id("matsumo.primitive.kmp.android")
    id("matsumo.primitive.kmp.ios")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.detekt")
}

android {
    namespace = "me.matsumo.koto.core.resources"
}

compose.resources {
    publicResClass = true
    packageOfResClass = "me.matsumo.koto.core.resources"
    generateResClass = always
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(compose.components.resources)
        }
    }
}
