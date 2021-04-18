package com.example.common.Bean

import androidx.room.Entity
import androidx.room.PrimaryKey

//自制表
@Entity
data class Play(val image:String) {
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}