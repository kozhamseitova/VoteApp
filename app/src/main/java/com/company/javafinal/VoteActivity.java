package com.company.javafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VoteActivity extends AppCompatActivity {

    private TextView mTxtQuestion;
    private TextView questionHeader;
    private TextView btn1;
    private TextView btn2;
    private TextView btn3;
    private TextView btn4;
    private int mQuestionIndex;
    private String mQuizQuestion;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private ImageButton forward;
    private LinearLayout sec;
    private List<String> s = new ArrayList<>();

    private Questions[] questionCollection = new Questions[]{
            new Questions(1, "Yes or No?", "Yes", "No", "IDK", "MB"),
            new Questions(2, "White or Black?", "White", "Black", "IDK", "DM"),
            new Questions(3, "Morning or Evening?", "Morning", "Evening", "IDK", "DM"),
            new Questions(4, "Smartphone or Laptop?", "Smartphone", "Laptop", "IDK", "DM")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        sec = findViewById(R.id.sec);
        mTxtQuestion = findViewById(R.id.tv_question);
        questionHeader = findViewById(R.id.questionheader);
        forward = findViewById(R.id.forward);
        btn1 = findViewById(R.id.tv_option_one);
        btn2 = findViewById(R.id.tv_option_two);
        btn3 = findViewById(R.id.tv_option_three);
        btn4 = findViewById(R.id.tv_option_four);

        Questions q1=questionCollection[mQuestionIndex];
        mQuizQuestion = q1.getQuestion();
        option1 = q1.getOptionOne();
        option2 = q1.getOptionTwo();
        option3 = q1.getOptionThree();
        option4 = q1.getOptionFour();

        mTxtQuestion.setText(mQuizQuestion);
        btn1.setText(option1);
        btn2.setText(option2);
        btn3.setText(option3);
        btn4.setText(option4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s.add(evaluateUserAnswer(1));
                changeQuestionOnButtonClick();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s.add(evaluateUserAnswer(2));
                changeQuestionOnButtonClick();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s.add(evaluateUserAnswer(3));
                changeQuestionOnButtonClick();

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s.add(evaluateUserAnswer(4));
                changeQuestionOnButtonClick();

            }
        });

    }

    private void changeQuestionOnButtonClick(){
        mQuestionIndex=(mQuestionIndex+1)%4;
        if(mQuestionIndex==0){
            for(int i = 0; i < s.size(); i++){
                System.out.println(s.get(i));
            }
            questionHeader.setText("Your answers:\n"+s.get(0)+"\n"+s.get(1)+"\n"+s.get(2)+"\n"+s.get(3));
            sec.setVisibility(View.GONE);

            forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(VoteActivity.this, MainActivity.class));
                    finish();

                }
            });
        }

        mQuizQuestion = questionCollection[mQuestionIndex].getQuestion();
        option1 = questionCollection[mQuestionIndex].getOptionOne();
        option2 = questionCollection[mQuestionIndex].getOptionTwo();
        option3 = questionCollection[mQuestionIndex].getOptionThree();
        option4 = questionCollection[mQuestionIndex].getOptionFour();

        mTxtQuestion.setText(mQuizQuestion);
        btn1.setText(option1);
        btn2.setText(option2);
        btn3.setText(option3);
        btn4.setText(option4);
    }

    private String evaluateUserAnswer(int userGuess){
        String currentAnswer = null;
        if(userGuess==1){
            currentAnswer = questionCollection[mQuestionIndex].getOptionOne();
        }
        else if(userGuess==2){
            currentAnswer = questionCollection[mQuestionIndex].getOptionTwo();
        }
        else if(userGuess==3){
            currentAnswer = questionCollection[mQuestionIndex].getOptionThree();
        }
        else if(userGuess==4){
            currentAnswer = questionCollection[mQuestionIndex].getOptionFour();
        }
        return currentAnswer;
    }

}