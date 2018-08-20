package com.example.helderrocha.githubchallenge.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.helderrocha.githubchallenge.api.ApiClient
import com.example.helderrocha.githubchallenge.model.Items
import com.example.helderrocha.githubchallenge.model.PullRequest
import com.example.helderrocha.testeparaserinvolvido.SchedulerProvider
import com.example.helderrocha.testeparaserinvolvido.data.Cache
import javax.inject.Inject


class PullRequestsViewModel @Inject constructor(val api: ApiClient, private val schedulers: SchedulerProvider) : ViewModel() {
    val _pulls = MutableLiveData<List<PullRequest>>()
    val pulls: LiveData<List<PullRequest>> = _pulls
    fun getRepositories(name: String, repositorio: String) {

        api.pullRequest(name, repositorio)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.mainThread())
                .subscribe({
                    _pulls.value = it
                }, {
                    _pulls.value = listOf()
                    Log.e("Error", it.toString())
                })
     }

}
