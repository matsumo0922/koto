package me.matsumo.koto.core.datasource.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "history")
data class TranslationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "source")
    val source: String,
    @ColumnInfo(name = "target")
    val target: String,
    @ColumnInfo(name = "source_text")
    val sourceText: String,
    @ColumnInfo(name = "translated_text")
    val translatedText: String,
    @ColumnInfo(name = "re_translated_text")
    val reTranslatedText: String,
    @ColumnInfo(name = "service")
    val service: String,
    @ColumnInfo(name = "created_at")
    val createdAt: String,
)
