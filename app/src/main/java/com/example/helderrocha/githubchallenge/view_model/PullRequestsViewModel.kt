package com.example.helderrocha.githubchallenge.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.helderrocha.githubchallenge.api.ApiClient
import com.example.helderrocha.githubchallenge.model.PullRequest
import com.example.helderrocha.testeparaserinvolvido.SchedulerProvider
import javax.inject.Inject


class PullRequestsViewModel @Inject constructor(val api: ApiClient, private val schedulers: SchedulerProvider) : ViewModel() {
    var _pullRequests = MutableLiveData<List<PullRequest>>()
    val pullRequests: LiveData<List<PullRequest>> = _pullRequests

    fun getPullRequest(repositorio: String) {
        api.pullRequest(repositorio+"/pulls")
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.mainThread())
                .subscribe({
                    _pullRequests.value = it
                }, {
                    _pullRequests.value = listOf()
                })
    }
}
