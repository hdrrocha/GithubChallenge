package com.example.helderrocha.githubchallenge.repository

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View


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
    var totalItemCount: Int = 0
    var visibleItemCount: Int = 0
    var pastVisibleItemCount: Int = 0
    var loading: Boolean = false
    var page: Long = 1L

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repositorios_activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        itemsViewModel.repositories.observe(this, ItemsObserver)
        itemsViewModel.getRepositories(page)

    }
    
    private fun onItemsFetched(newItems: List<Items>?) {
        if (newItems != null) {
            loading = true
            setUpdateAdapter(newItems)
        } else {
            Toast.makeText(this, "There is no", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setUpdateAdapter(items: List<Items>){
        Toast.makeText(this, items.get(1).name, Toast.LENGTH_SHORT).show()
        adapter = ItemAdapter(items, { item: Items -> partItemClicked(item) } )
        recyclerView.adapter = adapter
        progressBar.visibility = View.GONE
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {


            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) {
                    Log.i("Helder","Rolando" + page)
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    Log.i("Helder","totalItemCount" + totalItemCount)
                    var total  = visibleItemCount+ pastVisibleItemCount
                    Log.i("Helder","visibleItemCount+ pastVisibleItemCount" + total)
                    pastVisibleItemCount =(recyclerView!!.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if(loading){
                        if((visibleItemCount+ pastVisibleItemCount) >= totalItemCount) {
                            progressBar.visibility = View.VISIBLE
                            loading = false
                            page++
                            itemsViewModel.getRepositories( page++)
                        }
                    }
                }

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }
    private fun partItemClicked(item : Items) {
//        val showDetailActivityIntent = Intent(this, DetailsActivity::class.java)
//        showDetailActivityIntent.putExtra("movie_selected", movie.id)
//        startApartItemClickedctivity(showDetailActivityIntent)
    }
}
