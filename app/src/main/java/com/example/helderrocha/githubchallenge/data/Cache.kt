package com.example.helderrocha.testeparaserinvolvido.data

import com.example.helderrocha.githubchallenge.model.Genre
import com.example.helderrocha.githubchallenge.model.Items
import com.example.helderrocha.githubchallenge.model.Movie


object Cache {

    var genres = listOf<Genre>()

    fun cacheGenres(genres: List<Genre>) {
        this.genres = genres
    }

    var repositories = listOf<Items>()
    fun cacheRepositories(repositories: List<Items>) {
        this.repositories = repositories
    }


    var movies = listOf<Movie>()

    fun cacheMovies(movies: List<Movie>) {
        this.movies = movies
    }

}
