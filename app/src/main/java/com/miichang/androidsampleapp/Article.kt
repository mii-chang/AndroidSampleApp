package com.miichang.androidsampleapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.miichang.androidsampleapp.db.TypeConverter
import java.net.URL
import java.util.*

@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "rendered_body")
    val renderedBody: String,
    val body: String,
    @ColumnInfo(name = "created_at")
    @TypeConverters(TypeConverter::class)
    val createdAt: Date,
    val title: String,
    @TypeConverters(TypeConverter::class)
    val url: URL,
    @ColumnInfo(name = "user_id")
    val userId: String,
    val index: Int = -1
)