package com.example.appfood.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfood.MainActivity;
import com.example.appfood.R;

public class IntroActivity extends AppCompatActivity {

    private TextView startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intor);

        startBtn=findViewById(R.id.starBtn);
        startBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (IntroActivity.this, MainActivity.class));
            }
        });
   }
}
