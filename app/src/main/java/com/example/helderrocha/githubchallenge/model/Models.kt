package com.example.helderrocha.githubchallenge.model

import android.databinding.BindingAdapter
import android.databinding.BindingMethod
import android.databinding.BindingMethods
import android.widget.ImageView
import com.squareup.moshi.Json
import android.databinding.ObservableField
import android.graphics.drawable.Drawable
//import com.example.helderrocha.testeparaserinvolvido.util.MovieImageUrlBuilder



data class GenreResponse(val genres: List<Genre>)

data class Genre(val id: Int, val name: String)

data class UpcomingMoviesResponse(
        val page: Int,
        val results: List<Movie>,
        @Json(name = "total_pages") val totalPages: Int,
        @Json(name = "total_results") val totalResults: Int
)

data class Movie(
        val id: Int,
        val title: String,
        val overview: String?,
        val genres: List<Genre>?,
        @Json(name = "genre_ids") val genreIds: List<Int>?,
        @Json(name = "poster_path") val posterPath: String?,
        @Json(name = "backdrop_path") val backdropPath: String?,
        @Json(name = "release_date") val releaseDate: String?
)

data class RepositoryResponse(
        @Json(name = "items") val items: List<Items>?,
        @Json(name = "total_count") val totalCount: Int?
)

data class  Items(
        @Json(name = "id") val id: Int?,
        @Json(name = "name") val name: String,
        @Json(name = "description") val description: String,
        @Json(name = "forks") val forks: String,
        @Json(name = "stargazers_count") val stargazers_count: String,
        @Json(name = "owner") val owner: Owner
)
data class  Owner(
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