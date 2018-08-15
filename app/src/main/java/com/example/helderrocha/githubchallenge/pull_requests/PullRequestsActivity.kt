package com.example.helderrocha.githubchallenge.pull_requests

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.helderrocha.githubchallenge.R

import com.example.helderrocha.githubchallenge.model.PullRequest
import com.example.helderrocha.githubchallenge.pull_requests.adapter.PullRequestAdapter

import com.example.helderrocha.githubchallenge.view_model.PullRequestsViewModel

import com.example.helderrocha.githubchallenge.view_model.ViewModelFactory
import kotlinx.android.synthetic.main.pull_requests_activity.*

import javax.inject.Inject

class PullRequestsActivity : AppCompatActivity() {
    @Inject
    lateinit var pullRequestsVMFactory: ViewModelFactory<PullRequestsViewModel>

    private val pullRequestsViewModel by lazy {
        ViewModelProviders.of(this, pullRequestsVMFactory)[PullRequestsViewModel::class.java]
    }

    protected val PullRequestsObserver = Observer<List<PullRequest>>(::onItemsFetched)
    private lateinit var adapter: PullRequestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_requests_activity)

        val data: Bundle = intent.extras

//        showDetailActivityIntent.putExtra("criador", item.owner.login)
//        showDetailActivityIntent.putExtra("repositorio", item.full_name)
        var criador = data.getSerializable("criador")
        var repositorio = data.getSerializable("repositorio")

        Log.i("HELDER", criador.toString()+" => "+repositorio.toString())
//        movieViewModel.movie.observe(this, movieObserver)
//        movieViewModel.getMovieById(movieId.toLong())
//        pullRequestsViewModel.getPullRequest(criador.toString(),repositorio.toString())

    }

    private fun onItemsFetched(pullRequests: List<PullRequest>?) {
        adapter = PullRequestAdapter(pullRequests!!, { pullRequest: PullRequest -> partItemClicked(pullRequest) } )
        recyclerViewPullRequests.adapter = adapter

    }

    private fun partItemClicked(pullRequest : PullRequest) {
//        val showDetailActivityIntent = Intent(this, DetailsActivity::class.java)
//        showDetailActivityIntent.putExtra("movie_selected", movie.id)
//        startApartItemClickedctivity(showDetailActivityIntent)
    }
}
