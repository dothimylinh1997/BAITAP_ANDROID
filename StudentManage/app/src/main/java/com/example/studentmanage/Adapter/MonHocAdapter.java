package com.example.studentmanage.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentmanage.Activity.ActivityMonHoc;
import com.example.studentmanage.Activity.UpdateMonHoc;
import com.example.studentmanage.Class.MonHoc;
import com.example.studentmanage.R;

import java.util.List;

public class MonHocAdapter extends BaseAdapter {
    private ActivityMonHoc context;
    private int layout;
    private List<MonHoc> monHocList;

    public MonHocAdapter(ActivityMonHoc context, int layout, List<MonHoc> monHocList) {
        this.context = context;
        this.layout = layout;
        this.monHocList = monHocList;
    }

    @Override
    public int getCount() {
        return monHocList.size();
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
        TextView txtMaMH, txtTenMH;
        ImageView imgEdit, imgDelete;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaMH    = (TextView) view.findViewById(R.id.textviewMaMH);
            holder.txtTenMH   = (TextView) view.findViewById(R.id.textviewTenMH);
            holder.imgDelete   = (ImageView)view.findViewById(R.id.imageviewDeleteMH);
            holder.imgEdit     = (ImageView)view.findViewById(R.id.imageviewEditMonHoc);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        final MonHoc monHoc = monHocList.get(i);

        holder.txtMaMH.setText("Mã môn học: "+ monHoc.getMaMH());
        holder.txtTenMH.setText("Tên môn học: "+ monHoc.getTenMH());


        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateMonHoc.class);
                intent.putExtra("dataMonHoc", monHoc);
                context.startActivity(intent);
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XacNhanXoa(monHoc.getTenMH(), monHoc.getMaMH());
            }
        });

        return view;
    }

    private void XacNhanXoa(String ten, final String mamh ){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa môn học " + ten + " không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int i) {
                context.DeleteMonHoc(mamh);
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        dialogXoa.show();
    }
}
