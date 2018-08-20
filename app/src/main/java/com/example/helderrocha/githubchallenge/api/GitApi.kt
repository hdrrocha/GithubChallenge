package com.example.helderrocha.githubchallenge.api

import com.example.helderrocha.githubchallenge.model.PullRequest
import com.example.helderrocha.githubchallenge.model.RepositoryResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GitApi {

    companion object {
        const val URL = "https://api.github.com/"
    }

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun repositories(): Single<RepositoryResponse>

    @GET("search/repositories?q=language:Java&sort=stars&")
    fun repositoriesscroll(@Query("page") page: String): Observable<RepositoryResponse>
//    https://api.github.com/repos/<criador>/<repositório>/pulls
//    @GET("/repos/{repositorio}/pulls/" )
    @GET("/repos/{name}/{repo}/pulls" )
    fun pullRequest(
        @Path("name") name: String,
        @Path("repo") repo: String): Observable<List<PullRequest>>

}
