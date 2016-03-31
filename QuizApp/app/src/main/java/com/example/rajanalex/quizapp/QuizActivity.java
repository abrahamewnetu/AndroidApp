package com.example.abrahamewnetu.quizapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    Button tButton;
    Button fButton;
    Question [] questionsBank;
    TextView myQuestion;
    Button nButton;
    Button pButton;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        tButton = (Button) findViewById(R.id.true_button);
        fButton = (Button) findViewById(R.id.false_button);
        myQuestion = (TextView) findViewById(R.id.question_text);
        pButton =(Button) findViewById(R.id.prevous_string);
        nButton =(Button) findViewById(R.id.next_string);

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(true);
            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyAnswer(false);
            }


        });

        questionsBank = new Question[5];
        questionsBank[0] = new Question("Constantinople is the largest city in Turkey", false);
        questionsBank[1] = new Question("Mexico City is the capital of Mexico", true);
        questionsBank[2] = new Question("Tar is blue in color", false);
        questionsBank[3] = new Question("Android app is written in Python", false);
        questionsBank[4] = new Question("Jerusalem is the capital of Israel", true);
        i = 1;
        myQuestion.setText(questionsBank[i].get_question());
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                i = i % 5;
                myQuestion.setText(questionsBank[i].get_question());
            }
        });

        pButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                i--;
                i = i % 5;
                myQuestion.setText(questionsBank[i].get_question());
            }
        });
    }
    private void verifyAnswer(boolean b){
        if (questionsBank[i].get_answer() == b)
            Toast.makeText(QuizActivity.this, "Correct answer",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(QuizActivity.this, "Sorry your answer incorrect",
                    Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
