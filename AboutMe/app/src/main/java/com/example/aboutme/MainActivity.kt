package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
/*
        findViewById<Button>(R.id.button_done).setOnClickListener{
            addNickname(it)
        }
  */
        binding.buttonDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        /*
        val edittext_nickname = findViewById<EditText>(R.id.edittext_nickname)
        val textview_nickname = findViewById<TextView>(R.id.text_nickname)
*/
        binding.apply {
            binding.textNickname.text = binding.edittextNickname.text
            invalidateAll()
            binding.edittextNickname.visibility = View.GONE
            binding.buttonDone.visibility = View.GONE
            binding.textNickname.visibility = View.VISIBLE
        }
    }

}