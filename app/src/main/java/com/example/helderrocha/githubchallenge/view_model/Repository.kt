package com.example.helderrocha.githubchallenge.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

import com.example.helderrocha.githubchallenge.api.ApiClient
import com.example.helderrocha.githubchallenge.model.Items
import com.example.helderrocha.testeparaserinvolvido.SchedulerProvider
import javax.inject.Inject

class RepositoryViewModel @Inject constructor(val api: ApiClient, private val schedulers: SchedulerProvider) : ViewModel() {
    val _repositories = MutableLiveData<List<Items>>()
    val repositories: LiveData<List<Items>> = _repositories

    fun getRepositories(page: Long) {
        api.repositoriesscroll(page.toString())
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.mainThread())
                .subscribe({
                    _repositories.value = it.items
                }, {
                    _repositories.value = listOf()
                })
    }
}
