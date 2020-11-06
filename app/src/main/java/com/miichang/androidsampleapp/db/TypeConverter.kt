package com.miichang.androidsampleapp.db

import androidx.room.TypeConverter
import com.miichang.androidsampleapp.DateConverter
import java.net.URL
import java.util.*

object TypeConverter {
    @TypeConverter
    @JvmStatic
    fun timestampToDate(value: String): Date {
        return DateConverter.convertStringToDate(
          value,
          DateConverter.DatePattern.RFC3339
        )
    }

    @TypeConverter
    @JvmStatic
    fun dateToTimestamp(date: Date): String {
        return DateConverter.convertDateToString(
          date,
          DateConverter.DatePattern.RFC3339
        )
    }

    @TypeConverter
    @JvmStatic
    fun stringToUrl(value: String): URL {
        return URL(value)
    }

    @TypeConverter
    @JvmStatic
    fun urlToString(url: URL): String {
        return url.toString()
    }
}
