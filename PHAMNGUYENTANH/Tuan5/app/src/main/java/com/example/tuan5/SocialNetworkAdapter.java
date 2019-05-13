package com.example.tuan5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SocialNetworkAdapter extends ArrayAdapter<SocialNetwork> {

    Context context;
    int layoutResourceId;
    ArrayList<SocialNetwork> data = null;

    public SocialNetworkAdapter(Context context, int resource, ArrayList<SocialNetwork> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResourceId = resource;
        this.data = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SocialNetworkHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new SocialNetworkHolder();
            holder.imgIcon = row.findViewById(R.id.imageView_flag);
            holder.txtTitle = row.findViewById(R.id.textView_countryName);

            row.setTag(holder);
        }
        else{
            holder = (SocialNetworkHolder)row.getTag();
        }

        SocialNetwork item = data.get(position);
        holder.txtTitle.setText(item.title);
        holder.imgIcon.setImageResource(item.icon);

        return row;
    }
    static class SocialNetworkHolder{
        ImageView imgIcon;
        TextView txtTitle;
    }
}
