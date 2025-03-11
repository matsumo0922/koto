plugins {
    id("matsumo.primitive.kmp.common")
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
            implementation(project(":core:resources"))

            implementation(libs.bundles.ktor)
            implementation(libs.ksoup)
            implementation(libs.openai.client)

            api(libs.kmp.paging.common)
        }
    }
}
