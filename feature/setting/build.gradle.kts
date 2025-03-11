plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.compose")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.ktorfit")
    id("matsumo.primitive.detekt")
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
