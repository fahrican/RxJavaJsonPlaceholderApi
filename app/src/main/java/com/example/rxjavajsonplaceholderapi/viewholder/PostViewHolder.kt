package com.example.rxjavajsonplaceholderapi.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.post_card.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var title: TextView
    var body: TextView
    var textId: TextView

    init {
        title = itemView.post_title
        body = itemView.post_body
        textId = itemView.post_id
    }
}