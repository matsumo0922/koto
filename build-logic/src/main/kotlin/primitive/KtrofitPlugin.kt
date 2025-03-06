package primitive

import me.matsumo.koto.library
import me.matsumo.koto.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import primitive.kmp.kotlin

class KtrofitPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("de.jensklingenberg.ktorfit")

            kotlin {
                sourceSets.commonMain.dependencies {
                    implementation(libs.library("ktorfit"))
                }
            }
        }
    }
}
