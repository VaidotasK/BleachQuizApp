package com.example.android.bleachquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.bleachquizapp.MainActivity.EXTRA_TEXT;

public class Quiz extends AppCompatActivity {

    //Declaration of variables and constants
    public static final String EXTRA_SCORE = "Score";
    public static final String EXTRA_TEXT = "name";
    int score;
    String userName;
    private Button submitButton;


    //Saves data before changing activity
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Takes value of userName variable from mainActivity.java file
        setContentView(R.layout.activity_quiz);
        Bundle bundle = getIntent().getExtras();
        userName = bundle.getString(EXTRA_TEXT);

        //When button Submit is clicked, next activity Results opens
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //counts the score and puts into new variable.
                int newScore = submitResults(score);
                openResults(newScore);
            }
        });
    }

    public int submitResults(int score) {

        /**
         * @param score - number of points got for the right answers
         * Checks all answers and counts the score
         */

        EditText answer1EditText = findViewById(R.id.answer1EditText);
        String answer1 = answer1EditText.getText().toString().toLowerCase();
        if (answer1.equals("ichigo")) {
            score++;
        }
        EditText answer2EditText = findViewById(R.id.answer2EditText);
        String answer2 = answer2EditText.getText().toString().toLowerCase();
        if (answer2.equals("rukia")) {
            score++;
        }
        RadioButton answer3 = findViewById(R.id.question3_opt2);
        if (answer3.isChecked()) {
            score++;
        }
        RadioButton answer4 = findViewById(R.id.question4_opt1);
        if (answer4.isChecked()) {
            score++;
        }
        RadioButton answer5 = findViewById(R.id.question5_opt3);
        if (answer5.isChecked()) {
            score++;
        }
        RadioButton answer6 = findViewById(R.id.question6_opt2);
        if (answer6.isChecked()) {
            score++;
        }
        CheckBox answer7op1 = findViewById(R.id.question7_opt1);
        CheckBox answer7op2 = findViewById(R.id.question7_opt2);
        CheckBox answer7op3 = findViewById(R.id.question7_opt3);
        if (answer7op1.isChecked() && answer7op2.isChecked() && answer7op3.isChecked()) {
            score++;
        }
        CheckBox answer8op1 = findViewById(R.id.question8_opt1);
        CheckBox answer8op3 = findViewById(R.id.question8_opt3);
        CheckBox wrongAnswer8op2 = findViewById(R.id.question8_opt2);

        //Checks is all right answers are checked AND if wrong isn't
        if (answer8op1.isChecked() && answer8op3.isChecked() && !wrongAnswer8op2.isChecked()) {
            score++;
        }
        return score;
    }
    //Method is for opening new activity Results and it
    //saves values of variables userName and score, which is in new variable - newScore

    public void openResults(int newScore) {
        Intent intent = new Intent(this, Results.class);
        intent.putExtra(EXTRA_SCORE, newScore);
        intent.putExtra(EXTRA_TEXT, userName);
        startActivity(intent);
    }
}

