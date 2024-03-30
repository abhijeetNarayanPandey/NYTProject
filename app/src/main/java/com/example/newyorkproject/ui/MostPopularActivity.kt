package com.example.newyorkproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorkproject.R
import com.example.newyorkproject.adapter.ArticlesAdapter
import com.example.newyorkproject.utils.Resource
import com.example.newyorkproject.viewmodels.ArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostPopularActivity : AppCompatActivity() {
    lateinit var mainViewModel: ArticlesViewModel
     val recyclerView: RecyclerView
     get() = findViewById(R.id.rvArticles)
     val progressBar : ProgressBar
    get() = findViewById(R.id.progressBar)
    lateinit var articlesAdapter: ArticlesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_most_popular)
        mainViewModel = ViewModelProvider(this).get(ArticlesViewModel::class.java)
        mainViewModel.newsLiveData.observe(this, Observer {response->
            when(response) {
                is Resource.Loading ->{
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    articlesAdapter = ArticlesAdapter(response.data?.articles)

                    recyclerView.adapter = articlesAdapter
                    progressBar.visibility = View.GONE

                }
                is Resource.Error ->{
                    progressBar.visibility = View.VISIBLE
                }
            }
        })
    }
}
