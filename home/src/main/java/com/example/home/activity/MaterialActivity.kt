package com.example.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home.R
import com.example.home.adapter.MaterialAdapter
import kotlinx.android.synthetic.main.activity_material.*

class MaterialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)


        //点击事件
        return_material.setOnClickListener { finish() }

        //初始化list
        val list=ArrayList<Int>()
        list.add(R.drawable.p00001)
        list.add(R.drawable.p00002)
        list.add(R.drawable.p00003)
        list.add(R.drawable.p00004)
        list.add(R.drawable.p00005)
        list.add(R.drawable.p00006)
        list.add(R.drawable.p00007)
        list.add(R.drawable.p00008)
        list.add(R.drawable.p00009)
        list.add(R.drawable.p00010)
        list.add(R.drawable.p00012)
        list.add(R.drawable.p00011)
        list.add(R.drawable.p00013)

        //初始化recycleview
        val linearlayout =GridLayoutManager(this,2)
        list_material.layoutManager=linearlayout
        val adapter =MaterialAdapter(this,list)
        list_material.adapter=adapter
    }
}