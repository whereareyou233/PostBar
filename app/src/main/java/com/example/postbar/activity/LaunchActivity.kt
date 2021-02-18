package com.example.postbar.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.postbar.Myapplication
import com.example.postbar.R
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity : AppCompatActivity() {

    val updateHandler = object :Handler() {
        override fun dispatchMessage(msg: Message)
        {  super.dispatchMessage(msg)

            when(msg.what)
            {
                1->{
                            val intent=Intent(Myapplication.context,MainActivity::class.java)
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK )
                            Myapplication.context.startActivity(intent)
                            finish()
                }
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        //延时进入主页
        updateHandler.sendEmptyMessageDelayed(1, 3000)

        jump_pb.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            this.startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (updateHandler != null) {
            updateHandler.removeCallbacksAndMessages(null);
        }
    }




}