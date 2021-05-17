package com.marysugar.github_users_list.api

import com.marysugar.github_users_list.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUserAsync(): Response<List<User>>
}