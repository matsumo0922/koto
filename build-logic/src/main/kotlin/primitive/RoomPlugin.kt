package primitive

import androidx.room.gradle.RoomExtension
import me.matsumo.koto.bundle
import me.matsumo.koto.library
import me.matsumo.koto.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import primitive.kmp.kotlin

class RoomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("androidx.room")

            kotlin {
                sourceSets.commonMain.dependencies {
                    implementation(libs.bundle("database"))
                }
            }

            dependencies {
                listOf(
                    "kspJvm",
                ).forEach {
                    add(it, libs.library("kmp-room-compiler"))
                }
            }

            extensions.getByType<RoomExtension>().apply {
                schemaDirectory("$projectDir/schemas")
            }
        }
    }
}
