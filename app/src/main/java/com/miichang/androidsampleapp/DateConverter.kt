package com.miichang.androidsampleapp

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {
    object DatePattern {
        const val RFC3339 = "yyyy-MM-dd'T'HH:mm:ssXXX"
    }

    fun convertStringToDate(date: String, pattern: String): Date {
        val simpleDateFormat = SimpleDateFormat(
          pattern,
          Locale.ENGLISH
        ).apply {
            timeZone = TimeZone.getTimeZone("Asia/Tokyo")
        }
        return simpleDateFormat.parse(date) ?: throw DateConverterException(date, pattern)
    }

    fun convertDateToString(date: Date, pattern: String): String {
        val simpleDateFormat = SimpleDateFormat(
          pattern,
          Locale.ENGLISH
        ).apply {
            timeZone = TimeZone.getTimeZone("Asia/Tokyo")
        }
        return simpleDateFormat.format(date) ?: throw DateConverterException(date, pattern)
    }
}

class DateConverterException(
  date: Any,
  pattern: String
) : ParseException(
  "Unparseable date $date," +
          "format: $pattern",
  0
)
