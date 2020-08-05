package maze.run.facebookversiontwo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import maze.run.facebookversiontwo.R
import maze.run.facebookversiontwo.data.PostsViewModel
import maze.run.facebookversiontwo.ui.adapter.adapterforposts

class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel:PostsViewModel
    lateinit var adapterforposts: adapterforposts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postsViewModel=ViewModelProviders.of(this).get(PostsViewModel::class.java)
        adapterforposts= adapterforposts()
        rec_items.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        )
        postsViewModel.getposts().observe(this, Observer { posts->
            Log.d(TAG, "ffd: ")
            Log.d(Companion.TAG, "ffd: "+posts.get(0).title)
            adapterforposts.setlist(posts)
            rec_items.adapter=adapterforposts
        })

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}