package com.marysugar.github_users_list

import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUserAsync(): Response<List<User>>
}