package com.example.common.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.common.Bean.PostCollection
import com.example.common.DataBase.AppDatabase
import com.example.common.R
import com.example.common.adapter.postcollectionadapter
import kotlinx.android.synthetic.main.activity_stamp_collection.*
import kotlin.concurrent.thread

class StampCollectionActivity : AppCompatActivity() {
    val pclist=ArrayList<PostCollection>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp_collection)
 //状态栏
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)


        //判断跳转源头
        val source =intent.getStringExtra("source")
        if (source=="AddSelectActivity"){
            add.visibility= View.GONE
        }

        //点击事件
        return_stampcollection.setOnClickListener { finish() }
        add.setOnClickListener { val intent= Intent(this,AddNewActivity::class.java)
            startActivity(intent) }
        getdata()
    }

    fun getdata(){
        val pc =AppDatabase.getDatabase(this).postCollectionDao()

       thread{val list1=pc.AllPC()
         for (i in list1){
             pclist.add(i)
         }
       }
        Thread.sleep(100)
        if (pclist.size>0){

      recyclerview.visibility=View.VISIBLE
           nocontent.visibility=View.GONE
        val layoutManager= GridLayoutManager(this,2)
        recyclerview.layoutManager=layoutManager
        val adapter=postcollectionadapter(this,pclist)
        recyclerview.adapter=adapter  }
    }
}