package com.example.quizzwizz;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.quizapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dasboard extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timer = 20;
    private ProgressBar progressBar;
    List<QuizModel> quizModelList;
    QuizModel modelclass;
    private TextView tv_progress, tv_question, btn_option_one, btn_option_two, btn_option_three, btn_option_four;
    private AppCompatEditText et_name;
    private Button btn_submit;
    int currentPos = 0;
    int correctAnswer = 0;
    int wrongAnswer = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hooks();

        progressBar = findViewById(R.id.progressBar);
        Collections.shuffle(quizModelList);
        modelclass = quizModelList.get(currentPos);

        quizModelList = new ArrayList<>();


        quizModelList.add(new QuizModel("Who is this person?",
                R.drawable.quizbilde1,
                "1",
                "2",
                "3",
                "4",
                1));
        quizModelList.add(new QuizModel("new question?",
                R.drawable.bilde2,
                "1",
                "2",
                "3",
                "4",
                2));
        quizModelList.add(new QuizModel(" one?",
                R.drawable.bilde3,
                "1",
                "2",
                "3",
                "4",
                2));

    }

    private void setAllData() {

        tv_question.setText(modelclass.getQuestion());
        btn_option_one.setText(modelclass.getOpt1());
        btn_option_two.setText(modelclass.getOpt2());
        btn_option_three.setText(modelclass.getOpt3());
        btn_option_four.setText(modelclass.getOpt4());
        timer = 20;
        countDownTimer.cancel();
        countDownTimer.start();
    }

    private void Hooks() {
        et_name = findViewById(R.id.et_name);
        btn_option_one = findViewById(R.id.btn_option_one);
        btn_option_two = findViewById(R.id.btn_option_two);
        btn_option_three = findViewById(R.id.btn_option_three);
        btn_option_four = findViewById(R.id.btn_option_four);
        btn_submit = findViewById(R.id.btn_submit);
        tv_progress = findViewById(R.id.tv_progress);
        tv_question = findViewById(R.id.tv_question);
    }

    public void Correct(TextView textView) {

        textView.setBackgroundColor(getResources().getColor(R.color.green));

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswer++;
                currentPos++;
                modelclass = quizModelList.get(currentPos);
                resetColor();
                setAllData();
                enableButton();
            }
        });


    }

    public void Wrong(TextView textView) {

        textView.setBackgroundColor(getResources().getColor(R.color.red));
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongAnswer++;
                if (currentPos < quizModelList.size() - 1) {
                    currentPos++;
                    modelclass = quizModelList.get(currentPos);
                    resetColor();
                    setAllData();
                    enableButton();

                } else {
                    GameWon();
                }
            }
        });
    }

    private void GameWon() {
        Intent intent = new Intent(Dasboard.this, EndActivity.class);
        intent.putExtra("correct", correctAnswer);
        intent.putExtra("wrong", wrongAnswer);
        startActivity(intent);
    }

    public void enableButton() {
        btn_option_one.setClickable(true);
        btn_option_two.setClickable(true);
        btn_option_three.setClickable(true);
        btn_option_four.setClickable(true);
    }

    public void disableButton() {
        btn_option_one.setClickable(false);
        btn_option_two.setClickable(false);
        btn_option_three.setClickable(false);
        btn_option_four.setClickable(false);
    }

    public void resetColor() {
        btn_option_one.setBackgroundColor(getResources().getColor(R.color.white));
        btn_option_two.setBackgroundColor(getResources().getColor(R.color.white));
        btn_option_three.setBackgroundColor(getResources().getColor(R.color.white));
        btn_option_four.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void Option1(View view) {
        disableButton();
        btn_submit.setClickable(true);
        if (modelclass.getOpt1().equals(modelclass.getAnswer())) {
            btn_option_one.setBackgroundColor(getResources().getColor(R.color.green));

            if (currentPos < quizModelList.size() - 1) {
                Correct(btn_option_one);

            } else {
                GameWon();
            }

        } else {
            Wrong(btn_option_one);
        }
    }

    public void Option2(View view) {
        disableButton();
        btn_submit.setClickable(true);
        if (modelclass.getOpt1().equals(modelclass.getAnswer())) {
            btn_option_two.setBackgroundColor(getResources().getColor(R.color.green));

            if (currentPos < quizModelList.size() - 1) {
                Correct(btn_option_two);

            } else {
                GameWon();
            }

        } else {
            Wrong(btn_option_two);
        }
    }


    public void Option3(View view) {
        disableButton();
        btn_submit.setClickable(true);
        if (modelclass.getOpt1().equals(modelclass.getAnswer())) {
            btn_option_three.setBackgroundColor(getResources().getColor(R.color.green));

            if (currentPos < quizModelList.size() - 1) {
                Correct(btn_option_three);

            } else {
                GameWon();
            }

        } else {
            Wrong(btn_option_three);
        }
    }

    public void Option4 (View view) {
        disableButton();
        btn_submit.setClickable(true);
        if (modelclass.getOpt1().equals(modelclass.getAnswer())) {
            btn_option_four.setBackgroundColor(getResources().getColor(R.color.green));

            if (currentPos < quizModelList.size() - 1) {
                Correct(btn_option_four);

            } else {
                GameWon();
            }

        } else {
            Wrong(btn_option_four);
        }
    }
}