package com.example.viewpagercontaininghorizontalscrollview;

import android.graphics.Bitmap;

public class ContentEntity {

    private Bitmap image;
     private String textContent;

    public ContentEntity(Bitmap image, String textContent) {
        this.image = image;
        this.textContent = textContent;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getTextContent() {
        return textContent;
    }
}
