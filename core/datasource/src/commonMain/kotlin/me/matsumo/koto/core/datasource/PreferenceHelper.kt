package me.matsumo.koto.core.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.okio.OkioSerializer
import androidx.datastore.core.okio.OkioStorage
import okio.FileSystem
import okio.Path.Companion.toPath
import java.io.File

object PreferenceHelper {
    fun <T> create(
        name: String,
        serializer: OkioSerializer<T>,
    ): DataStore<T> {
        val file = File(System.getProperty("compose.application.resources.dir")).resolve("$name.preferences_pb")

        return DataStoreFactory.create(
            storage = OkioStorage(
                fileSystem = FileSystem.SYSTEM,
                serializer = serializer,
                producePath = { file.absolutePath.toPath() },
            ),
        )
    }
}
