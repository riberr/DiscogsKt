package me.riberr.discogskt

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch
import me.riberr.discogskt.endpoints.database
import me.riberr.discogskt.endpoints.database.getUserRating
import me.riberr.discogskt.endpoints.database.putUserRating
import kotlin.test.Test

class DiscogsKtTest {

    @Test
    fun testGetRating() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val result = client.database.getUserRating(249504, "memory")
            println(result)
        }
    }

    @Test
    fun testPutRating() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0", "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu")
        launch {
            val result = client.database.putUserRating(249504, "ittakkva", 6)
            println(result)
        }
    }

    @Test
    fun testPrintJson() = runBlockingTest {
        val client = DiscogsKt.create("FooBarApp/3.0")
        launch {
            val response: HttpResponse = client.client.get("https://api.discogs.com/releases/999999")
            val stringBody: String = response.receive()
            println(stringBody)
        }
    }
}