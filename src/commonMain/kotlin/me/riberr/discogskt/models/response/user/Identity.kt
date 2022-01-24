package me.riberr.discogskt.models.response.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Identity(
    val id: Int,
    val username: String,
    @SerialName("resource_url")
    val resourceUrl: String,
    @SerialName("consumer_name")
    val consumerName: String
)