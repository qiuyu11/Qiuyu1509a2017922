package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bawei.qiuyu1509a2017922.R;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class Myadapter extends BaseAdapter {
    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public Myadapter(Context context, List<String> list) {
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
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item,null);
            holder.txt = (TextView) convertView.findViewById(R.id.textView);
            holder.img = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);


        }
        else {

            holder = (ViewHolder) convertView.getTag();

        }
        String s = list.get(position);
        holder.txt.setText(s);
        holder.img.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }
    class ViewHolder{
        TextView txt;
        ImageView img;


    }
}
