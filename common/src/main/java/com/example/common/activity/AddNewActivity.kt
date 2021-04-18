package com.example.common.activity

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.common.Bean.PostCollection
import com.example.common.Dao.PostCollectionDao
import com.example.common.DataBase.AppDatabase
import com.example.common.R
import com.example.common.Util.GlideEngine
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import kotlinx.android.synthetic.main.activity_add_new.*
import java.io.ByteArrayOutputStream
import kotlin.concurrent.thread

class AddNewActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_CODE_CHOOSE: Int = 333
    }
    var name=""
    var imagebase=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        //点击事件
        return_add_new.setOnClickListener { finish() }
        image.setOnClickListener { openPhoto() }
        finish_add_new.setOnClickListener {
              if (edit_name.text.toString().isNotEmpty()&&imagebase!=""){
                  name=edit_name.text.toString()
                  thread {
                      AppDatabase.getDatabase(this).postCollectionDao()
                          .insertPC(PostCollection(name, imagebase))
                  }
                  //打开邮集
                  val intent=Intent(this,CollectionActivity::class.java)
                  intent.putExtra(CollectionActivity.PC_NAME,edit_name.text.toString())
                  intent.putExtra(CollectionActivity.SOURCE,"addnew")
                  startActivity(intent)
                  finish()
              }else{
            Toast.makeText(this,"名称或封面不能为空！",Toast.LENGTH_SHORT).show()
                    }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
            val results = PictureSelector.obtainMultipleResult(data)
            //将图片转化为base64
            val bitmap =getBitmapFromUrl(Uri.parse(results[0].path))
            val  os= ByteArrayOutputStream()
            bitmap?.compress(Bitmap.CompressFormat.PNG,10,os)
            val byte =os.toByteArray()
            val base= Base64.encodeToString(byte, Base64.DEFAULT)
            imagebase=base
            Glide.with(this).load(results[0].path).into(image)
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

    private fun getBitmapFromUrl(uri: Uri) =this.contentResolver.openAssetFileDescriptor(uri, "r")?.use {
        BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
    }
}