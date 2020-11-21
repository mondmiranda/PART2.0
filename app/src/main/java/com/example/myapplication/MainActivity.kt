package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*

class MainActivity : AppCompatActivity() {
    val queueListView = ArrayList<String>()

    val songsArray = arrayOf(
        "Bink's sake",
        "Hero's comeback",
        "Silhouette",
        "Black catcher",
        "Rockstar", "Ride",
        "The scotts", "changes",
        "Sad", "Everybody dies in their nightmares", "Jocelyn flores",
        "Look at me",
        "Ayo",
        "Bomb",
        "Question", "Go crazy",
        "Indigo",
        "Party",
        "With you",
        "Privacy",
        "Newflame",
        "Pie",
        "No limit",
        "Together",
        "No guidance")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //list view adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songsArray)
        val songsListView = findViewById<ListView>(R.id.songsListView)
        songsListView.adapter = adapter

        val listView = findViewById<ListView>(R.id.songsListView)
        registerForContextMenu(listView)
    }

    //Context Menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.song_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo //Allows us to inherit from the class Adapterview.AdapterCOntextMenuInfo to get the position
        return when (item.itemId) {
            R.id.add_queue -> {
                queueListView.add(songsArray[menuInfo.position])
                true
            }
            else -> {
                return super.onContextItemSelected(item)
            }

        }

    }

    //main menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.go_to_album -> {
                startActivity(Intent(this, albums::class.java))
                true
            }
            R.id.go_to_song -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            R.id.go_to_queue -> {
                val intent = Intent(this, songs_queue::class.java)
                intent.putStringArrayListExtra("songs", queueListView)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}