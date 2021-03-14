package com.example.home.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Interpolator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.home.R
import kotlinx.android.synthetic.main.activity_add_select.*

class AddSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_select)


        //点击事件
        bt_return_add.setOnClickListener { finish()}

    /*    val animatorX = ObjectAnimator.ofFloat(bt_new,"scaleX",1.0f,1.8f);
       val animatorY = ObjectAnimator.ofFloat(bt_new,"scaleY",1.0f,1.8f);
        val set = AnimatorSet();
        set.setDuration(1000);
        set.playTogether(animatorX,animatorY);
        set.start()*/
    }
}