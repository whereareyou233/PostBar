package com.example.communication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.communication.R
import com.example.communication.activity.InfoContentActivity
import com.example.communication.model.RealTimeInfo

class RecyclerviewCommunity (val context: Context,val List :List<RealTimeInfo>):
        RecyclerView.Adapter<RecyclerviewCommunity.ViewHolder>(){
            inner class ViewHolder(view : View):RecyclerView.ViewHolder(view){
                //在这里初始化你的item控件实例
                val image :ImageView= view.findViewById(R.id.image_community)
                val text :TextView=view.findViewById(R.id.text_community)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_community,parent,false)
        val holder=ViewHolder(view)
        holder.itemView.setOnClickListener {
            val position=holder.adapterPosition
            val content=List[position]
            val intent=Intent(context,InfoContentActivity::class.java).apply {
                putExtra(InfoContentActivity.INFO_IMAGE,content.image)
                putExtra(InfoContentActivity.INFO_TEXT,content.text)
                putExtra(InfoContentActivity.INFO_NAME,content.name)
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content =List[position]
        holder.image.setImageResource(content.image)
        holder.text.setText(content.text)
    }

    override fun getItemCount()=List.size
}