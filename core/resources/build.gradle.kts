plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.compose")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.detekt")
}

compose.resources {
    publicResClass = true
    packageOfResClass = "me.matsumo.koto.core.resources"
    generateResClass = always
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            api(compose.components.resources)
        }
    }
}
