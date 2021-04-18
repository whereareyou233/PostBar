package com.example.common.Dao

import androidx.room.*
import com.example.common.Bean.Play

@Dao
interface PlayDao {
    @Insert
    fun insertPlay(play: Play):Long
    @Update
    fun updatePlay(newplay: Play)
    @Query(" select * from Play")
    fun AllPlay():List<Play>
    @Delete
    fun deletePlay(play: Play)
}