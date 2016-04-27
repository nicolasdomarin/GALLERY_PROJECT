package com.example.galleryproject.gallery_project;

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
import android.widget.Toast;


import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {
    private GridView gridView;
    private GridViewAdapter gridAdapter;
    private TextView title;
    private Button buttonBack;
    private int idSalle;
    private String nameSalle;
    String[] autors = null;
    TypedArray imgs = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        idSalle= getIntent().getIntExtra("<id>",0);
        nameSalle = getIntent().getStringExtra("<title>");
        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData(idSalle));
        gridView.setAdapter(gridAdapter);

        // on change le titre en fonction de la salle
        title = (TextView) findViewById(R.id.titleSalleType);
        title.setText(nameSalle);

        //button pour revenir a l'ancienne activité
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {



               ImageItem item = (ImageItem) parent.getItemAtPosition(position);
//                Intent detailsActivity = new Intent(AuthorActivity.this, DetailsActivity.class);
//                detailsActivity.putExtra("title", item.getTitle());
//                detailsActivity.putExtra("image", item.getImage());
//                startActivity(detailsActivity);
                  Intent paintingActivity = new Intent(AuthorActivity.this,PaintingActivity.class);
                  paintingActivity.putExtra("author_name",item.getTitle());
                 startActivity(paintingActivity);
            }
        });
    }

    /**
     * Prepare some dummy data for gridview
     */
    private ArrayList<ImageItem> getData(int id) {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();

;


        switch (id){
            case 1:
                 imgs = getResources().obtainTypedArray(R.array.image_salle1);
                 autors = getResources().getStringArray(R.array.desc_salle1);
                break;
            case 2:
               imgs = getResources().obtainTypedArray(R.array.image_salle2);
                autors = getResources().getStringArray(R.array.desc_salle2);
                break;
            case 3:
                imgs = getResources().obtainTypedArray(R.array.image_salle3);
                autors = getResources().getStringArray(R.array.desc_salle3);
                break;
            case 4:
                 imgs = getResources().obtainTypedArray(R.array.image_salle4);
                autors = getResources().getStringArray(R.array.desc_salle4);
                break;


        }


        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            //ca resize l'image en 300*300
            Bitmap resizedbitmap = Bitmap.createScaledBitmap(bitmap, 500, 600, true);
            imageItems.add(new ImageItem(resizedbitmap, autors[i]));
        }
        return imageItems;
    }
}
