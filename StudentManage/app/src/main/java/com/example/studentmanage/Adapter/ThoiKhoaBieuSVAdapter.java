package com.example.studentmanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentmanage.Activity.ActivityTKBSV;
import com.example.studentmanage.Class.ThoiKhoaBieu;
import com.example.studentmanage.R;

import java.util.List;

public class ThoiKhoaBieuSVAdapter extends BaseAdapter {
    private ActivityTKBSV context;
    private int layout;
    private List<ThoiKhoaBieu> thoiKhoaBieuList;

    public ThoiKhoaBieuSVAdapter(ActivityTKBSV context, int layout, List<ThoiKhoaBieu> thoiKhoaBieuList){
        this.context = context;
        this.layout = layout;
        this.thoiKhoaBieuList = thoiKhoaBieuList;
    }

    public int getCount(){
        return thoiKhoaBieuList.size();
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
        TextView txtMaLop, txtMaMon, txtThu, txtTiet, txtPhong, txtThoiGian;
    }

    public View getView(int i, View view, ViewGroup viewGroup){
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaLop      = (TextView) view.findViewById(R.id.textviewMaLop2);
            holder.txtMaMon     = (TextView) view.findViewById(R.id.textviewMaMon2);
            holder.txtThoiGian  = (TextView) view.findViewById(R.id.textviewThoiGian2);
            holder.txtPhong    = (TextView) view.findViewById(R.id.textviewPhong2);
            holder.txtThu  = (TextView) view.findViewById(R.id.textviewThu2);
            holder.txtTiet     = (TextView) view.findViewById(R.id.textviewTiet2);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        final ThoiKhoaBieu thoiKhoaBieu = thoiKhoaBieuList.get(i);

        holder.txtMaLop.setText("Mã lớp: " + thoiKhoaBieu.getMaLop());
        holder.txtMaMon.setText("Mã Môn: "  + thoiKhoaBieu.getMaMH());
        holder.txtPhong.setText("Phòng: " + thoiKhoaBieu.getPhongHoc());
        holder.txtThu.setText("Thứ: " + thoiKhoaBieu.getThu());
        holder.txtTiet.setText("Tiết bắt đầu: " + thoiKhoaBieu.getTietBD());
        holder.txtThoiGian.setText("Thời gian: " + thoiKhoaBieu.getThoiGian());
        return view;
    }
}
