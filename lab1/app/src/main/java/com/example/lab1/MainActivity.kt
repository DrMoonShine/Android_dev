package com.example.lab1

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //флгаи
        var flagSerif = false
        var flagMoonspace = false

        var flagItalic = false
        var flagBold = false
        //размер шрифта
        var textSize = 14
        binding.fontSize.text = "TextSize: $textSize"
        binding.plusButton.setOnClickListener{
            textSize++
            binding.fontSize.text = "TextSize: $textSize"
            binding.mainText.textSize = textSize.toFloat()
        }
        binding.minusButton.setOnClickListener{
            if(textSize > 0){
                textSize--
                binding.fontSize.text = "TextSize: $textSize"
                binding.mainText.textSize = textSize.toFloat()
            }

        }

        //жирный шрифт
        binding.bButton.setOnCheckedChangeListener{ compoundButton: CompoundButton, isCheck: Boolean ->
            if(isCheck){
                flagBold = if(flagItalic){
                    if(flagSerif) binding.mainText.setTypeface(Typeface.SERIF,Typeface.BOLD_ITALIC)
                    else if(flagMoonspace) binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC)
                    else binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC)
                    true
                } else{
                    if(flagSerif) binding.mainText.setTypeface(Typeface.SERIF,Typeface.BOLD)
                    else if(flagMoonspace) binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD)
                    else binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD)
                    true
                }
            }
            else{
                flagBold = if(flagItalic){
                    if(flagSerif) binding.mainText.setTypeface(Typeface.SERIF,Typeface.ITALIC)
                    else if(flagMoonspace) binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC)
                    else binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.ITALIC)
                    false
                } else{
                    if(flagSerif) binding.mainText.setTypeface(Typeface.SERIF,Typeface.NORMAL)
                    else if(flagMoonspace) binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL)
                    else binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.NORMAL)
                    false
                }
            }
        }
        //курсив
        binding.iButton.setOnCheckedChangeListener{ compoundButton: CompoundButton, isCheck: Boolean ->
            if(isCheck){
                flagItalic = if(flagBold){
                    if(flagSerif) binding.mainText.setTypeface(Typeface.SERIF,Typeface.BOLD_ITALIC)
                    else if(flagMoonspace) binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC)
                    else binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC)
                    true
                } else{
                    if(flagSerif) binding.mainText.setTypeface(Typeface.SERIF,Typeface.ITALIC)
                    else if(flagMoonspace) binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC)
                    else binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.ITALIC)
                    true
                }
            }
            else{
                flagItalic = if(flagBold) {
                    if(flagSerif) binding.mainText.setTypeface(Typeface.SERIF,Typeface.BOLD)
                    else if(flagMoonspace) binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD)
                    else binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD)
                    false
                } else{
                    if(flagSerif) binding.mainText.setTypeface(Typeface.SERIF,Typeface.NORMAL)
                    else if(flagMoonspace) binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL)
                    else binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.NORMAL)
                    false
                }

            }
        }
        //смена шрифта
        binding.radioButtons.setOnCheckedChangeListener{ _, buttonId: Int ->
            when(buttonId){
                binding.radioOne.id -> {
                    flagSerif = true
                    flagMoonspace = false

                    if (flagBold && !flagItalic)binding.mainText.setTypeface(Typeface.SERIF,Typeface.BOLD)
                    else if(flagItalic && !flagBold)binding.mainText.setTypeface(Typeface.SERIF,Typeface.ITALIC)
                    else if(flagItalic && flagBold)binding.mainText.setTypeface(Typeface.SERIF,Typeface.BOLD_ITALIC)
                    else binding.mainText.setTypeface(Typeface.SERIF,Typeface.NORMAL)
                }
                binding.radioTwo.id -> {
                    flagSerif = false
                    flagMoonspace = true

                    if (flagBold && !flagItalic)binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD)
                    else if(flagItalic && !flagBold)binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC)
                    else if(flagItalic && flagBold)binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC)
                    else binding.mainText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL)
                }
                binding.radioThree.id -> {
                    flagSerif = false
                    flagMoonspace = false

                    if (flagBold && !flagItalic)binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD)
                    else if(flagItalic && !flagBold)binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.ITALIC)
                    else if(flagItalic && flagBold)binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC)
                    else binding.mainText.setTypeface(Typeface.SANS_SERIF,Typeface.NORMAL)
                }
            }
        }
        //цвет текста
        binding.redBtn.setOnClickListener{
            binding.mainText.setTextColor(resources.getColor(R.color.red))
        }
        binding.blueBtn.setOnClickListener{
            binding.mainText.setTextColor(resources.getColor(R.color.purple_700))
        }
        binding.greenBtn.setOnClickListener{
            binding.mainText.setTextColor(resources.getColor(R.color.green))
        }
        binding.lightBlueBtn.setOnClickListener{
            binding.mainText.setTextColor(resources.getColor(R.color.teal_200))
        }
        binding.purpleBtn.setOnClickListener{
            binding.mainText.setTextColor(resources.getColor(R.color.purple_200))
        }
        binding.yellowBtn.setOnClickListener{
            binding.mainText.setTextColor(resources.getColor(R.color.yellow))
        }
        binding.blackBtn.setOnClickListener{
            binding.mainText.setTextColor(resources.getColor(R.color.black))
        }





    }
}