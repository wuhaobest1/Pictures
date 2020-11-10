package com.wh.pictures.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wh.pictures.data.entity.Picture

@Dao
interface PictureDao {
    @Query("SELECT * FROM picture")
    fun getAll(): List<Picture>

    @Insert
    fun insertPicture(vararg picture: Picture)
}