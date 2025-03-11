package primitive.kmp

import me.matsumo.koto.android
import me.matsumo.koto.androidTestImplementation
import me.matsumo.koto.debugImplementation
import me.matsumo.koto.implementation
import me.matsumo.koto.library
import me.matsumo.koto.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KmpComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
        }
    }
}
