package com.mfuon.alc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.WindowManager
import android.os.Build



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // In Activity's onCreate() for instance
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }


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
