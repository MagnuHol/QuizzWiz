package com.example.quizzwizz;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;


import com.example.quizapplication.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class QuizActivity extends AppCompatActivity {

    private Button btn_start;
    private AppCompatEditText et_name;
    List<QuizModel> quizModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        et_name = findViewById(R.id.et_name);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_name.getText().toString().isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Enter a name", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(QuizActivity.this, Dasboard.class);
                    startActivity(intent);
                }
            }
        });



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



}
