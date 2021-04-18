package com.example.common.Bean

import androidx.room.Entity
import androidx.room.PrimaryKey


//收藏邮票表
@Entity
data class Post(val PCname :String,val Pimage:String) {
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}