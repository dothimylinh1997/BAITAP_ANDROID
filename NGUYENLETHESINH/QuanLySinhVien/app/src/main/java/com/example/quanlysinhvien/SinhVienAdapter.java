package com.example.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtHoTen, txtNgaySinh, txtDiaChi, txtGioiTinh, txtMaLop, txtMaSv;
        ImageView imgEdit, imgDelete;
    }

    @Override
    public View getView(int i, View view , ViewGroup viewGroup) {

        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtHoTen     = (TextView) view.findViewById(R.id.textviewHoTenCustom);
            holder.txtNgaySinh  = (TextView) view.findViewById(R.id.textviewNamSinhCustom);
            holder.txtDiaChi    = (TextView) view.findViewById(R.id.textviewDiaChiCustom);
            holder.txtGioiTinh  = (TextView) view.findViewById(R.id.textviewGioiTinhCustom);
            holder.txtMaSv      = (TextView) view.findViewById(R.id.textviewMaSvCustom);
            holder.txtMaLop     = (TextView) view.findViewById(R.id.textviewMaLopCustom);
            holder.imgDelete    = (ImageView)view.findViewById(R.id.imageviewDelete);
            holder.imgEdit      = (ImageView)view.findViewById(R.id.imageviewEdit);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        SinhVien sinhvien = sinhVienList.get(i);

        holder.txtHoTen.setText(sinhvien.getHoTen());
        holder.txtNgaySinh.setText(sinhvien.getNgaySinh());
        holder.txtDiaChi.setText(sinhvien.getDiaChi());
        holder.txtGioiTinh.setText(sinhvien.getGioiTinh());
        holder.txtMaLop.setText(sinhvien.getMaLop());
        holder.txtMaSv.setText(sinhvien.getMaSv());

        return view;
    }
}
