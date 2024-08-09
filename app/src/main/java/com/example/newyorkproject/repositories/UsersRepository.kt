package com.example.newyorkproject.repositories

import com.cheezycode.daggermvvm.models.Users
import com.example.newyorkproject.api.UserApiServices
import javax.inject.Inject

class UsersRepository @Inject constructor(private val userApiServices: UserApiServices) {

    suspend fun fetchUsers():List<Users>{
        var result = userApiServices.getUsers()
        return result
    }
}