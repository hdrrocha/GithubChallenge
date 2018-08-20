package com.example.helderrocha.testeparaserinvolvido.data

import com.example.helderrocha.githubchallenge.model.Items
import com.example.helderrocha.githubchallenge.model.PullRequest


object Cache {
    var repositories = listOf<Items>()

    fun cacheRepositories(repositories: List<Items>) {
        this.repositories = repositories
    }

    var pulls = listOf<PullRequest>()

    fun cachePulls(pulls: List<PullRequest>) {
        this.pulls = pulls
    }
}
