package com.example.helderrocha.githubchallenge.api

import com.example.helderrocha.githubchallenge.model.GenreResponse
import com.example.helderrocha.githubchallenge.model.RepositoryResponse
import com.example.helderrocha.githubchallenge.model.UpcomingMoviesResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ApiClient @Inject constructor(
        private val gitApi: GitApi
) {
    fun repositorys(): Single<RepositoryResponse> {
        return gitApi.repositories()
    }

//    fun upcomingMovies(apiKey: String,
//                       language: String,
//                       page: Long,
//                       region: String
//    ): Observable<UpcomingMoviesResponse> {
//        return tmdbApi.upcomingMovies(apiKey, language, page, region)
//    }
//
//    fun movie(id: Long,
//              apiKey: String,
//              language: String
//    ): Observable<Movie> {
//        return tmdbApi.movie(id, apiKey, language)
//    }
}