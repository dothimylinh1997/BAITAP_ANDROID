package com.example.managestudent;

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

import java.util.List;

public class LopAdapter extends BaseAdapter {
    private ActivityLop context;
    private int layout;
    private List<Lop> lopList;

    public LopAdapter(ActivityLop context, int layout, List<Lop> lopList) {
        this.context = context;
        this.layout = layout;
        this.lopList = lopList;
    }

    @Override
    public int getCount() {
        return lopList.size();
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
        TextView txtMaLop, txtTenLop, txtMaKhoa;
        ImageView imgEdit, imgDelete;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaLop    = (TextView) view.findViewById(R.id.textviewMaLopCustom);
            holder.txtTenLop   = (TextView) view.findViewById(R.id.textviewTenLopCustom);
            holder.txtMaKhoa   = (TextView) view.findViewById(R.id.textviewMaKhoaLopCustom);
            holder.imgDelete   = (ImageView)view.findViewById(R.id.imageviewDeleteLop);
            holder.imgEdit     = (ImageView)view.findViewById(R.id.imageviewEditLop);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        final Lop lop = lopList.get(i);

        holder.txtMaLop.setText(lop.getMaLop());
        holder.txtTenLop.setText(lop.getTenLop());
        holder.txtMaKhoa.setText(lop.getMaKhoa());

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateLop.class);
                intent.putExtra("dataLop", lop);
                context.startActivity(intent);
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XacNhanXoa(lop.getTenLop(), lop.getMaLop());
            }
        });

        return view;
    }
    private void XacNhanXoa(String ten, final String malop ){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa khoa " + ten + " không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                context.DeleteLop(malop);
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
