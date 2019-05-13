package com.example.weeek6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlayerAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<Player> playerList;

    public PlayerAdapter(MainActivity context, int layout, List<Player> playerList) {
        this.context = context;
        this.layout = layout;
        this.playerList = playerList;
    }

    @Override
    public int getCount() {
        return playerList.size() ;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtName, txtNumber, txtClub;
        ImageView imgAvatar;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtName         = (TextView)view.findViewById(R.id.textviewName);
            holder.txtNumber       = (TextView)view.findViewById(R.id.textviewNumber);
            holder.txtClub         = (TextView) view.findViewById(R.id.textviewClub);
            holder.imgAvatar       = (ImageView)view.findViewById(R.id.imageviewAvatar);


            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Player player = playerList.get(i);

        holder.imgAvatar.setImageResource(player.getImg());
        holder.txtName.setText(player.getName());
        holder.txtNumber.setText(player.getNumber());
        holder.txtClub.setText(player.getClub());


        return view;
    }
}
