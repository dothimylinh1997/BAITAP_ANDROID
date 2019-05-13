package com.example.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
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
        TextView txtHoTen, txtNamSinh, txtDiaChi;
        ImageView imgDelete, imgEdit;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtHoTen = (TextView) view.findViewById(R.id.textviewHoTenCustom);
            holder.txtDiaChi = (TextView) view.findViewById(R.id.textviewDiaChiCustom);
            holder.txtNamSinh = (TextView) view.findViewById(R.id.textviewNamSinhCustom);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imageViewDelete);
            holder.imgEdit = (ImageView) view.findViewById(R.id.imageViewEdit);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        SinhVien sinhVien = sinhVienList.get(i);

        holder.txtHoTen.setText(sinhVien.getHoTen());
        holder.txtNamSinh.setText("Ngày sinh: " + sinhVien.getNgaySinh());
        holder.txtDiaChi.setText(sinhVien.getDiaChi());
        return null;
    }
}
