package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private String[] questions={"Is the Earth round?", "Is the Sun a planet?", "Is water made of hydrogen and oxygen?", "Is Mount Everest the tallest mountain on Earth?", "Is India located in Asia?", "Is the Great Wall of China visible from space with naked eyes?", "Is Python a programming language?", "Is the human body made up of cells?", "Is the Pacific Ocean the largest ocean on Earth?", "Is lightning hotter than the Sun’s surface?", "Is the capital of France Berlin?", "Do plants produce oxygen during photosynthesis?"};

    private boolean[] answers={true, false, true, true, true, false, true, true, true, true, false, true};
    private int score =0;
    private int index =0;
    Button yes;
    Button no;
    Button restart;

    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        restart = findViewById(R.id.restart);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //array is not going out of bound
                if(index<= questions.length-1){
                    //give a answer
                    if(answers[index] == true){
                        score++;
                    }
                    index++;
                    if(index <= questions.length-1){
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "your score is: " +score +"/"+ questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<= questions.length-1){

                    if(answers[index] == false){
                        score++;
                    }
                    index++;
                    if(index <= questions.length-1){
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "your score is: " +score +"/"+ questions.length, Toast.LENGTH_SHORT).show();
                    }

                }

            }

        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 0;
                score = 0;
                question.setText(questions[index]);
                Toast.makeText(MainActivity.this, "Quiz Restarted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}