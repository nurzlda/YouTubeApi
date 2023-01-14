package com.example.youtubeapi.local

import androidx.room.TypeConverter
import com.example.youtubeapi.model.Item
import com.example.youtubeapi.model.PageInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object Converter {
    val gson = Gson()

    @TypeConverter
    fun jsonToItems(data : String?): List<Item>{
        val listType: Type = object : TypeToken<List<Item>>() {}.type
                return  gson.fromJson(data,listType)
    }

    @TypeConverter
    fun itemToString(items : List<Item>) : String{
        return gson.toJson(items)
    }

    @TypeConverter
    fun pageInfoToString(pageInfo: PageInfo): String{
        return gson.toJson(pageInfo)
    }

    @TypeConverter
    fun jsonToPageInfo(data: String?): PageInfo{
        return gson.fromJson(data, PageInfo :: class.java)
    }
}