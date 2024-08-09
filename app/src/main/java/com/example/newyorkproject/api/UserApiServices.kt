package com.example.newyorkproject.api

import com.cheezycode.daggermvvm.models.Users
import retrofit2.http.GET

interface UserApiServices {
    @GET("users")
    suspend fun getUsers():List<Users>
}