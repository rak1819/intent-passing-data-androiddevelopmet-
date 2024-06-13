package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textinput = findViewById<EditText>(R.id.editTextTextPersonName)
        val button = findViewById<Button>(R.id.button)
        val textouput = findViewById<TextView>(R.id.textout)
        val offersbtn = findViewById<Button>(R.id.button2)
        var entered =""
        button.setOnClickListener{
            entered = textinput.text.toString()
            val msg = "Welcome $entered"
            if(entered==""){
                offersbtn.visibility = INVISIBLE
                textouput.text =""
                Toast.makeText(this@MainActivity, "please enter the name!!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                offersbtn.visibility = VISIBLE
                textinput.text.clear()
            }
        }
        offersbtn.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("USER",entered)
            startActivity(intent)
        }

    }
}