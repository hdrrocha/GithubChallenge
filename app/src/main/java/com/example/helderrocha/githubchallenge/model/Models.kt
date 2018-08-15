package com.example.helderrocha.githubchallenge.model
import com.squareup.moshi.Json

data class RepositoryResponse(
        @Json(name = "items") val items: List<Items>?,
        @Json(name = "total_count") val totalCount: Int?
)

data class  Items(
        @Json(name = "id") val id: Int?,
        @Json(name = "name") val name: String,
        @Json(name = "description") val description: String,
        @Json(name = "forks") val forks: String,
        @Json(name = "full_name") val full_name: String,
        @Json(name = "stargazers_count") val stargazers_count: String,
        @Json(name = "owner") val owner: Owner
)
data class  Owner(
        @Json(name = "id") val id: Int?,
        @Json(name = "login") val login: String,
        @Json(name = "avatar_url") val avatar_url: String
)

data class PullRequestResponse(
       val pullRequest: List<PullRequest>? = null
)

data class PullRequest(
        @Json(name = "id") val id: Int?,
        @Json(name = "title") val title: String,
        @Json(name = "user") val user: User,
        @Json(name = "body") val body:  String

)

data class  User(
        @Json(name = "id") val id: Int?,
        @Json(name = "login") val login: String,
        @Json(name = "avatar_url") val avatar_url: String
)


//data class  Owner(
//        val id: Int,
//        val login: String,
//        val node_id: String,
//        val avatar_url: String,
//        val gravatar_id: String,
//        val url: String,
//        val html_url: String,
//        val followers_url: String,
//        val following_url: String,
//        val gists_url: String,
//        val starred_url: String,
//        val subscriptions_url: String,
//        val organizations_url: String,
//        val repos_url: String,
//        val events_url: String,
//        val received_events_url: String,
//        val type: String?,
//        val site_admin: Boolean?
//)