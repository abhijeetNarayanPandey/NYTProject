package com.example.newyorkproject.adapter

import android.R
import android.content.Context
import android.support.annotation.NonNull
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorkproject.data.response.PopularArticlesResponse
import com.example.newyorkproject.data.response.PopularArticlesResponse.Article
import com.google.android.material.textview.MaterialTextView


class ArticlesAdapter(val articleList:List<PopularArticlesResponse.Article>?):RecyclerView.Adapter<ArticlesAdapter.ViewHolder>(){

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(com.example.newyorkproject.R.layout.item_articles, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = articleList?.get(position)

        // sets the image to the imageview from our itemHolder class

        // sets the text to the textview from our itemHolder class
        //   loadImageThumb(binding.ivThumb, article)
        holder.tvHeading.text = ItemsViewModel!!.title
        holder.tvDescription.text = ItemsViewModel!!.abstract

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return articleList!!.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val tvHeading: MaterialTextView = itemView.findViewById(com.example.newyorkproject.R.id.tvHeading)
        val tvDescription: MaterialTextView = itemView.findViewById(com.example.newyorkproject.R.id.tvDescription)
    }
}
