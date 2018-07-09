package com.example.user.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.storage.model.Person;
import com.example.user.storage.model.data.LocalDataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String MY_SHARED_PREF = "mySharedPref";
    private TextView tvMain;
    private EditText etMain;
    private LocalDataSource localDataSource;
    private EditText etPersonName;
    private EditText etPersonAge;
    private EditText etPersonGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        localDataSource = new LocalDataSource(this);
    }

    private void bindViews() {
//        for shared preferences
        tvMain = findViewById(R.id.tvMain);
        etMain = findViewById(R.id.etMain);

//        for database
        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
        etPersonGender = findViewById(R.id.etPersonGender);
    }

    public void handleSharedPreferences(View view) {

        SharedPreferences sharedPreferences =
                getSharedPreferences(MY_SHARED_PREF, Context.MODE_PRIVATE);


        switch (view.getId()) {
            case R.id.btnSaveData:

                String etString = etMain.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("etMain", etString);
                boolean isSaved  = editor.commit();

                if (isSaved) {
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnGetData:

                String data = sharedPreferences
                        .getString("etMain","default value");
                tvMain.setText(data);

                break;

        }

    }

    public void handlingDatabase(View view) {

        Person person = new Person(
                etPersonName.getText().toString(),
                etPersonAge.getText().toString(),
                etPersonGender.getText().toString()
        );

        switch (view.getId()) {

            case R.id.btnSavePerson:

                long rowid = localDataSource.savePerson(person);
                if (rowid > 0) {
                    Toast.makeText(this, "Person saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Not saved", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.btnGetAllPersons:

                List<Person> personList = localDataSource.getAllPerson();

                Toast.makeText(this, personList.toString(), Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
