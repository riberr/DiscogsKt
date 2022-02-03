import io.ktor.client.features.logging.*
import me.riberr.discogskt.DiscogsKt
import me.riberr.discogskt.endpoints.database
import me.riberr.discogskt.endpoints.database.*
import me.riberr.discogskt.models.response.database.ArtistReleases

suspend fun main() {
    val discogsKt = DiscogsKt.create(
            "FooBarApp/3.0",
            "LTeJblSyJhrUMrOrKyEeJHAYxYWnfiCWDIOBnwfu",
            logLevel = LogLevel.ALL
        )


    discogsKt.database.getArtist(666)
        .onSuccess { println(it) }
        .onFailure { error(it) }

    val artist = discogsKt.database.getArtist(666).getOrThrow()

    discogsKt.database.getArtistReleases(666, ArtistReleases.Sort.TITLE, page = 0, perPage = 3)
        .onSuccess { it.releases.forEach { release -> release.title } }
        .onFailure { error(it) }

    discogsKt.database.getCommunityRating(666)
        .onSuccess { println(it) }
        .onFailure { error(it) }


    discogsKt.database.putUserRating(666, "ittakkva", 3)
        .onSuccess { println(it) }
        .onFailure { error(it) }

    discogsKt.database.deleteUserRating(666, "ittakkva")
        .onSuccess { println(it) }
        .onFailure { error(it) }

    discogsKt.database.getUserRating(666, "ittakkva")
        .onSuccess { println(it) }
        .onFailure { error(it) }

    /*
    discogsKt.database.getLabel(666)
        .onSuccess { println(it) }
        .onFailure { error(it) }

    discogsKt.database.getLabelReleases(666, 0, 50)
        .onSuccess { println(it) }
        .onFailure { error(it) }

    discogsKt.database.getRelease(666)
        .onSuccess { println(it) }
        .onFailure { error(it) }

    discogsKt.database.getReleaseStats(666)
        .onSuccess { println(it) }
        .onFailure { error(it) }
*/

}