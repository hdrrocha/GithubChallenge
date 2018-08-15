package com.example.helderrocha.githubchallenge.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

import com.example.helderrocha.githubchallenge.api.ApiClient
import com.example.helderrocha.githubchallenge.model.Items
import com.example.helderrocha.testeparaserinvolvido.SchedulerProvider
import com.example.helderrocha.testeparaserinvolvido.data.Cache
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

//        api.genres(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE)
//                .doOnSuccess {
//                    Cache.cacheGenres(it.genres)
//                }
//                .flatMapObservable {
//
//                    api.upcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, page, TmdbApi.DEFAULT_REGION)
//                }
//                .subscribeOn(schedulers.io())
//                .observeOn(schedulers.mainThread())
//                .subscribe({
//                    _movies.value = it.results.map { movie ->
//                        movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
//                    }
//                    Cache.cacheMovies(_movies.value!!)
//                }, {
//                    _movies.value = listOf()
//                })
    }
}
