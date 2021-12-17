package com.example.viewpagercontaininghorizontalscrollview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContentEntity> content;

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = getAssetContent();
        viewPager = findViewById(R.id.vPager);
        ContentPagerAdapter adapter= new ContentPagerAdapter(this,content);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0,true);


    }

    public ArrayList<ContentEntity> getAssetContent(){
        ArrayList<ContentEntity> contentList = new ArrayList<>();
        try {

            String [] filename = getApplicationContext().getAssets().list("photo");
            for (String s:filename){
                Bitmap image = BitmapFactory.decodeStream(getApplicationContext().getAssets().open("photo/" + s));

                String textContentFileName = s.substring(0,s.indexOf(".")) + ".txt";

                InputStream input = getApplicationContext().getAssets().open("text/"+textContentFileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
                StringBuilder content = new StringBuilder();
                String line;
                try
                {
                    while ((line = br.readLine()) != null){
                        content.append(line).append("\n");
                    }
                    contentList.add(new ContentEntity(image,content.toString()));
                    br.close();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentList;
    }
}