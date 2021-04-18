package com.example.common.Bean

import androidx.room.Entity
import androidx.room.PrimaryKey

//邮集表
@Entity
data class PostCollection(val Cname:String,val Cimage :String) {
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}