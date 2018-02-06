package com.example.android.bleachquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {
    //declaration of variable
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
    /**
     * Takes variable userName from mainActivity java file.
     */
        Intent intent = getIntent();
        userName = intent.getStringExtra(MainActivity.EXTRA_TEXT);
    /**
     * Takes Score from previous activity - Quiz.java. T
     */
        int totalScore = intent.getIntExtra(Quiz.EXTRA_SCORE, 0);
        TextView scoreTextView = findViewById(R.id.scoreNumber);
        scoreTextView.setText("" + totalScore);

        //Based on score the Toast will pop up
        if (totalScore == 8) {
            showScoreMsgExcellent(userName);
        } else if (totalScore >= 4) {
            showScoreMsgGood(userName);
        } else {
            showScoreMsgBad(userName);
        }
    }

    /**
     * Shows messages based on users performance
     */

    //Score 8
    public void showScoreMsgExcellent(String userName) {
        Toast toast = Toast.makeText(this, getString(R.string.toastMsgExcellent, userName), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

    }

    //4 <= Score < 8
    public void showScoreMsgGood(String userName) {
        Toast toast = Toast.makeText(this, getString(R.string.toastMsgGood, userName), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

    }

    // Score < 3
    public void showScoreMsgBad(String userName) {
        Toast toast = Toast.makeText(this, getString(R.string.toastMsgBad, userName), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
