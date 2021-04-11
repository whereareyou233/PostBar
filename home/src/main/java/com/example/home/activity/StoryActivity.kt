package com.example.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home.R
import com.example.home.adapter.StoryContent
import com.example.home.adapter.StoryHorizontalContent
import com.example.home.model.StoryInfo
import kotlinx.android.synthetic.main.activity_story.*
import kotlinx.android.synthetic.main.home_fragment.*

class StoryActivity : AppCompatActivity() {

    val storylist=ArrayList<StoryInfo>()
    val storylist2=ArrayList<StoryInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

//初始化list
        storylist.add(StoryInfo(R.drawable.sucaih,"一切灵感都来于自然"))
        storylist.add(StoryInfo(R.drawable.sucaih2,"晚间的港口总是能给人带来慰籍"))

        storylist2.add(StoryInfo(R.drawable.p0001,"战争胜利"))
        storylist2.add(StoryInfo(R.drawable.p0002,"国家图书馆"))
        storylist2.add(StoryInfo(R.drawable.p0003,"中国火星探测"))
        storylist2.add(StoryInfo(R.drawable.p0004,"鄱阳湖"))
        storylist2.add(StoryInfo(R.drawable.p0005,"五牛图"))
        storylist2.add(StoryInfo(R.drawable.p0006,"澳门回归"))

        //点击事件

        bt_return_story.setOnClickListener { finish() }


        //设置横向recyclerview
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.HORIZONTAL
        recyclerview_home_story.layoutManager=layoutManager
        val adapter=StoryHorizontalContent(this,storylist)
        recyclerview_home_story.adapter=adapter

        //设置竖排recyclerview
        val layoutManager2=GridLayoutManager(this,2)
        recyclerview_home_story_2.layoutManager=layoutManager2
        val adapter2 = StoryContent(this,storylist2)
        recyclerview_home_story_2.adapter=adapter2

    }
}