package com.example.common.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.Bean.Post
import com.example.common.R

class postadapter (val context: Context, val List :List<Post>):
    RecyclerView.Adapter<postadapter.ViewHolder>(){
    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        //在这里初始化你的item控件实例
        val image : ImageView = view.findViewById(R.id.p_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        val holder=ViewHolder(view)
       /* holder.itemView.setOnClickListener {
            val position=holder.adapterPosition
            val content=List[position]
            val intent= Intent(context, CollectionActivity::class.java).apply {
                putExtra(CollectionActivity.PC_NAME,content.Cname)
                putExtra(CollectionActivity.SOURCE,"old")
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }*/
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content =List[position]
        val deode= Base64.decode(content.Pimage, Base64.DEFAULT)
        val bitmap2= BitmapFactory.decodeByteArray(deode,0,deode.size)
        holder.image.setImageBitmap(bitmap2)
    }

    override fun getItemCount()=List.size
}