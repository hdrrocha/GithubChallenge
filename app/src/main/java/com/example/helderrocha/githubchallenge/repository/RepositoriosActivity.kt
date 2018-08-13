package com.example.helderrocha.githubchallenge.repository

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.helderrocha.githubchallenge.R
import com.example.helderrocha.githubchallenge.model.Repository
import com.example.helderrocha.githubchallenge.view_model.RepositoryViewModel
import com.example.helderrocha.githubchallenge.view_model.ViewModelFactory

import javax.inject.Inject


class RepositoriosActivity : AppCompatActivity() {
//    @Inject
//    lateinit var repositoryVMFactory: ViewModelFactory<RepositoryViewModel>
//
//    private val repositoryViewModel by lazy {
//        ViewModelProviders.of(this,repositoryVMFactory)[RepositoryViewModel::class.java]
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repositorios_activity)
//        repositoryViewModel.getData().observe(this, Observer(updateList))
    }

    private val updateList: (List<Repository>?) -> Unit = {
//        loading = true
        val  listRepositoryLocal: List<Repository>
        listRepositoryLocal = (it as ArrayList<Repository>)
//        setUpdateAdapter(listMovieLocal, true)
    }

}
