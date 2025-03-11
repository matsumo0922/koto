plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.detekt")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(project.dependencies.platform(libs.koin.bom))

            api(libs.bundles.infra)
            api(libs.bundles.koin)
        }
    }
}
