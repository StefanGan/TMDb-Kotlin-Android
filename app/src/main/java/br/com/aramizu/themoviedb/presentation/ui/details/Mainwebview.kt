package br.com.aramizu.themoviedb.presentation.ui.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import br.com.aramizu.themoviedb.R

class Mainwebview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview)
        val myWebView: WebView = findViewById(R.id.webview) as WebView
        myWebView.loadUrl("https://www.cathaycineplexes.com.sg/")
    }
}