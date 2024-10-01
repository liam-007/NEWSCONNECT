package com.example.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.models.Article

@Dao
interface ArticleDAO {

    // Insert or update an article
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    // Fetch all favorite articles for a specific user
    @Query("SELECT * FROM articles WHERE userId = :userId")
    fun getFavouriteNewsForUser(userId: String): LiveData<List<Article>>

    // Fetch all favorite articles (non-user-specific)
    @Query("SELECT * FROM articles")
    fun getALLArticles(): LiveData<List<Article>>

    // Delete an article
    @Delete
    suspend fun deleteArticle(article: Article)
}
