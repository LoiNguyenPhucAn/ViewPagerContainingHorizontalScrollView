package com.example.viewpagercontaininghorizontalscrollview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class ContentPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<ContentEntity> contentList;

    public ContentPagerAdapter(Context mContext, ArrayList<ContentEntity> contentList) {
        this.mContext = mContext;
        this.contentList = contentList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.content,container,false);

        ContentEntity item = contentList.get(position);
        TextView tvContent = v.findViewById(R.id.tv_content);;
        ImageView ivImageContent = v.findViewById(R.id.image_content);

        ivImageContent.setImageBitmap(item.getImage());
        tvContent.setText(item.getTextContent());

        container.addView(v);

        return v;
    }

    @Override
    public int getCount() {
        return contentList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
