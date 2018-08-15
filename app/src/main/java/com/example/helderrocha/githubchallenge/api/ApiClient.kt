package com.example.helderrocha.githubchallenge.api
import com.example.helderrocha.githubchallenge.model.PullRequestResponse
import com.example.helderrocha.githubchallenge.model.RepositoryResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ApiClient @Inject constructor(
        private val gitApi: GitApi
) {
//    fun repositories(): Single<RepositoryResponse> {
//        return gitApi.repositories()
//    }
    fun repositories(): Single<RepositoryResponse> {
        return gitApi.repositories()
    }
    fun repositoriesscroll(page: String): Observable<RepositoryResponse> {
        return gitApi.repositoriesscroll(page)
    }
    fun pullRequest(criador: String, repositorio: String ): Observable<PullRequestResponse> {
        return gitApi.pullRequest(criador, repositorio)
    }

    //pullRequest(@Path("criador") criador: String, @Path("repositorio") repositorio: String): Observable<PullRequestResponse>
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