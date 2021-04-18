package com.example.common.Dao

import androidx.room.*
import com.example.common.Bean.Post

@Dao
interface PostDao {
    @Insert
    fun insertP(p :Post):Long
    @Update
    fun updateP(newp:Post)
    @Query(" select * from Post")
    fun AllP():List<Post>
    @Delete
    fun deleteP(p: Post)
    @Query("select * from Post where PCname =:pcname")
    fun findp(pcname:String):List<Post>
}