package com.example.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R
import com.example.home.model.StoryInfo

class StoryContent (val context: Context, val List :List<StoryInfo>):
        RecyclerView.Adapter<StoryContent.ViewHolder>(){
    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        //在这里初始化你的item控件实例
        val image : ImageView = view.findViewById(R.id.image_home_story)
        val text : TextView =view.findViewById(R.id.text_home_story)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_story_2,parent,false)
        val holder=ViewHolder(view)
        /* holder.itemView.setOnClickListener {
             val position=holder.adapterPosition
             val content=List[position]
             val intent= Intent(context, InfoContentActivity::class.java).apply {
                 putExtra(InfoContentActivity.INFO_IMAGE,content.image)
                 putExtra(InfoContentActivity.INFO_TEXT,content.text)
             }
             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
             context?.startActivity(intent)
         }*/
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content =List[position]
        holder.image.setImageResource(content.image)
        holder.text.setText(content.text)
    }

    override fun getItemCount()=List.size
}