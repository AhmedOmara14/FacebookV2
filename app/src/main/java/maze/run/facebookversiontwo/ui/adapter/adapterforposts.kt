package maze.run.facebookversiontwo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layour_rec_posts.view.*
import maze.run.facebookversiontwo.R
import maze.run.facebookversiontwo.pojo.Posts

class adapterforposts : RecyclerView.Adapter<adapterforposts.viewholder>() {

    lateinit var listOfPosts:List<Posts>

    fun setlist(data: List<Posts>){
        listOfPosts=data
    }
    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun find(posts: Posts){
            itemView.userid.text=posts.userId.toString()
            itemView.title.text=posts.title
            itemView.body.text=posts.body

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.layour_rec_posts,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return listOfPosts.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val posts=listOfPosts[position]
        holder.find(posts)
    }
}