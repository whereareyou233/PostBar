package com.example.user.activity

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.home.Fragment.HomeFragment
import com.example.home.Util.GlideEngine
import com.example.user.R
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import kotlinx.android.synthetic.main.activity_personal_information.*
import kotlinx.android.synthetic.main.dialog_name_user.*
import kotlinx.android.synthetic.main.dialog_signature_user.*

class PersonalInformationActivity : AppCompatActivity() {


    companion object {
        private const val REQUEST_CODE_CHOOSE: Int = 888
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)

        //设置浸入式状态栏
        val decorView =window.decorView
        decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor= Color.TRANSPARENT
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        //点击事件
        bt_return_information.setOnClickListener { finish() }
        bt_head.setOnClickListener { openPhoto() }
        bt_name.setOnClickListener { showdialogname() }
        bt_signature.setOnClickListener { showdialogsignature() }
    }


    private fun showdialogname(){
        val dialog = Dialog(this, R.style.DialogTheme)//设置style
        val view=View.inflate(this, R.layout.dialog_name_user, null)//设置布局
        dialog.setContentView(view)

        val window =dialog.window
        window?.setGravity(Gravity.CENTER) //设置弹出位置
        window?.setWindowAnimations(R.style.main_menu_animStyle)//设置弹出动画
        window?.setLayout(800, ViewGroup.LayoutParams.WRAP_CONTENT)//设置弹出框大小
        dialog.show()
        dialog.cancel_name.setOnClickListener { dialog.dismiss()  }
        dialog.confirm_name.setOnClickListener { name_user.setText(dialog?.edit_name.text.toString())
        dialog.dismiss()}

    }

    private fun showdialogsignature(){
        val dialog = Dialog(this, R.style.DialogTheme)//设置style
        val view=View.inflate(this, R.layout.dialog_signature_user, null)//设置布局
        dialog.setContentView(view)

        val window =dialog.window
        window?.setGravity(Gravity.CENTER) //设置弹出位置
        window?.setWindowAnimations(R.style.main_menu_animStyle)//设置弹出动画
        window?.setLayout(800, ViewGroup.LayoutParams.WRAP_CONTENT)//设置弹出框大小
        dialog.show()
        dialog.cancel_signature.setOnClickListener { dialog.dismiss()  }
        dialog.confirm_signature.setOnClickListener { signature_user.setText(dialog?.edit_signature.text.toString())
            dialog.dismiss()}

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
            val results = PictureSelector.obtainMultipleResult(data)
            Glide.with(this).load(results[0].path).into(head_user)
            }}



    private fun openPhoto() {
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofImage())
            .imageEngine(GlideEngine.createGlideEngine())
            .isWeChatStyle(false)// 是否开启微信图片选择风格
            .imageSpanCount(3)// 每行显示个数
            .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) // 设置相册Activity方向，不设置默认使用系统
            .isPreviewImage(true)// 是否可预览图片
            .maxSelectNum(1)
            .isMaxSelectEnabledMask(true) // 选择数到了最大阀值列表是否启用蒙层效果
            .forResult(REQUEST_CODE_CHOOSE)
    }

}