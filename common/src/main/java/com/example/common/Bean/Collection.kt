package com.example.common.Bean

import androidx.room.Entity
import androidx.room.PrimaryKey


//收藏表
@Entity
 data class Collection (val name:String,val content:String,val image:String){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}