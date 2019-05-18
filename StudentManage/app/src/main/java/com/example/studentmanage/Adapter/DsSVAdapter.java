package com.example.studentmanage.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.studentmanage.Activity.ActivityNhapDiem;
import com.example.studentmanage.Activity.ActivityNhapDiemSinhVien;
import com.example.studentmanage.Activity.SearchSinhVien;
import com.example.studentmanage.Activity.UpdateKhoa;
import com.example.studentmanage.Activity.UpdateSinhVien;
import com.example.studentmanage.Class.DsSinhVien;
import com.example.studentmanage.Class.SinhVien;
import com.example.studentmanage.R;

import java.util.List;

public class DsSVAdapter extends BaseAdapter {
    private ActivityNhapDiem context;
    private int layout;
    private List<DsSinhVien> dsSinhVienList;

    public DsSVAdapter(ActivityNhapDiem context, int layout, List<DsSinhVien> dsSinhVienList) {
        this.context = context;
        this.layout = layout;
        this.dsSinhVienList = dsSinhVienList;
    }

    @Override
    public int getCount() {
        return dsSinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        RelativeLayout rltPick;
        TextView txtHoTen, txtMaSv, txtMaMH;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final DsSVAdapter.ViewHolder holder;
        if(view == null){
            holder = new DsSVAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.rltPick      = (RelativeLayout) view.findViewById(R.id.pickitem1) ;
            holder.txtMaSv      = (TextView) view.findViewById(R.id.textviewMaSv1);
            holder.txtHoTen     = (TextView) view.findViewById(R.id.textviewHoTenSv1);
            holder.txtMaMH      = (TextView) view.findViewById(R.id.textviewMaMhSv1);
            view.setTag(holder);
        }else {
            holder = (DsSVAdapter.ViewHolder) view.getTag();
        }

        final DsSinhVien dsSinhVien = dsSinhVienList.get(i);

        holder.txtMaSv.setText("Mã Sv: " + dsSinhVien.getMaSv());
        holder.txtHoTen.setText("Họ tên: " + dsSinhVien.getHoTen());
        holder.txtMaMH.setText("Mã môn học: " + dsSinhVien.getMaMH());

        holder.rltPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                holder.rltPick.setBackgroundResource(R.drawable.shape_btn3);
                holder.rltPick.setBackgroundColor(R.drawable.shape_btn3);
                Intent intent = new Intent(context, ActivityNhapDiemSinhVien.class);
                intent.putExtra("dataDsSinhVien", dsSinhVien);
                context.startActivity(intent);
            }
        });


        return view;
    }
}
