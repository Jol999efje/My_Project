package com.example.project;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.content.Intent;


import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        button = (Button) findViewById(R.id.enterLogIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity();
            }
        });
    }
    public void MainActivity(){
         Intent intent = new Intent(this, MainActivity.class);
         startActivity(intent);
    }

}