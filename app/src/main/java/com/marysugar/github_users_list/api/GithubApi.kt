package com.marysugar.github_users_list.api

import com.marysugar.github_users_list.model.Repository
import com.marysugar.github_users_list.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    // ユーザーの一覧
    @GET("users")
    suspend fun users(): Response<List<User>>
    // ユーザーのリポジトリ一覧
    @GET("users/{user}/repos")
    suspend fun repositoryList(@Path("user") user: String): Response<List<Repository>>
}