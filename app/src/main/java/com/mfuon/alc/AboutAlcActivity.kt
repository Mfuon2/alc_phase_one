package com.mfuon.alc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_about_alc.*
import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebViewClient



class AboutAlcActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)
        val myWebView: WebView = findViewById(R.id.about_alc_web)
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.setAppCacheEnabled(true)
        myWebView.settings.databaseEnabled = true
        myWebView.settings.domStorageEnabled = true
        myWebView.settings.setSupportZoom(true)
        myWebView.settings.javaScriptCanOpenWindowsAutomatically = true
        myWebView.settings.builtInZoomControls = true
        //webView.setWebViewClient(new GeoWebViewClient());
        // Below required for geolocation
        myWebView.settings.setGeolocationEnabled(true)
        myWebView.webViewClient = SSLTolerentWebViewClient()
        myWebView.loadUrl("https://andela.com/alc/")
        /*about_alc_web.settings.javaScriptEnabled = true
        about_alc_web.webViewClient = SSLTolerentWebViewClient()
        about_alc_web.loadUrl("https://andela.com/alc/")*/
        about_alc_back.setOnClickListener {
            backToMain()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        backToMain()
    }

    private fun backToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }

    private inner class SSLTolerentWebViewClient : WebViewClient() {
        override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
            handler.proceed()
        }
    }
}

