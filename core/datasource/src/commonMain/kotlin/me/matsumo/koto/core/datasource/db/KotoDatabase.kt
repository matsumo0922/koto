package me.matsumo.koto.core.datasource.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(entities = [TranslationEntity::class], version = 1)
@ConstructedBy(CookieDatabaseConstructor::class)
abstract class KotoDatabase : RoomDatabase() {
    abstract fun translationDao(): TranslationDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal expect object CookieDatabaseConstructor : RoomDatabaseConstructor<KotoDatabase> {
    override fun initialize(): KotoDatabase
}

expect fun getKotoDatabase(name: String): KotoDatabase
