package com.example.helderrocha.githubchallenge.pull_requests.adapter


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.helderrocha.githubchallenge.R
import com.example.helderrocha.githubchallenge.model.PullRequest
import kotlinx.android.synthetic.main.pull_item.view.*

class PullRequestAdapter (var pullRequests: List<PullRequest>, val clickListener: (PullRequest) -> Unit) : RecyclerView.Adapter<PullRequestAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: PullRequest, clickListener: (PullRequest) -> Unit) {
            itemView.pullTitle.text = item.title
            itemView.pullBody.text = item.body
            itemView.pullUserName.text = item.user.login
//            itemView.genresTextView.text = movie.genres?.joinToString(separator = ", ") { it.name }
//            itemView.releaseDateTextView.text = movie.releaseDate
            itemView.setOnClickListener { clickListener(item)}
//            Glide.with(itemView)
//                    .load(movie.posterPath?.let { movieImageUrlBuilder.buildPosterUrl(it) })
//                    .apply(RequestOptions().placeholder(R.drawable.ic_image_placeholder))
//                    .into(itemView.posterImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pull_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = pullRequests.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        (holder as ViewHolder).bind(pullRequests[position], clickListener)
    }
}
