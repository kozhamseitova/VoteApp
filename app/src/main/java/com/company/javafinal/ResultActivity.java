package com.company.javafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

public class ResultActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = findViewById(R.id.main);
        textView1 = findViewById(R.id.main1);
        textView2 = findViewById(R.id.main2);
        textView3 = findViewById(R.id.main3);


        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        Set<String> set = sharedPreferences.getStringSet("set", null);
        for (String se : set){
            if(textView.getText().toString().isEmpty()){
                textView.setText(se.toString());
            }
            else if(textView1.getText().toString().isEmpty()){
                textView.setText(se.toString());
            }
            else if(textView2.getText().toString().isEmpty()){
                textView.setText(se.toString());
            }
            else if(textView3.getText().toString().isEmpty()){
                textView.setText(se.toString());
            }
        }


        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}