package com.example.galleryproject.gallery_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button salle1 = (Button) findViewById(R.id.firstSalleButton);
        final Button salle2 = (Button) findViewById(R.id.secondSalleButton);
        final Button salle3 = (Button) findViewById(R.id.thirdSalleButton);
        final Button salle4 = (Button) findViewById(R.id.secondSalleButton);

        salle1.setOnClickListener(onClickListener);
        salle2.setOnClickListener(onClickListener);
        salle3.setOnClickListener(onClickListener);
        salle4.setOnClickListener(onClickListener);


    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent newActivity = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(newActivity);
        }
    };
}