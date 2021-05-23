package com.rainrunnerdevelopment.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneButton: Button = findViewById(R.id.button_done)

        //Local variable view indicates which view was clicked - can pass this to function
        doneButton.setOnClickListener {
            setNickName(it)

            //Provided code to hide the screen keyboard
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    private fun setNickName(view: View) {
        val nickEditText: EditText = findViewById(R.id.editText_nickname)
        val nickText: TextView = findViewById(R.id.text_nickname)
        nickText.text = nickEditText.text
        nickText.visibility = View.VISIBLE
        nickEditText.visibility = View.GONE
        //Passed in 'view' whch was the button view that the listener was added to
        //so we can use this reference here, rather than getting a new refernce to the
        //button
        view.visibility = View.GONE


    }
}