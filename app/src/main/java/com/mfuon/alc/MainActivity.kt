package com.mfuon.alc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        about_alc.setOnClickListener{
            val intent = Intent(this, AboutAlcActivity::class.java)
            startActivity(intent)
        }

        my_profile.setOnClickListener{
            val intent = Intent(this, MyProfile::class.java)
            startActivity(intent)
        }
    }
}
