package com.example.user.activitylifecycleandintent

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

import com.example.user.activitylifecycleandintent.model.Person
import com.example.user.activitylifecycleandintent.model.PersonP
import com.example.user.activitylifecycleandintent.utils.Constants

class MainActivity : AppCompatActivity() {
    private var etMain: EditText? = null
    private var tvMain: TextView? = null
    private var etPersonName: EditText? = null
    private var etPersonAge: EditText? = null
    private var etPersonGender: EditText? = null


    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private const val TEXTVIEW_KEY = "key"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

        etMain = findViewById(R.id.etMain)
        tvMain = findViewById(R.id.tvMain)
        etPersonName = findViewById(R.id.etPersonName)
        etPersonAge = findViewById(R.id.etPersonAge)
        etPersonGender = findViewById(R.id.etPersonGender)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ")
        //save the data to the bundle
        outState.putString(TEXTVIEW_KEY, tvMain?.text.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: ")
        val textViewData = savedInstanceState.getString(TEXTVIEW_KEY)
        tvMain?.text = textViewData
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "onConfigurationChanged: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    fun onButtonClicked(view: View) {

        when (view.id) {
            R.id.btnPerson -> {
                //                Create person object
                val person = Person(
                        etPersonName?.text.toString(),
                        etPersonAge?.text.toString(),
                        etPersonGender?.text.toString()
                )

                val personP = PersonP(
                        etPersonName?.text.toString(),
                        etPersonAge?.text.toString(),
                        etPersonGender?.text.toString()
                )
                //                Send person to second activity
                val intent = Intent(applicationContext,
                        SecondActivity::class.java)
                intent.putExtra(Constants.PERSON, person)
                intent.putExtra(Constants.PERSON_P, personP)
                startActivity(intent)
            }
            R.id.btnChangeTextView -> tvMain?.text = etMain?.text.toString()
        }

    }
}
