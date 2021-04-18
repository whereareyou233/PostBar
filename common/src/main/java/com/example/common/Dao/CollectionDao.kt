package com.example.common.Dao

import androidx.room.*
import com.example.common.Bean.Collection

@Dao
interface CollectionDao {
    @Insert
    fun insertC(c : Collection):Long
    @Update
    fun updateC(newc : Collection)
    @Query(" select * from Collection")
    fun AllC():List<Collection>
    @Delete
    fun deleteC(c : Collection)
}