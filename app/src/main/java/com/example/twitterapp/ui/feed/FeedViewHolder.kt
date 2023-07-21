package com.example.twitterapp.ui.feed

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.Feed
import com.example.twitterapp.R
import com.example.twitterapp.databinding.FeedItemViewBinding

class FeedViewHolder(val binding: FeedItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setFeedData(feed: Feed) {
        with(binding) {
            Glide.with(root.context)
                .load(feed.profilePic)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.error)
                .into(profilePicIv)

            nameTv.text = feed.name
            usernameTv.text = feed.userName
            bluetickIv.isVisible = feed.blueTick
            dateTv.text = feed.date
            descriptionTv.text = feed.description
            commentsTv.text = feed.comments
            viewsTv.text = feed.views
            likeTv.text = feed.likes
            retweetTv.text = feed.retweets
        }

    }
}