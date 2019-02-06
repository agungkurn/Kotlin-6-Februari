package com.example.agung.todaysmovie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = resources.getStringArray(R.array.array_movie)
        val description = resources.getStringArray(R.array.array_description)
        val poster = resources.obtainTypedArray(R.array.array_poster)

        rv_movie.hasFixedSize()
        rv_movie.layoutManager = GridLayoutManager(this, 2)
        val adapter = MovieAdapter(this, poster, title, description)
        rv_movie.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
