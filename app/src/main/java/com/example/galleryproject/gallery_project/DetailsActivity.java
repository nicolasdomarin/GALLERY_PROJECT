package com.example.galleryproject.gallery_project;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;


public class DetailsActivity extends FragmentActivity{

    private ViewPager mPager;
    private FrameLayout frameLayout;
    private String author;

    private static final int NUM_PAGES = 2;

    private PagerAdapter mPagerAdapter;

    String [] mm;

  Drawable[] mResources = {}  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        mPagerAdapter = new ScreenSlidePagerAdapter(this);

        //String title = getIntent().getStringExtra("title");
        //Bitmap bitmap = getIntent().getParcelableExtra("image");
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mPagerAdapter);
        author = getIntent().getStringExtra("author");




        switch (author){
            case "VAN GOGH":
                mm = getResources().getStringArray(R.array.images_van_gogh_slider);
                break;
            case "BOTTICELLI":
                mm = getResources().getStringArray(R.array.images_botticelli_slider);
                break;
            case "PICASSO":
                mm = getResources().getStringArray(R.array.images_picasso_slider);
                break;
            case "MONET":
                mm = getResources().getStringArray(R.array.images_monet_slider);
                break;
            case "RENOIR":
                mm = getResources().getStringArray(R.array.images_renoir_slider);
            break;
            case "DALI":
                mm = getResources().getStringArray(R.array.images_dali_slider);
            break;
        }

        mResources = new Drawable[mm.length];
        for ( int x =0; x < mm.length; x++)
        {
            mResources[x] = getResources().getDrawable(getResources().getIdentifier(mm[x],"drawable", this.getPackageName() ));
        }

        mPagerAdapter.notifyDataSetChanged();

        /*TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageBitmap(bitmap);*/
    }


    @Override
    public void onBackPressed() {
        if(mPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else {
            mPager.setCurrentItem(mPager.getCurrentItem() -1);
        }

    }

    private class ScreenSlidePagerAdapter extends PagerAdapter{

        Context mContext;
        LayoutInflater mLayoutInflater;

        /*public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }*/

        public ScreenSlidePagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((FrameLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.details_activity, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), mResources[position]);
            //Bitmap resizedbitmap = Bitmap.createScaledBitmap(bitmap, 500, 600, true);
            imageView.setImageDrawable(mResources[position]);
            container.addView(itemView);
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((FrameLayout) object);
        }
    }
}
