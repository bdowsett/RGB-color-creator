package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.enter_button).setOnClickListener {
            val colorPanel = findViewById<TextView>(R.id.color_panel)

            var red = findViewById<TextInputEditText>(R.id.red_channel).text.toString()
            var green = findViewById<TextInputEditText>(R.id.green_channel).text.toString()
            var blue = findViewById<TextInputEditText>(R.id.blue_channel).text.toString()

            if (red.isEmpty() && green.isEmpty() && blue.isEmpty()) {
                Snackbar.make(it, "Complete all fields", Snackbar.LENGTH_LONG).show()
            } else {
                if (red.length == 1) { red = red.plus(red) }
                if (green.length == 1) { green = green.plus(green) }
                if (blue.length == 1) { blue = blue.plus(blue) }

                val color = "#${red}${blue}$green"

                Log.d("Ben Dowsett", color)
                colorPanel.setBackgroundColor(color.toColorInt())
            }
        }
    }
}
