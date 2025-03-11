plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.detekt")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:common"))
            implementation(project(":core:resources"))

            implementation(libs.ktor.core)
        }
    }
}
