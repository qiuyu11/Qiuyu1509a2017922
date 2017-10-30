package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bawei.beans.Newslist;
import com.bawei.qiuyu1509a2017922.R;
import com.nostra13.universalimageloader.core.ImageLoader;


import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MyAdapter02 extends BaseAdapter{
    private List<Newslist> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter02(Context context, List<Newslist> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder01 holder01;
        if(convertView == null)
        {
            holder01 = new ViewHolder01();
            convertView = inflater.inflate(R.layout.item02,null);
            holder01.txt02 = (TextView) convertView.findViewById(R.id.txt02);
            holder01.txt03 = (TextView) convertView.findViewById(R.id.txt03);
            holder01.txt04 = (TextView) convertView.findViewById(R.id.txt04);
            holder01.txt05 = (TextView) convertView.findViewById(R.id.txt05);
            holder01.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder01);

        }
        else {
            holder01 = (ViewHolder01) convertView.getTag();

        }

        Newslist newslist = list.get(position);
        holder01.txt02.setText(newslist.getTitle());
        holder01.txt03.setText(newslist.getCtime());
        holder01.txt04.setText(newslist.getDescription());
        holder01.txt05.setText(newslist.getUrl());
        ImageLoader.getInstance().displayImage(newslist.getPicUrl(),holder01.img);
        return convertView;
    }
    class ViewHolder01{
        TextView txt02,txt03,txt04,txt05;
        ImageView img;



    }
}
