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
import androidx.recyclerview.widget.GridLayoutManager
import com.example.common.Bean.Post
import com.example.common.DataBase.AppDatabase
import com.example.common.R
import com.example.common.Util.GlideEngine
import com.example.common.adapter.postadapter
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import kotlinx.android.synthetic.main.activity_collection.*
import java.io.ByteArrayOutputStream
import kotlin.concurrent.thread

class CollectionActivity : AppCompatActivity() {

    val postlist=ArrayList<Post>()
    var cname :String?=""
    companion object{
        const val PC_NAME="pc_name"
        const val SOURCE ="source"
        const val REQUEST_CODE_CHOOSE= 444
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)
//状态栏
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)


        val name=intent.getStringExtra(PC_NAME)
        cname=name
        val source=intent.getStringExtra(SOURCE)
        title_collection.text=name
        if (source=="old"&&name!=null){
            val postdao=AppDatabase.getDatabase(this).postDao()
            thread { val list=postdao.findp(name)
            for (i in list){
                postlist.add(i)
            }}
            Thread.sleep(200)
            val layoutManager=GridLayoutManager(this,2)
            recyclerview.layoutManager=layoutManager
            val adapter=postadapter(this,postlist)
            recyclerview.adapter=adapter
        }
        //点击事件
return_collection.setOnClickListener { finish() }
        add_post.setOnClickListener { openPhoto() }
    }
    fun adddata(name:String,base:List<String>){
        val postdao=AppDatabase.getDatabase(this).postDao()
        for (i in base){
        val post=Post(name,i)
        thread { postdao.insertP(post) }}
        Thread.sleep(200)

        //重新刷新列表
        postlist.clear()
        thread { val list=postdao.findp(name)
            for (i in list){
                postlist.add(i)
            }}
        Thread.sleep(200)
        val layoutManager=GridLayoutManager(this,2)
        recyclerview.layoutManager=layoutManager
        val adapter=postadapter(this,postlist)
        recyclerview.adapter=adapter
        //
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
            val results = PictureSelector.obtainMultipleResult(data)
            //将图片转化为base64
            val bases=ArrayList<String>()
            for (i in results){
            val bitmap =getBitmapFromUrl(Uri.parse(i.path))
            val  os= ByteArrayOutputStream()
            bitmap?.compress(Bitmap.CompressFormat.PNG,10,os)
            val byte =os.toByteArray()
            val base= Base64.encodeToString(byte, Base64.DEFAULT)
                bases.add(base)
        }
            cname?.let { adddata(it,bases) }

        }}

    private fun openPhoto() {
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofImage())
            .imageEngine(GlideEngine.createGlideEngine())
            .isWeChatStyle(false)// 是否开启微信图片选择风格
            .imageSpanCount(3)// 每行显示个数
            .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) // 设置相册Activity方向，不设置默认使用系统
            .isPreviewImage(true)// 是否可预览图片
            .maxSelectNum(9)
            .isMaxSelectEnabledMask(true) // 选择数到了最大阀值列表是否启用蒙层效果
            .forResult(REQUEST_CODE_CHOOSE)
    }

    private fun getBitmapFromUrl(uri: Uri) =this.contentResolver.openAssetFileDescriptor(uri, "r")?.use {
        BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
    }
}