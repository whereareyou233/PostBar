package com.example.common.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.common.Bean.Collection
import com.example.common.Bean.Play
import com.example.common.Bean.Post
import com.example.common.Bean.PostCollection
import com.example.common.Dao.CollectionDao
import com.example.common.Dao.PlayDao
import com.example.common.Dao.PostCollectionDao
import com.example.common.Dao.PostDao

@Database(version = 1,entities = [Post::class,Play::class,Collection::class,PostCollection::class ], exportSchema = false)
abstract class AppDatabase:RoomDatabase(){
    abstract fun postDao():PostDao
    abstract fun collectionDao():CollectionDao
    abstract fun playDao():PlayDao
    abstract fun postCollectionDao():PostCollectionDao

    companion object{
        private var instance:AppDatabase?=null
        @Synchronized
        fun getDatabase(context:Context):AppDatabase{
            instance?.let { return it }
            return Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java,"app_database")
                .build().apply { instance=this
                }
        }
    }
}