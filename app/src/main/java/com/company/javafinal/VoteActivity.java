package com.company.javafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VoteActivity extends AppCompatActivity {

    private TextView mTxtQuestion;
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
    private List<String> listOfVotes;

    private Questions[] questionCollection = new Questions[]{
            new Questions(1, "Yes or No?", "Yes", "No", "IDK", "MB"),
            new Questions(2, "Yes or No?", "Yes", "No", "IDK", "MB"),
            new Questions(3, "Yes or No?", "Yes", "No", "IDK", "MB"),
            new Questions(4, "Yes or No?", "Yes", "No", "IDK", "MB")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        mTxtQuestion = findViewById(R.id.tv_question);
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

                //evaluateUserAnswer(1);
                changeQuestionOnButtonClick();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //evaluateUserAnswer(2);
                changeQuestionOnButtonClick();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //evaluateUserAnswer(3);
                changeQuestionOnButtonClick();

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // evaluateUserAnswer(4);
                changeQuestionOnButtonClick();

            }
        });

    }

    private void changeQuestionOnButtonClick(){
        mQuestionIndex=(mQuestionIndex+1)%4;
        if(mQuestionIndex==0){
            /*Set<String> set = new HashSet<String>();
            set.addAll(listOfVotes);
            SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putStringSet("set", set);
            editor.apply();*/
            Intent intent = new Intent(VoteActivity.this, ResultActivity.class);
            startActivity(intent);
            finish();
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

    /*private void evaluateUserAnswer(int userGuess){
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
        listOfVotes.add(currentAnswer);
    }*/

}