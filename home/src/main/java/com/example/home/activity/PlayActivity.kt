package com.example.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.home.R
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        //点击事件
        return_play.setOnClickListener { finish() }
    }
}