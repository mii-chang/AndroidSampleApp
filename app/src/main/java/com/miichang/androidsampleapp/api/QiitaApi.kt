package com.miichang.androidsampleapp.api

import com.miichang.androidsampleapp.api.json.ArticleJson
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QiitaApi {
    @GET("items")
    suspend fun getArticleList(
        @Query("page") page: Int,
        @Query("per_page") per: Int
    ): List<ArticleJson>

    @GET("items/{item_id}")
    suspend fun getArticle(
        @Path("item_id") itemId: String
    ): ArticleJson

}