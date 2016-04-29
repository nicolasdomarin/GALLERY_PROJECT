package com.example.galleryproject.gallery_project;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ubuntu on 26/04/16.
 */
public class DetailsActivity2 extends AppCompatActivity{

    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity2);

        String title = getIntent().getStringExtra("title") + "\n" + getIntent().getStringExtra("desc");
        String path = getIntent().getStringExtra("storage");

        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);

        ImageView imageView = (ImageView) findViewById(R.id.image);
     //   imageView.setImageBitmap(bitmap);

        Toast.makeText(DetailsActivity2.this, path, Toast.LENGTH_SHORT).show();
        Picasso.with(DetailsActivity2.this).load(path).into(imageView);

        Button buttonEnregistrer = (Button) findViewById(R.id.buttonEnregistrer);
        buttonEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    saveToInternalStorage(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean saveToInternalStorage(Bitmap bitmapImage) throws IOException {
        FileOutputStream fos = null;
        boolean SaveDone;
        try {
            MediaStore.Images.Media.insertImage(getContentResolver(), bitmapImage, "TitreQuelquechose" , "descriptionTruc");
            Toast.makeText(DetailsActivity2.this, "Image enregistrée sur le téléphone", Toast.LENGTH_SHORT).show();
            SaveDone= true;
        } catch (Exception e) {
            Toast.makeText(DetailsActivity2.this, "Erreur: l'image n'a pas été enregistrée", Toast.LENGTH_SHORT).show();
            SaveDone = false;
            e.printStackTrace();
        }
        return SaveDone;
    }
}
