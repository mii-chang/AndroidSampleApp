package com.miichang.androidsampleapp

import android.app.Application
import com.miichang.androidsampleapp.api.QiitaApi
import com.miichang.androidsampleapp.api.QiitaApiFactory
import com.miichang.androidsampleapp.db.ArticleDao
import com.miichang.androidsampleapp.db.ArticleDatabase
import com.miichang.androidsampleapp.repository.ArticleRepository
import com.miichang.androidsampleapp.repository.ArticleRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
internal class AndroidSampleAppModule {
    @Provides
    @Singleton
    internal fun provideArticleDatabase(application: Application): ArticleDatabase =
        ArticleDatabase.create(application)

    @Provides
    @Singleton
    internal fun provideArticleDao(database: ArticleDatabase): ArticleDao = database.articleDao()

    @Provides
    @Singleton
    internal fun provideArticleRepository(
        qiitaApi: QiitaApi,
        articleDao: ArticleDao
    ): ArticleRepository = ArticleRepositoryImpl(
        qiitaApi,
        articleDao
    )

    @Provides
    @Singleton
    internal fun provideQiitaApi(): QiitaApi = QiitaApiFactory.create()
}