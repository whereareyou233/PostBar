package com.example.common.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.common.R
import kotlinx.android.synthetic.main.activity_stamp_collection.*

class StampCollectionActivity : AppCompatActivity() {
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
    }
}