package com.example.news_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.databinding.ActivityMainBinding

import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import org.jsoup.Jsoup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var newsAdapter : NewsAdapter
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://news.google.com/")
        .addConverterFactory(
            TikXmlConverterFactory.create(
                TikXml.Builder()
                    .exceptionOnUnreadXml(false)
                    .build()
            )
        ).build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newsAdapter = NewsAdapter()
        val newsService = retrofit.create(NewsService::class.java)
        binding.newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }
        binding.feedChip.setOnClickListener {
            binding.chipGroup.clearCheck()
            binding.feedChip.isChecked=true
            newsService.mainFeed().submitList()
        }
        binding.politicsChip.setOnClickListener {
            binding.chipGroup.clearCheck()
            binding.politicsChip.isChecked=true
            newsService.politicsNews().submitList()

        }
        binding.economyChip.setOnClickListener {
            binding.chipGroup.clearCheck()
            binding.economyChip.isChecked=true
            newsService.economyNews().submitList()
        }
        binding.societyChip.setOnClickListener {
            binding.chipGroup.clearCheck()
            binding.societyChip.isChecked=true
            newsService.societysNews().submitList()
        }
        binding.itChip.setOnClickListener {
            binding.chipGroup.clearCheck()
            binding.itChip.isChecked=true
            newsService.itNews().submitList()
        }
        binding.sportChip.setOnClickListener {
            binding.chipGroup.clearCheck()
            binding.sportChip.isChecked=true
            newsService.sportNews().submitList()
        }

        binding.searchTextInputEditText.setOnEditorActionListener { textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_SEARCH){
                binding.chipGroup.clearCheck()

                binding.searchTextInputEditText.clearFocus()
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(textView.windowToken,0)
                newsService.search(binding.searchTextInputEditText.text.toString()).submitList()

                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding.feedChip.isChecked=true
        newsService.mainFeed().submitList()
    }
    private fun Call<NewsRss>.submitList(){
        enqueue(object : Callback<NewsRss>{
            override fun onResponse(call: Call<NewsRss>, response: Response<NewsRss>) {
                val list = response.body()?.channel?.items.orEmpty().trasform()
                //               Log.d("hch", "MainActivity - onResponse() - called${list}")
                newsAdapter.submitList(list)
                list.forEachIndexed { index, news ->
                    Log.d("hch", "MainActivity - onResponse() - called${news}")
                    Thread{
                        try {
                            val jsoup = Jsoup.connect(news.link).get()

                            Log.d("googleImg", "MainActivity - onResponse() - called ${jsoup}")
                            val element = jsoup.select("meta[property^=og:]")
//                            Log.d("googleImg", "MainActivity - onResponse() - called ${element}")
                            val ogImageNode = element.find {node->
                                node.attr("property") == "og:image"
                            }
//                            Log.d("googleImg", "MainActivity - onResponse() - called ${ogImageNode}")
                            val imageUrl = ogImageNode?.attr("content")
                            news.imageUrl =imageUrl
//                            Log.d("googleImg", "MainActivity - onResponse() - called ${imageUrl}")
                        }catch (e: Exception){
                            e.printStackTrace()
                        }

                        runOnUiThread{
                            newsAdapter.notifyItemChanged(index)
                        }

                    }.start()

                }

                Log.d("retrofit", "MainActivity - onResponse() - called ${response.body()?.channel?.items}")

            }

            override fun onFailure(call: Call<NewsRss>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}