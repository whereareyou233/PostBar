package com.example.common.Dao

import androidx.room.*
import com.example.common.Bean.PostCollection

@Dao
interface PostCollectionDao {
   @Insert
   fun insertPC(pc:PostCollection):Long
   @Update
   fun updatePC(newpc:PostCollection)
   @Query(" select * from PostCollection")
   fun AllPC():List<PostCollection>
   @Delete
   fun deletePC(pc:PostCollection)
}