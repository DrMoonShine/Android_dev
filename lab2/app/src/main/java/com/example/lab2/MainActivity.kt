package com.example.lab2
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myText = findViewById<View>(R.id.my_text) as TextView
        myText.setTypeface(Typeface.createFromAsset(assets, "fonts/penguinattackcyrillic.otf"))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val mylayout = findViewById<View>(R.id.root) as ConstraintLayout
        return when (item.getItemId()) {
            R.id.red -> {
                mylayout.setBackgroundColor(resources.getColor(R.color.red))
                true
            }
            R.id.green -> {
                mylayout.setBackgroundColor(resources.getColor(R.color.green))
                true
            }
            R.id.blue -> {
                mylayout.setBackgroundColor(resources.getColor(R.color.blue))
                true
            }
            R.id.exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}