package com.miichang.androidsampleapp.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miichang.androidsampleapp.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bulkUpsert(articleList: List<Article>)

    @Query("SELECT * FROM articles ORDER BY `index` ASC")
    fun selectAll(): DataSource.Factory<Int, Article>

    @Query("SELECT MAX(`index`) FROM articles")
    fun getLastIndex(): Int

    @Query("DELETE FROM articles")
    suspend fun deleteAll()
}
