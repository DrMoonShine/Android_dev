package com.example.lab5

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var touchFlag = false
    private var  downIndex = 0
    private var  upIndex = 0
    var textView = mutableListOf<TextView>()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        //использовать recyclerview...
        setContentView(binding.root)
        textView.add(binding.idOne)
        textView.add(binding.idTwo)
        textView.add(binding.idThree)
        textView.add(binding.idFour)
        textView.add(binding.idFive)
        textView.add(binding.idSix)
        textView.add(binding.idSeven)
        textView.add(binding.idEaght)
        textView.add(binding.idNine)
        textView.add(binding.idTen)


    }


    @SuppressLint("SetTextI18n")
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        //событие
        val actionMask = event?.actionMasked
        //кол-во косаний
        var pointerCount = event?.pointerCount
        //индекс
        val pointerIndex = event?.actionIndex
        binding.test.text = pointerCount.toString()
        when (actionMask) {
            MotionEvent.ACTION_DOWN -> {
                touchFlag = true
                if (pointerIndex != null) {
                    downIndex = pointerIndex
                }
            }
            MotionEvent.ACTION_POINTER_DOWN -> downIndex = pointerIndex!!
            MotionEvent.ACTION_UP -> {
                touchFlag = false
                var i = 0
                while (i < 10) {
                    when(i){
                        0 -> textView[0].text = ""
                        1 -> textView[1].text = ""
                        2 -> textView[2].text = ""
                        3 -> textView[3].text = ""
                        4 -> textView[4].text = ""
                        5 -> textView[5].text = ""
                        6 -> textView[6].text = ""
                        7 -> textView[7].text = ""
                        8 -> textView[8].text = ""
                        9 -> textView[9].text = ""
                    }
                    i++
                }
                if (pointerIndex != null) {
                    if(upIndex == 0) pointerCount = 0
                    upIndex = pointerIndex
                }
            }
            MotionEvent.ACTION_POINTER_UP -> upIndex = pointerIndex!!
            MotionEvent.ACTION_MOVE -> {
                var i = 0
                while (i < 10) {
                    when(i){
                        0 -> textView[0].text = ""
                        1 -> textView[1].text = ""
                        2 -> textView[2].text = ""
                        3 -> textView[3].text = ""
                        4 -> textView[4].text = ""
                        5 -> textView[5].text = ""
                        6 -> textView[6].text = ""
                        7 -> textView[7].text = ""
                        8 -> textView[8].text = ""
                        9 -> textView[9].text = ""
                    }
                    if (i < pointerCount!!) {
                        when(i){
                            0 -> textView[0].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                            1 -> textView[1].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                            2 -> textView[2].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                            3 -> textView[3].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                            4 -> textView[4].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                            5 -> textView[5].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                            6 -> textView[6].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                            7 -> textView[7].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                            8 -> textView[8].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                            9 -> textView[9].text = "${event.getPointerId(i)} ${event.getX(i).toInt()} ${event.getY(i).toInt()}"
                        }

                    } else {
                        when(i){
                            0 -> textView[0].text = ""
                            1 -> textView[1].text = ""
                            2 -> textView[2].text = ""
                            3 -> textView[3].text = ""
                            4 -> textView[4].text = ""
                            5 -> textView[5].text = ""
                            6 -> textView[6].text = ""
                            7 -> textView[7].text = ""
                            8 -> textView[8].text = ""
                            9 -> textView[9].text = ""
                        }
                    }
                    i++
                }
            }
        }

        binding.test.text = "Количество касаний: ${pointerCount}\n" +
                "Индекс последнего касания: ${downIndex}\n" +
                "Индекс последнего отпускания: $upIndex"
        return super.onTouchEvent(event)
    }

}