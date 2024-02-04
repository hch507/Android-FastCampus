package com.example.webtoon_app

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebtoonWebViewClient(
    private val progressBar : ProgressBar,
    private val saveData :(String) -> Unit
) : WebViewClient() {

    //https://comic.naver.com/webtoon/list
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {

        if(request != null && request.url.toString().contains("https://comic.naver.com/webtoon/list")){
            saveData.invoke(request.url.toString())
        }
        return super.shouldOverrideUrlLoading(view, request)
    }
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

        progressBar.visibility= View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)

        progressBar.visibility =View.VISIBLE
    }

}