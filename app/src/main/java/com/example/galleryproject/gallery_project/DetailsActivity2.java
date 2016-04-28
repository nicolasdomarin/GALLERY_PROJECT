package com.example.galleryproject.gallery_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by ubuntu on 26/04/16.
 */
public class DetailsActivity2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity2);

        String title = getIntent().getStringExtra("title");
        String path = getIntent().getStringExtra("imagePath");
        String imagename = getIntent().getStringExtra("imageName");
        try {
            File f=new File(path,imagename+".jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img=(ImageView)findViewById(R.id.image);
            //img.setImageBitmap(b);
            Picasso.with(DetailsActivity2.this).load(f).into(img);
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
