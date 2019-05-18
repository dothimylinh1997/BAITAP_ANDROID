package com.example.studentmanage.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.studentmanage.Activity.ActivityNhapDiem;
import com.example.studentmanage.Activity.ActivityNhapDiemSinhVien;
import com.example.studentmanage.Activity.XemDiem;
import com.example.studentmanage.Class.Diem;
import com.example.studentmanage.Class.DsSinhVien;
import com.example.studentmanage.R;

import java.util.List;

public class DiemAdapter extends BaseAdapter {
    private XemDiem context;
    private int layout;
    private List<Diem> diemList;

    public DiemAdapter(XemDiem context, int layout, List<Diem> diemList) {
        this.context = context;
        this.layout = layout;
        this.diemList = diemList;
    }

    @Override
    public int getCount() {
        return diemList.size();
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

        TextView txtMaMH, txtDiemCC, txtDiemKT, txtDiemCK, txtDiemTK;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DiemAdapter.ViewHolder holder;
        if(view == null){
            holder = new DiemAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaMH        = (TextView) view.findViewById(R.id.textviewMaMhDiem);
            holder.txtDiemCC      = (TextView) view.findViewById(R.id.textviewDiemCC);
            holder.txtDiemKT      = (TextView) view.findViewById(R.id.textviewDiemKT);
            holder.txtDiemCK      = (TextView) view.findViewById(R.id.textviewDiemCK);
            holder.txtDiemTK      = (TextView) view.findViewById(R.id.textviewDiemTK);
            view.setTag(holder);
        }else {
            holder = (DiemAdapter.ViewHolder) view.getTag();
        }

        final Diem diem = diemList.get(i);

        holder.txtMaMH.setText("Mã môn học: " + diem.getMaMH());
        holder.txtDiemCC.setText("Điểm chuyên cần: " + diem.getDiemCC());
        holder.txtDiemKT.setText("Điểm kiểm tra: " + diem.getDiemKT());
        holder.txtDiemCK.setText("Điểm cuối kì: " + diem.getDiemCK());
        holder.txtDiemTK.setText("Điểm tông kết: " + diem.getDiemTK());

        return view;
    }

}
