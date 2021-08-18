package com.example.calculator

import android.content.Intent
import android.graphics.ColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.SimpleColorFilter
import com.airbnb.lottie.model.KeyPath
import com.airbnb.lottie.value.LottieValueCallback

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val intent: Intent = Intent(this, MainActivity::class.java)
        Handler().postDelayed({startActivity(intent)
                              finish()}, 7000)

        val animationView = findViewById<LottieAnimationView>(R.id.lottie_animation_math)
        val yourColor = ContextCompat.getColor(this, R.color.primaryTextColor)

        val filter = SimpleColorFilter(yourColor)
        val keyPath = KeyPath("**")
        val callback = LottieValueCallback<ColorFilter>(filter)
        animationView.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, callback)
        animationView.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, callback)
    }
}