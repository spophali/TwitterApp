package com.example.twitterapp.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Feed
import com.example.twitterapp.databinding.FeedItemViewBinding

class FeedAdapter(
    private val feedList: List<Feed>
) : RecyclerView.Adapter<FeedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            FeedItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.setFeedData(feedList[position])
    }


}