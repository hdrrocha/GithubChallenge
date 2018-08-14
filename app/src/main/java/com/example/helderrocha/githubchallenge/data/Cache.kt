package com.example.helderrocha.testeparaserinvolvido.data

import com.example.helderrocha.githubchallenge.model.Items



object Cache {
    var repositories = listOf<Items>()

    fun cacheRepositories(repositories: List<Items>) {
        this.repositories = repositories
    }
}
