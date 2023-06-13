package com.example.lab6


import android.animation.ObjectAnimator
import android.graphics.Color.alpha
import android.graphics.drawable.AnimationDrawable
//import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.lab6.databinding.ActivityMainBinding
import com.google.android.material.color.utilities.MaterialDynamicColors.background


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var flag = 0
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.nextShape.setOnClickListener{
            flag++
            when(flag){

                1 -> {
                    binding.oval.isVisible = true
                    binding.rectangle.isVisible = false
                    binding.ring.isVisible = false
                    binding.all.isVisible = false
                    binding.oval.animate().scaleX(0.50F)
                    binding.oval.animate().scaleY(0.50F)
                    ObjectAnimator.ofFloat(binding.oval,
                        View.ALPHA,
                        0.01f,
                        360f).apply {
                        duration = 20000
                        interpolator = AccelerateDecelerateInterpolator()
                        start()
                    }
                }
                2 ->{
                    binding.oval.isVisible = false
                    binding.rectangle.isVisible = true
                    binding.ring.isVisible = false
                    binding.all.isVisible = false
                    binding.rectangle.animate().rotation(370F)
                }
                3 ->{
                    binding.oval.isVisible = false
                    binding.rectangle.isVisible = false
                    binding.ring.isVisible = true
                    binding.all.isVisible = false
                    ObjectAnimator.ofFloat(binding.ring,
                        View.ROTATION_Y,
                        0f,
                        360f).apply {
                        duration = 2000
                        interpolator = AccelerateDecelerateInterpolator()
                        start()
                    }

                }
                4->{
                    binding.all.isVisible = true
                    binding.oval.isVisible = false
                    binding.rectangle.isVisible = false
                    binding.ring.isVisible = false
                    binding.all.setBackgroundResource(R.drawable.my_anim)
                    val anim = binding.all.background as AnimationDrawable
                    anim.start()
                    flag = 0

                }
                else -> flag = 0
            }
        }
    }
}