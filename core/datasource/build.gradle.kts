plugins {
    id("matsumo.primitive.kmp.common")
    id("matsumo.primitive.kmp.jvm")
    id("matsumo.primitive.room")
    id("matsumo.primitive.ktorfit")
    id("matsumo.primitive.detekt")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:common"))
            implementation(project(":core:domain"))
            implementation(project(":core:resources"))

            implementation(libs.androidx.datastore)
            implementation(libs.androidx.datastore.proto)
            api(libs.androidx.datastore.preferences)
        }
    }
}
