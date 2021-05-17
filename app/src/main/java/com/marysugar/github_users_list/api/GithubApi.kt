package com.marysugar.github_users_list.api

import com.marysugar.github_users_list.model.Repository
import com.marysugar.github_users_list.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    // ユーザーの一覧
    @GET("users")
    suspend fun users(
        @Query("since") since: Int,
    ): Response<List<User>>
    // ユーザーのリポジトリ一覧
    @GET("users/{user}/repos")
    suspend fun repositoryList(@Path("user") user: String): Response<List<Repository>>
}