package com.example.home.activity

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.home.R
import com.example.home.Util.GlideEngine
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import kotlinx.android.synthetic.main.activity_play.*
import kotlinx.android.synthetic.main.dialog_id.*
import kotlinx.android.synthetic.main.dialog_mc.*
import kotlinx.android.synthetic.main.dialog_mc.cancel
import kotlinx.android.synthetic.main.dialog_mc.define

class PlayActivity : AppCompatActivity() {

    companion object {

        private const val REQUEST_CODE_CHOOSE: Int = 111
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        //点击事件
        return_play.setOnClickListener { finish() }
        save_play.setOnClickListener { val bitmap=photo_play.getDrawingCache()
            }
        bt_openphoto_play.setOnClickListener { openPhoto() }
        bt_mc.setOnClickListener { showdialogmc() }

        bt_id.setOnClickListener { showdialid() }

        photo_play.setDrawingCacheEnabled(true)
        photo_play.buildDrawingCache()

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
            val results = PictureSelector.obtainMultipleResult(data)
            Glide.with(this).load(results[0].path).into(image_play)
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

    private fun showdialogmc(){
        val dialog = Dialog(this, R.style.DialogTheme)//设置style
        val view= View.inflate(this, R.layout.dialog_mc, null)//设置布局
        dialog.setContentView(view)

        val window =dialog.window
        window?.setGravity(Gravity.BOTTOM) //设置弹出位置
        window?.setWindowAnimations(R.style.main_menu_animStyle)//设置弹出动画
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)//设置弹出框大小
        dialog.show()
       dialog.cancel.setOnClickListener { dialog.dismiss() }
        dialog.define.setOnClickListener { name_play.text= dialog.edit_mc.text.toString()+"       "
        dialog.dismiss()}
                            }

    private fun showdialid(){
        val dialog = Dialog(this, R.style.DialogTheme)//设置style
        val view= View.inflate(this, R.layout.dialog_id, null)//设置布局
        dialog.setContentView(view)

        val window =dialog.window
        window?.setGravity(Gravity.BOTTOM) //设置弹出位置
        window?.setWindowAnimations(R.style.main_menu_animStyle)//设置弹出动画
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)//设置弹出框大小
        dialog.show()
        dialog.cancel.setOnClickListener { dialog.dismiss() }
        dialog.define.setOnClickListener { idname_play.text= dialog.edit_id.text.toString()
            dialog.dismiss()}
                             }
}