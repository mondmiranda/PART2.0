package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class songs_queue : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_queue)

        val songsToBeDisplayedList = intent.getStringArrayListExtra("songs")
        val songsToBeDisplayedArray = songsToBeDisplayedList!!.toTypedArray()
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsToBeDisplayedArray)
        val queuedSongsListView = findViewById<ListView>(R.id.viewList)
        queuedSongsListView.adapter = adapter
    }
}