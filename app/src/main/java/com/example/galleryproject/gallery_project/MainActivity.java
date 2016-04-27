package com.example.galleryproject.gallery_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   String myString = "";

    private Button salle1,salle2,salle3,salle4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salle1 = (Button) findViewById(R.id.firstSalleButton);
        salle2 = (Button) findViewById(R.id.secondSalleButton);
        salle3 = (Button) findViewById(R.id.thirdSalleButton);
        salle4 = (Button) findViewById(R.id.fourthSalleButton);

        salle1.setOnClickListener(onClickListener);
        salle2.setOnClickListener(onClickListener);
        salle3.setOnClickListener(onClickListener);
        salle4.setOnClickListener(onClickListener);


    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent newActivity = new Intent(MainActivity.this, SecondActivity.class);
            if (v == salle1){
                newActivity.putExtra("<id>",1);
                newActivity.putExtra("<title>","Impressionisme");
            }else if (v == salle2) {
                newActivity.putExtra("<id>",2);
                newActivity.putExtra("<title>","Surréalisme");
            } else if (v==salle3) {
                newActivity.putExtra("<id>",3);
                newActivity.putExtra("<title>","Humanisme");
            } else if (v==salle4){
                newActivity.putExtra("<id>",4);
                newActivity.putExtra("<title>","Cubisme");
            }

            startActivity(newActivity);
        }
    };
}