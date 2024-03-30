package com.example.newyorkproject.api
import com.example.newyorkproject.data.response.PopularArticlesResponse
import com.example.newyorkproject.utils.Constants.PERIOD
import com.example.newyorkproject.utils.Constants.POPULAR_ARTICLES_END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NytAPI {

    @GET(POPULAR_ARTICLES_END_POINT)
    suspend fun getPopularArticles(
        @Path("type") type: String,
        @Path("period") period: String = PERIOD,
        @Query("api-key") apiKey: String = "q3bzP5tg6ZGtRJoVn0kyGamEUE1vkOdk"
    ): Response<PopularArticlesResponse>

}