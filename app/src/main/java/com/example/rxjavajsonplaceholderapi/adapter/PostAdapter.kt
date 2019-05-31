package com.example.rxjavajsonplaceholderapi.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rxjavajsonplaceholderapi.R
import com.example.rxjavajsonplaceholderapi.model.Post
import com.example.rxjavajsonplaceholderapi.viewholder.PostViewHolder

class PostAdapter(
    private val context: Context,
    private val postList: ArrayList<Post>
) : RecyclerView.Adapter<PostViewHolder>() {

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.post_card, p0, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: PostViewHolder, p1: Int) {
        p0.title.text = postList.get(p1).title
        p0.body.text = postList.get(p1).body
        p0.textId.text = postList.get(p1).id.toString()
    }
}