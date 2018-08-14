package com.example.helderrocha.githubchallenge.repository

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast

import com.example.helderrocha.githubchallenge.R
import com.example.helderrocha.githubchallenge.model.Items
import com.example.helderrocha.githubchallenge.repository.adapter.ItemAdapter
import com.example.helderrocha.githubchallenge.view_model.RepositoryViewModel
import com.example.helderrocha.githubchallenge.view_model.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.repositorios_activity.*
import javax.inject.Inject


class RepositoriosActivity : AppCompatActivity() {
    @Inject
    lateinit var itemsVMFactory: ViewModelFactory<RepositoryViewModel>

    private val itemsViewModel by lazy {
        ViewModelProviders.of(this, itemsVMFactory)[RepositoryViewModel::class.java]
    }
    
    protected val ItemsObserver = Observer<List<Items>>(::onItemsFetched)
    private lateinit var adapter: ItemAdapter
    var layoutManager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repositorios_activity)

        itemsViewModel.repositories.observe(this, ItemsObserver)
        itemsViewModel.getRepositories()


    }
    
    private fun onItemsFetched(newItems: List<Items>?) {
        if (newItems != null) {
            Toast.makeText(this, newItems.get(1).name, Toast.LENGTH_SHORT).show()
            adapter = ItemAdapter(newItems, { item: Items -> partItemClicked(item) } )
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        } else {
            Toast.makeText(this, "There is no", Toast.LENGTH_SHORT).show()
        }

    }

    private fun partItemClicked(item : Items) {
//        val showDetailActivityIntent = Intent(this, DetailsActivity::class.java)
//        showDetailActivityIntent.putExtra("movie_selected", movie.id)
//        startApartItemClickedctivity(showDetailActivityIntent)
    }
}
