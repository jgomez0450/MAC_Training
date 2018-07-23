package com.example.user.androidviews

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvFirst: TextView? = null
    private var etSomething: EditText? = null
    private var btnFirst: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        btnFirst?.setOnClickListener {
            val data = etSomething?.text.toString()
            tvFirst?.text = data
        }
    }

    private fun bindViews() {
        tvFirst = findViewById(R.id.tvFirst)
        etSomething = findViewById(R.id.etSomething)
        btnFirst = findViewById(R.id.btnFirst)
    }

    fun onSecondClicked(view: View) {

        Toast.makeText(this,
                "Second button clicked",
                Toast.LENGTH_SHORT)
                .show()

        val url = "http://developer.android.com"
        val intent = Intent(applicationContext, SecondActivity::class.java)
        intent.putExtra("URL", url)
        startActivity(intent)
    }
}
