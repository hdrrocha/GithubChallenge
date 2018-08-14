package com.example.helderrocha.githubchallenge.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


import com.example.helderrocha.githubchallenge.api.ApiClient
import com.example.helderrocha.githubchallenge.model.Items
import com.example.helderrocha.githubchallenge.model.RepositoryResponse

import com.example.helderrocha.testeparaserinvolvido.SchedulerProvider
import com.example.helderrocha.testeparaserinvolvido.data.Cache

import com.example.helderrocha.testeparaserinvolvido.data.DatabaseHelper
import dagger.Lazy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryViewModel @Inject constructor(val api: ApiClient, private val schedulers: SchedulerProvider) : ViewModel() {
//    private val repositoryData = RepositoryLiveData(api, schedulers)
//    fun getData(): LiveData<List<Repository>> = repositoryData

    val _repositories = MutableLiveData<List<Items>>()
    val repositories: LiveData<List<Items>> = _repositories

    fun getRepositories() {
        api.repositories()
                .doOnSuccess {
//                    Cache.cacheRepositories(it.items!!)
                }
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.mainThread())
                .subscribe({
                    _repositories.value = it.items
//                    Cache.cacheRepositories(it.items!!)
//                    Cache.cacheMovies(_movies.value!!)
                }, {
                    _repositories.value = listOf()
                })
    }
}
//
//class RepositoryLiveData(private val api: ApiClient, private val schedulers: SchedulerProvider) : LiveData<List<Repository>>() {
//
//    init {
//        loadData()
//    }
//
//    private fun loadData() {
//        api.repositorys()
//                .subscribeOn(schedulers.io())
//                .observeOn(schedulers.mainThread())
//                .subscribe({
//                    value = it.repositories
//                }, {
//                    value = listOf()
//                })
//    }
//}
