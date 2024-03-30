package com.example.newyorkproject.repositories

import com.example.newyorkproject.api.NytAPI
import com.example.newyorkproject.utils.Constants.MOST_VIEWED
import javax.inject.Inject

class NewsShowsRepository @Inject constructor(var newsApi: NytAPI) {
    suspend fun getNews() = newsApi.getPopularArticles(MOST_VIEWED)
}