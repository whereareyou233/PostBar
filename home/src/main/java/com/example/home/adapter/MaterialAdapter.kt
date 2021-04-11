package com.example.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R


class MaterialAdapter (val context: Context, val List :List<Int>):
    RecyclerView.Adapter<MaterialAdapter.ViewHolder>(){
        inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
            //在这里初始化你的item控件实例
            val image : ImageView = view.findViewById(R.id.item_material_list_image)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view= LayoutInflater.from(parent.context).inflate(R.layout.item_material_list,parent,false)
            val holder=ViewHolder(view)
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val content =List[position]
            holder.image.setImageResource(content)
        }

        override fun getItemCount()=List.size
    }
