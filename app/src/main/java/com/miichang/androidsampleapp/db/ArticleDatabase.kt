package com.miichang.androidsampleapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.miichang.androidsampleapp.Article

@Database(
    entities = [
        Article::class
    ],
    version = 1
)
@TypeConverters(TypeConverter::class)
abstract class ArticleDatabase : RoomDatabase() {
    companion object {
        fun create(context: Context): ArticleDatabase =
            Room.databaseBuilder(
                context,
                ArticleDatabase::class.java,
                "article-database"
            ).build()
    }

    abstract fun articleDao(): ArticleDao
}
