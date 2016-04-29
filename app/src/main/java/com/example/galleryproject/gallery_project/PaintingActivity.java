package com.example.galleryproject.gallery_project;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PaintingActivity extends AppCompatActivity {
    private String author;
    private GridView gridView;
    private GridViewAdapter gridAdapter;
    private Button buttonBack;
    private TextView title;
    TypedArray titre = null;
    TypedArray desc = null;
    TypedArray imgs = null;
     ArrayList<ImageItem> imageItems ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting);

        // on recupere les parametre passées lors du changement d'activité
        author = getIntent().getStringExtra("author_name");
        title = (TextView) findViewById(R.id.titleSalleType);

        // on definit le texte du titre
        title.setText(author);


        gridView = (GridView) findViewById(R.id.gridView);

        //on definit l'adapter et on lui insere les données
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());

        //on definit l'adapter de la gridView
        gridView.setAdapter(gridAdapter);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Action au clique sur l'image de la gridView

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                Intent detailsActivity = new Intent(PaintingActivity.this, DetailsActivity.class);
                detailsActivity.putExtra("title", item.getTitle());
                detailsActivity.putExtra("desc", item.getDesc());
                detailsActivity.putExtra("image",item.getImage());
                startActivity(detailsActivity);

            }
        });
    }




    // fonction permettant de recupere les données des ressources XML en fonction des paramètre recupérés lors du changement d'activité

    private ArrayList<ImageItem> getData() {
       imageItems = new ArrayList<>();

        switch (author){
            case "VAN GOGH":
                imgs = getResources().obtainTypedArray(R.array.images_van_gogh);
                titre = getResources().obtainTypedArray(R.array.titres_van_gogh);
                desc = getResources().obtainTypedArray(R.array.descriptions_van_gogh);
                break;
            case "MONET":
                imgs = getResources().obtainTypedArray(R.array.images_monet);
                titre = getResources().obtainTypedArray(R.array.titres_monet);
                desc = getResources().obtainTypedArray(R.array.descriptions_monet);
                break;
            case "RENOIR":
                imgs = getResources().obtainTypedArray(R.array.images_renoir);
                titre = getResources().obtainTypedArray(R.array.titres_renoir);
                desc = getResources().obtainTypedArray(R.array.descriptions_monet);
                break;
            case "PICASSO":
                imgs = getResources().obtainTypedArray(R.array.images_picasso);
                titre = getResources().obtainTypedArray(R.array.titres_picasso);
                desc = getResources().obtainTypedArray(R.array.descriptions_picasso);
                break;
            case "DALI":
                imgs = getResources().obtainTypedArray(R.array.images_dali);
                titre = getResources().obtainTypedArray(R.array.titres_dali);
                desc = getResources().obtainTypedArray(R.array.descriptions_dali);
                break;
            case "BOTTICELLI":
                imgs = getResources().obtainTypedArray(R.array.images_botticelli);
                titre = getResources().obtainTypedArray(R.array.titres_botticelli);
                desc = getResources().obtainTypedArray(R.array.descriptions_botticelli);
                break;
        }

        // On redimensionne les images pour les afficher dans la gridView
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            Bitmap resizedbitmap = Bitmap.createScaledBitmap(bitmap, 400, 300, true);
            imageItems.add(new ImageItem(resizedbitmap, titre.getString(i),desc.getString(i)));
        }
        return imageItems;
    }
}
