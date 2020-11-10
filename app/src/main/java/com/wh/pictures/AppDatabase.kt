package com.wh.pictures

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wh.pictures.data.dao.PictureDao
import com.wh.pictures.data.entity.Picture

@Database(entities = [Picture::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pictureDao(): PictureDao
}