package com.example.helderrocha.githubchallenge.pull_requests

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import com.example.helderrocha.githubchallenge.R
import com.example.helderrocha.githubchallenge.model.Items

import com.example.helderrocha.githubchallenge.model.PullRequest
import com.example.helderrocha.githubchallenge.pull_requests.adapter.PullRequestAdapter

import com.example.helderrocha.githubchallenge.view_model.PullRequestsViewModel
import com.example.helderrocha.githubchallenge.view_model.RepositoryViewModel

import com.example.helderrocha.githubchallenge.view_model.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.pull_requests_activity.*

import javax.inject.Inject

class PullRequestsActivity : AppCompatActivity() {
    @Inject
    lateinit var itemsVMFactory: ViewModelFactory<PullRequestsViewModel>

    private val itemsViewModel by lazy {
        ViewModelProviders.of(this, itemsVMFactory)[PullRequestsViewModel::class.java]
    }

//    protected val ItemsObserver = Observer<List<PullRequest>>(::onItemsFetched)
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_requests_activity)

        val data: Bundle = intent.extras

        var link = data.getBundle("link")


        Log.i("HELDER" , link.toString())
    itemsViewModel.getRepositories(link.toString())
    }

}
