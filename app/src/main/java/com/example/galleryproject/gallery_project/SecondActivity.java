package com.example.galleryproject.gallery_project;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private GridView gridView;
    private GridViewAdapter gridAdapter;
  private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String idSalle= getIntent().getStringExtra("<id>");
        String nameSalle = getIntent().getStringExtra("<title>");
        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData(idSalle));
        gridView.setAdapter(gridAdapter);
        title = (TextView) findViewById(R.id.titleSalleType);
        title.setText(nameSalle);

        Toast.makeText(SecondActivity.this, idSalle, Toast.LENGTH_SHORT).show();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                Intent intent = new Intent(SecondActivity.this, DetailsActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());
                startActivity(intent);
            }
        });
    }

    /**
     * Prepare some dummy data for gridview
     */
    private ArrayList<ImageItem> getData(String id) {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = null;

        switch (id){
            case "1":
                 imgs = getResources().obtainTypedArray(R.array.image_salle1);
                break;
            case "2":
               imgs = getResources().obtainTypedArray(R.array.image_salle2);
                break;
            case "3":
                imgs = getResources().obtainTypedArray(R.array.image_salle3);

            case "4":
                 imgs = getResources().obtainTypedArray(R.array.image_salle4);
                break;

        }


        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Peinture" + i));
        }
        return imageItems;
    }
}
