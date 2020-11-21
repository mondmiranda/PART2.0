package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class albums : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        val GridView = findViewById<GridView>(R.id.albumView) as GridView
        GridView.adapter = albumAdapter(applicationContext)
        GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
            val intent = Intent(this, albumsDetail::class.java)
            var songsToBeDisplay = arrayListOf<String>()
            var uri: String = ""

            if (position ==0){
                uri = "@drawable/sad"
                songsToBeDisplay.clear()
                songsToBeDisplay.addAll(resources.getStringArray(R.array.sadboi))

            } else if(position == 1){
                uri = "@drawable/taku"
                songsToBeDisplay.clear()
                songsToBeDisplay.addAll(resources.getStringArray(R.array.otaku))

            }
            else{
                uri = "@drawable/cool"
                songsToBeDisplay.clear()
                songsToBeDisplay.addAll(resources.getStringArray(R.array.hype))

            }

            intent.putStringArrayListExtra("songs", songsToBeDisplay)
            intent.putExtra("imageUri", uri)
            intent.putExtra("position",position)
            startActivity(intent)

        }


    }

}