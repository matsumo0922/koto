package me.matsumo.koto.core.datasource

import androidx.compose.ui.input.key.Key.Companion.T
import androidx.datastore.core.okio.OkioSerializer
import kotlinx.serialization.json.Json
import me.matsumo.koto.core.domain.UserData
import okio.BufferedSink
import okio.BufferedSource

val userDataSerializer = preferenceSerializer(
    defaultValue = UserData.default(),
)

private inline fun <reified T> preferenceSerializer(
    crossinline encode: (T) -> String = { Json.encodeToString(it) },
    crossinline decode: (String) -> T = { Json.decodeFromString(it) },
    defaultValue: T,
) = object : OkioSerializer<T> {

    override val defaultValue: T
        get() = defaultValue

    override suspend fun writeTo(t: T, sink: BufferedSink) {
        sink.writeUtf8(encode(t))
    }

    override suspend fun readFrom(source: BufferedSource): T {
        return run { decode(source.readUtf8()) }
    }
}
