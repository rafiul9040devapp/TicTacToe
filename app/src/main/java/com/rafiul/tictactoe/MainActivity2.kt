package com.rafiul.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.rafiul.tictactoe.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView2.translationY = -1000f
        binding.textView.translationY = 1000f

        binding.imageView2.animate().translationY(0f).duration = 2000
        binding.textView.animate().translationY(0f).duration = 2000

        Handler(Looper.getMainLooper()).postDelayed({
              val intent = Intent(this,StartActivity::class.java)
              startActivity(intent)
        },3000)

    }
}