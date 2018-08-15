package com.example.helderrocha.githubchallenge.api

import com.example.helderrocha.githubchallenge.model.RepositoryResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GitApi {

    companion object {
        const val URL = "https://api.github.com/"
//        const val API_KEY = "1f54bd990f1cdfb230adb312546d765d"
        //get inifinite movies
//        const val DEFAULT_LANGUAGE = ""
//        const val DEFAULT_REGION = ""

//        const val DEFAULT_LANGUAGE = "en-US"
//        const val DEFAULT_REGION = "US"
    }

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun repositories(): Single<RepositoryResponse>

    @GET("search/repositories?q=language:Java&sort=stars&")
    fun repositoriesscroll(@Query("page") page: String): Observable<RepositoryResponse>
//
//    @GET("movie/{id}")
//    fun movie(
//            @Path("id") id: Long,
//            @Query("api_key") apiKey: String,
//            @Query("language") language: String
//    ): Observable<Movie>
}
