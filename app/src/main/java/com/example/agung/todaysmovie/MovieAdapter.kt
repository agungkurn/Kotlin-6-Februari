package com.example.agung.todaysmovie

import android.content.Context
import android.content.res.TypedArray
import android.support.annotation.DrawableRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_movie.view.*

class MovieAdapter(
    val context: Context,
    val posters: TypedArray,
    val titles: Array<String>,
    val descriptions: Array<String>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.list_movie, p0, false))
    }

    override fun onBindViewHolder(p0: MovieViewHolder, p1: Int) {
        p0.bindItem(titles[p1], descriptions[p1], posters.getResourceId(p1, 0))
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(title: String, description: String, @DrawableRes poster: Int) {
            Picasso.get()
                .load(poster)
                .into(itemView.iv_poster)

            itemView.setOnClickListener {
                Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
            }
        }
    }
}