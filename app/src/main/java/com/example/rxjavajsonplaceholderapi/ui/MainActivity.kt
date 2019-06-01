package com.example.rxjavajsonplaceholderapi.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.rxjavajsonplaceholderapi.R
import com.example.rxjavajsonplaceholderapi.adapter.PostAdapter
import com.example.rxjavajsonplaceholderapi.api_call.JsonplaceholderRetrofitInstance
import com.example.rxjavajsonplaceholderapi.api_call.PostsEndpoint
import com.example.rxjavajsonplaceholderapi.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var compositeDisposable: CompositeDisposable
    private lateinit var jsonplaceholderApi: PostsEndpoint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = JsonplaceholderRetrofitInstance.instance
        jsonplaceholderApi = retrofit.create(PostsEndpoint::class.java)
        main_recycler_view.setHasFixedSize(true)
        main_recycler_view.layoutManager = LinearLayoutManager(this)
        compositeDisposable = CompositeDisposable()
        fetchData()
    }

    private fun fetchData() {
        compositeDisposable.add(jsonplaceholderApi.fetchPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { posts -> displayData(posts) }
        )
    }

    private fun displayData(posts: ArrayList<Post>?) {
        val adapter = PostAdapter(this, posts!!)
        main_recycler_view.adapter = adapter
    }
}
