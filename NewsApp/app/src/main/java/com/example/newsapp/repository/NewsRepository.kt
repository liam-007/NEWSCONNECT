package com.example.newsapp.repository


import androidx.lifecycle.LiveData
import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    // Insert or update an article
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    // Get all favorite articles for a specific user
    fun getFavouriteNewsForUser(userId: String): LiveData<List<Article>> {
        return db.getArticleDao().getFavouriteNewsForUser(userId)
    }

    // Get all articles (non-user-specific)
    fun getFavouriteNews(): LiveData<List<Article>> {
        return db.getArticleDao().getALLArticles()
    }

    // Delete an article
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}