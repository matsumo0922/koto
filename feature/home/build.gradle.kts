plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.android.library")
    id("matsumo.primitive.kmp.compose")
    id("matsumo.primitive.kmp.android")
    id("matsumo.primitive.kmp.ios")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.ktorfit")
    id("matsumo.primitive.detekt")
}

android {
    namespace = "me.matsumo.koto.feature.home"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:common"))
            implementation(project(":core:domain"))
            implementation(project(":core:repository"))
            implementation(project(":core:datasource"))
            implementation(project(":core:ui"))
            implementation(project(":core:resources"))
        }
    }
}
