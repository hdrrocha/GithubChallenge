package com.example.helderrocha.githubchallenge.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


import com.example.helderrocha.githubchallenge.api.ApiClient

import com.example.helderrocha.githubchallenge.model.Repository
import com.example.helderrocha.testeparaserinvolvido.SchedulerProvider
import com.example.helderrocha.testeparaserinvolvido.data.Cache

import com.example.helderrocha.testeparaserinvolvido.data.DatabaseHelper
import dagger.Lazy
import javax.inject.Inject

class ViewModelFactory<VM : ViewModel> @Inject constructor(private val viewModel: Lazy<VM>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel.get() as T
    }
}
class RepositoryViewModel @Inject constructor(val api: ApiClient, private val schedulers: SchedulerProvider) : ViewModel() {
    private val repositoryData = RepositoryLiveData(api, schedulers)
    fun getData(): LiveData<List<Repository>> = repositoryData

    val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>> = _repositories

    fun getMoreRepository() {
        api.repositorys()
                .doOnSuccess {
                    Cache.cacheRepositories(it.repositories)
                }
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.mainThread())
                .subscribe({
                    _repositories.value = it.repositories
//                    Cache.cacheMovies(_movies.value!!)
                }, {
                    _repositories.value = listOf()
                })
    }
}

class RepositoryLiveData(private val api: ApiClient, private val schedulers: SchedulerProvider) : LiveData<List<Repository>>() {

    init {
        loadData()
    }

    private fun loadData() {
        api.repositorys()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.mainThread())
                .subscribe({
                    value = it.repositories
                }, {
                    value = listOf()
                })
    }
}
