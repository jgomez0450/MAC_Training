package com.example.user.activitylifecycleandintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.user.activitylifecycleandintent.model.Person
import com.example.user.activitylifecycleandintent.model.PersonP
import com.example.user.activitylifecycleandintent.utils.Constants

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val person = intent
                .getSerializableExtra(Constants.PERSON) as Person

        val personP = intent.getParcelableExtra(Constants.PERSON_P) as PersonP

        Toast.makeText(this, person.name, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, personP.age, Toast.LENGTH_SHORT).show()

    }
}
