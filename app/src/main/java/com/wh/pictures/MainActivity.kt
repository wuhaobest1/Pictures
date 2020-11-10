package com.wh.pictures

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import com.unsplash.pickerandroid.photopicker.presentation.UnsplashPickerActivity
import com.wh.pictures.data.entity.Picture

class MainActivity : AppCompatActivity() {

    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "wh_picture"
        ).build()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {

            val photos: ArrayList<UnsplashPhoto>? =
                data?.getParcelableArrayListExtra(UnsplashPickerActivity.EXTRA_PHOTOS)

            Thread {
                for (p: UnsplashPhoto in photos!!) {
                    Log.e(TAG, "current photo is : " + p.toString())
                    val pic = Picture(
                        p.id, p.created_at, p.width, p.height, p.color,
                        p.likes, p.description, p.urls.raw, p.links.self, p.user.id
                    )
                    db.pictureDao().insertPicture(pic)
                }
            }.start()

            Thread {
                Log.e(TAG, "get all : " + db.pictureDao().getAll().toString())
            }.start()
        } else {
            Toast.makeText(this, "没有新图片添加！", Toast.LENGTH_LONG).show()
        }
    }

    fun openPicker(view: View) {
        Log.e(TAG, "openPicker")
        startActivityForResult(
            UnsplashPickerActivity.getStartingIntent(
                this, // context
                true
            ), REQUEST_CODE
        )
    }

    companion object {
        const val REQUEST_CODE = 1000
        const val TAG = "MainActivity"
    }

}