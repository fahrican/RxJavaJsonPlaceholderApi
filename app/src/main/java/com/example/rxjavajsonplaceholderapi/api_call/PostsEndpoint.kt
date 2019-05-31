package com.example.rxjavajsonplaceholderapi.api_call

import com.example.rxjavajsonplaceholderapi.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostsEndpoint {

    @GET("posts")
    fun fetchPosts(): Observable<List<Post>>
}