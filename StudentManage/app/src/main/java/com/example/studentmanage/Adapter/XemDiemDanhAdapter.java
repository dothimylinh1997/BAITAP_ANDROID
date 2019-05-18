package com.example.studentmanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentmanage.Activity.DiemDanhSV;
import com.example.studentmanage.Activity.XemDiemDanh;
import com.example.studentmanage.Class.SinhVienDiemDanh;
import com.example.studentmanage.Class.SinhVienXemDiemDanh;
import com.example.studentmanage.R;

import java.util.List;

public class XemDiemDanhAdapter extends BaseAdapter {
    private XemDiemDanh context;
    private int layout;
    private List<SinhVienXemDiemDanh> sinhVienDiemDanhs;

    public XemDiemDanhAdapter(XemDiemDanh context, int layout, List<SinhVienXemDiemDanh> sinhVienDiemDanhs) {
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
        TextView txtHoTen;
        CheckBox cbDiemDanh;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        XemDiemDanhAdapter.ViewHolder holder;
        if(view == null){
            holder = new XemDiemDanhAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaSv      = view.findViewById(R.id.textviewMaSv3);
            holder.txtMaMh      = view.findViewById(R.id.textviewMaMhDiemDanh1);
            holder.txtNgay      = view.findViewById(R.id.textviewNgayDiemDanh1);
            holder.txtHoTen      = view.findViewById(R.id.textviewHoTen3);
            holder.cbDiemDanh  = view.findViewById(R.id.cbDiemDanh1);
            view.setTag(holder);
        }else {
            holder = (XemDiemDanhAdapter.ViewHolder) view.getTag();
        }

        final SinhVienXemDiemDanh sinhVienDiemDanh = sinhVienDiemDanhs.get(i);

        holder.txtMaSv.setText("Mã SV: " + sinhVienDiemDanh.getMaSv());
        holder.txtMaMh.setText("Mã môn học: " + sinhVienDiemDanh.getMaMH());
        holder.txtNgay.setText("Ngày: " + sinhVienDiemDanh.getNgay());
        holder.txtHoTen.setText("Họ tên: " + sinhVienDiemDanh.getHoTen());

        if(sinhVienDiemDanh.getDiemDanh().equals("1")){
            holder.cbDiemDanh.setChecked(true);
        } else {
            holder.cbDiemDanh.setChecked(false);
        }
        holder.cbDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox ch = v.findViewById(R.id.cbDiemDanh1);
                SinhVienXemDiemDanh sv = XemDiemDanh.arraySinhVien.get(i);
                if(ch.isChecked()) sv.setDiemDanh("1");
                else sv.setDiemDanh("2");
                XemDiemDanh.arraySinhVien.set(i, sv);
            }
        });
        return view;
    }

}
