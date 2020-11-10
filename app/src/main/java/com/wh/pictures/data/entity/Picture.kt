package com.wh.pictures.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Picture(
    @ColumnInfo(name = "pid") var pId: String?,
    @ColumnInfo(name = "created_at") var created_at: String?,
    @ColumnInfo(name = "width") var width: Int?,
    @ColumnInfo(name = "height") var height: Int?,
    @ColumnInfo(name = "color") var color: String? = "#000000",
    @ColumnInfo(name = "likes") var likes: Int?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "urls") var urls: String?,
    @ColumnInfo(name = "links") var links: String?,
    @ColumnInfo(name = "user") var user: String?
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}