package com.example.galleryproject.gallery_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by ubuntu on 26/04/16.
 */
public class DetailsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        String title = getIntent().getStringExtra("title");
        String path = getIntent().getStringExtra("storage");
        try {
            File f=new File(path, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img=(ImageView)findViewById(R.id.image);
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }



        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);


   //     ImageView imageView = (ImageView) findViewById(R.id.image);
     //   imageView.setImageBitmap(bitmap);
    }
}
