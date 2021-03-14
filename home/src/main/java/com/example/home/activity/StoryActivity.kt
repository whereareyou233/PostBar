package com.example.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home.R
import com.example.home.adapter.StoryHorizontalContent
import com.example.home.model.StoryInfo
import kotlinx.android.synthetic.main.activity_story.*
import kotlinx.android.synthetic.main.home_fragment.*

class StoryActivity : AppCompatActivity() {

    val storylist=ArrayList<StoryInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)


        storylist.add(StoryInfo(R.drawable.sucaih,"一切灵感都来于自然"))
        storylist.add(StoryInfo(R.drawable.sucaih2,"晚间的港口总是能给人带来慰籍"))

        //点击事件

        bt_return_story.setOnClickListener { finish() }


        //设置横向recyclerview
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.HORIZONTAL
        recyclerview_home_story.layoutManager=layoutManager
        val adapter=StoryHorizontalContent(this,storylist)
        recyclerview_home_story.adapter=adapter
    }
}