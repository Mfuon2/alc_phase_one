package com.mfuon.alc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_about_alc.*
import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebViewClient



class AboutAlcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)

        about_alc_web.webViewClient = SSLTolerentWebViewClient()
        Log.wtf("MY CLASS","************** before")

        about_alc_web.loadUrl("https://andela.com/alc/")
        Log.wtf("MY CLASS","************** before")

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
            handler.proceed() // Ignore SSL certificate errors
        }

    }
}

