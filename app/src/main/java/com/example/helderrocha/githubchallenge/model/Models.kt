package com.example.helderrocha.githubchallenge.model
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class RepositoryResponse(
        @Json(name = "items") val items: List<Items>?,
        @Json(name = "total_count") val totalCount: Int?
)

data class  Items(
        @Json(name = "id") var id: Int?,
        @Json(name = "name") var name: String,
        @Json(name = "description") var description: String,
        @Json(name = "forks") var forks: String,
        @Json(name = "full_name") var full_name: String,
        @Json(name = "stargazers_count") var stargazers_count: String,
        @Json(name = "owner") var owner: Owner
)

data class  Owner(
        @Json(name = "id") var id: Int?,
        @Json(name = "login") var login: String,
        @Json(name = "avatar_url") var avatar_url: String
)

data class PullRequest(
        @SerializedName("id") var id: Int?,
        @SerializedName("title") var title: String,
        @SerializedName("user") var user: User,
        @SerializedName("body") var body:  String

)

data class  User(
        @SerializedName("id") val id: Int?,
        @SerializedName("login") val login: String,
        @SerializedName("avatar_url")  val avatar_url: String
)
