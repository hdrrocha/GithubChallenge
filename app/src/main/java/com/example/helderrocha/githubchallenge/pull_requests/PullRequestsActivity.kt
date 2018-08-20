package com.example.helderrocha.githubchallenge.pull_requests

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast

import com.example.helderrocha.githubchallenge.R
import com.example.helderrocha.githubchallenge.model.Items

import com.example.helderrocha.githubchallenge.model.PullRequest
import com.example.helderrocha.githubchallenge.pull_requests.adapter.PullRequestAdapter

import com.example.helderrocha.githubchallenge.view_model.PullRequestsViewModel
import com.example.helderrocha.githubchallenge.view_model.RepositoryViewModel

import com.example.helderrocha.githubchallenge.view_model.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.pull_requests_activity.*
import kotlinx.android.synthetic.main.repositorios_activity.*

import javax.inject.Inject

class PullRequestsActivity : AppCompatActivity() {
    @Inject
    lateinit var pullsVMFactory: ViewModelFactory<PullRequestsViewModel>

    private val pullsViewModel by lazy {
        ViewModelProviders.of(this, pullsVMFactory)[PullRequestsViewModel::class.java]
    }

    protected val ItemsObserver = Observer<List<PullRequest>>(::onItemsFetched)
    private lateinit var adapter: PullRequestAdapter
    var layoutManager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_requests_activity)
        recyclerViewPullRequests.layoutManager = layoutManager
        recyclerViewPullRequests.setHasFixedSize(true)
        val name = intent.getStringExtra("name")
        val repo = intent.getStringExtra("repo")
        pullsViewModel.pulls.observe(this, ItemsObserver)
        pullsViewModel.getRepositories(name, repo)

    }

    private fun onItemsFetched(pullRequests: List<PullRequest>?) {
        Log.i("Helder", pullRequests!![0].title)
        adapter = PullRequestAdapter(pullRequests!!, { pullRequest: PullRequest -> partItemClicked(pullRequest) } )
        recyclerViewPullRequests.adapter = adapter
        progressBarPullRequest.visibility = View.GONE
    }

    private fun partItemClicked(pullRequest : PullRequest) {
//        val showDetailActivityIntent = Intent(this, DetailsActivity::class.java)
//        showDetailActivityIntent.putExtra("movie_selected", movie.id)
//        startApartItemClickedctivity(showDetailActivityIntent)
    }
}
