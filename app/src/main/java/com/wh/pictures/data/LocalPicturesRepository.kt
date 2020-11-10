package com.wh.pictures.data

import android.content.Context


private const val LOCAL_PICTURES_PREFERENCE_NAME = "local_pictures_name"

class LocalPicturesRepository private constructor(context: Context){

    private val sharedPreference =
        context.applicationContext.getSharedPreferences(LOCAL_PICTURES_PREFERENCE_NAME, Context.MODE_PRIVATE)



}