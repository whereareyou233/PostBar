package com.example.common.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.common.R
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity() {

    companion object{
        const val INFO_IMAGE="info_image"
        const val INFO_TEXT ="info_text"
        const val INFO_NAME="info_name"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val Info_text=intent.getStringExtra(INFO_TEXT) ?: " "
        val Info_image=intent.getIntExtra(INFO_IMAGE,0)
        val Info_name=intent.getStringExtra(INFO_NAME) ?: " "

        info_text.text=Info_text
        info_title.text=Info_name
        image_info_content.setImageResource(Info_image)

        //浸入式状态栏
        val decorView =window.decorView
        decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor= Color.TRANSPARENT
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

//toolbar
        setSupportActionBar(toolbar_info_content)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar_info_content.title="详情"

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}