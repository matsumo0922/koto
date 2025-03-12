package me.matsumo.koto.core.datasource.db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import java.io.File

actual fun getKotoDatabase(name: String): KotoDatabase {
    val dbFile = File(System.getProperty("compose.application.resources.dir")).resolve(name)
    val databaseBuilder = Room.databaseBuilder<KotoDatabase>(
        name = dbFile.absolutePath,
    )

    return databaseBuilder
        .fallbackToDestructiveMigrationOnDowngrade(false)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
