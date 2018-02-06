package com.example.android.bleachquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaration of variables and constants

    public static final String EXTRA_TEXT = "name";
    String userName;
    private Button startButton;

    //Saves data before changing activity
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        EditText userNameInputEditText = (EditText) findViewById(R.id.enterYourNameEditText);
        userName = userNameInputEditText.getText().toString();
        savedInstanceState.putString(EXTRA_TEXT, userName);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            setContentView(R.layout.activity_main);

            // Restore value of userName from saved state
            userName = savedInstanceState.getString(EXTRA_TEXT);
        } else {
            setContentView(R.layout.activity_main);
        }
        //After button Start is clicked the Ouiz activity opens;
        startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz();
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        userName = savedInstanceState.getString(EXTRA_TEXT);
    }
    //Method opens new activity, before it saves user Name and put it into variable userName

    public void openQuiz() {
        EditText userInputName = (EditText) findViewById(R.id.enterYourNameEditText);
        userName = userInputName.getText().toString();
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra(EXTRA_TEXT, userName);
        startActivity(intent);
    }

}


