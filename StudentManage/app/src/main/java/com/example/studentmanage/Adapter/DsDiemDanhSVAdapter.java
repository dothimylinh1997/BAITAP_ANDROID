package com.example.studentmanage.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentmanage.Activity.DiemDanhSV;
import com.example.studentmanage.Class.SinhVienDiemDanh;
import com.example.studentmanage.R;

import java.util.List;

public class DsDiemDanhSVAdapter extends BaseAdapter {
    private DiemDanhSV context;
    private int layout;
    private List<SinhVienDiemDanh> sinhVienDiemDanhs;

    public DsDiemDanhSVAdapter(DiemDanhSV context, int layout, List<SinhVienDiemDanh> sinhVienDiemDanhs) {
        this.context = context;
        this.layout = layout;
        this.sinhVienDiemDanhs = sinhVienDiemDanhs;
    }

    @Override
    public int getCount() {
        return sinhVienDiemDanhs.size();
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
        TextView txtMaSv;
        TextView txtMaMh;
        TextView txtNgay;
        CheckBox cbDiemDanh;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaSv      = view.findViewById(R.id.textviewMaSv2);
            holder.txtMaMh      = view.findViewById(R.id.textviewMaMhDiemDanh);
            holder.txtNgay      = view.findViewById(R.id.textviewNgayDiemDanh);
            holder.cbDiemDanh  = view.findViewById(R.id.cbDiemDanh);
            view.setTag(holder);
        }else {
            holder = (DsDiemDanhSVAdapter.ViewHolder) view.getTag();
        }

        final SinhVienDiemDanh sinhVienDiemDanh = sinhVienDiemDanhs.get(i);
        holder.txtMaSv.setText("Mã SV: " + sinhVienDiemDanh.getMaSv());
        holder.txtMaMh.setText("Mã môn học: " + sinhVienDiemDanh.getMaMh());
        holder.txtNgay.setText("Ngày: " + sinhVienDiemDanh.getNgay());

        if(sinhVienDiemDanh.getDiemDanh().equals("1")){
            holder.cbDiemDanh.setChecked(true);
        } else {
            holder.cbDiemDanh.setChecked(false);
        }
        holder.cbDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox ch = v.findViewById(R.id.cbDiemDanh);
                SinhVienDiemDanh sv = DiemDanhSV.arraySinhVien.get(i);
                if(ch.isChecked()) sv.setDiemDanh("1");
                else sv.setDiemDanh("2");
                DiemDanhSV.arraySinhVien.set(i, sv);
            }
        });
        return view;
    }
}
