package com.example.helderrocha.githubchallenge.api
import android.util.Log
import com.example.helderrocha.githubchallenge.model.PullRequest

import com.example.helderrocha.githubchallenge.model.RepositoryResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ApiClient @Inject constructor(private val gitApi: GitApi) {

    fun repositoriesscroll(page: String): Observable<RepositoryResponse> {
        return gitApi.repositoriesscroll(page)
    }

    fun pullRequest(repositorio: String): Observable<List<PullRequest>> {
        return gitApi.pullRequest(repositorio)
    }

}