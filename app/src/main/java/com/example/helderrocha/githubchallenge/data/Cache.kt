package com.example.helderrocha.testeparaserinvolvido.data

import com.example.helderrocha.githubchallenge.model.Genre
import com.example.helderrocha.githubchallenge.model.Movie
import com.example.helderrocha.githubchallenge.model.Repository


object Cache {

    var genres = listOf<Genre>()

    fun cacheGenres(genres: List<Genre>) {
        this.genres = genres
    }

    var repositories = listOf<Repository>()
    fun cacheRepositories(repositories: List<Repository>) {
        this.repositories = repositories
    }


    var movies = listOf<Movie>()

    fun cacheMovies(movies: List<Movie>) {
        this.movies = movies
    }

}
