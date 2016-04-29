package com.example.galleryproject.gallery_project;

import android.graphics.Bitmap;

/**
 * Created by ubuntu on 26/04/16.
 */
public class ImageItem {

    private Bitmap image;
    private String title;
    private String desc;

    public ImageItem(Bitmap image, String title,String desc ) {
        super();
        this.image = image;
        this.title = title;
        this.desc = desc;


    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


//    public static Uri getPath(Context inContext, Bitmap inImage) {
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
//        return Uri.parse(path);
//    }
}
