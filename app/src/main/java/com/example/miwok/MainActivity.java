package com.example.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNumbers,btnColor,btnFamily,btnPhrases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btnNumbers=findViewById(R.id.numers);
        btnNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNumbers =new Intent(MainActivity.this,Numbers.class);
                startActivity(intentNumbers);
            }
        });

        btnColor=findViewById(R.id.color);
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentColor =new Intent(MainActivity.this,Color.class);
                startActivity(intentColor);
            }
        });

        btnFamily=findViewById(R.id.family_members);
        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFamily =new Intent(MainActivity.this,Family_Member.class);
                startActivity(intentFamily);
            }
        });

        btnPhrases=findViewById(R.id.phrases);
        btnPhrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPhrases =new Intent(MainActivity.this,Phrases.class);
                startActivity(intentPhrases);
            }
        });

    }
}