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
import android.widget.Toast;

import java.util.List;

public class KhoaAdapter extends BaseAdapter {
    private ActivityKhoa context;
    private int layout;
    private List<Khoa> khoaList;

    public KhoaAdapter(ActivityKhoa context, int layout, List<Khoa> khoaList) {
        this.context = context;
        this.layout = layout;
        this.khoaList = khoaList;
    }


    @Override
    public int getCount() {
        return khoaList.size();
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
        TextView txtMaKhoa, txtTenKhoa;
        ImageView edtSua, edtXoa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaKhoa    = (TextView)view.findViewById(R.id.textviewMaKhoaCustom);
            holder.txtTenKhoa   = (TextView)view.findViewById(R.id.textviewTenKhoaCustom);
            holder.edtSua       = (ImageView)view.findViewById(R.id.imageviewEdit);
            holder.edtXoa       = (ImageView)view.findViewById(R.id.imageviewDelete);


            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }


        final Khoa khoa = khoaList.get(i);

        holder.txtMaKhoa.setText("Mã Khoa: "+ khoa.getMaKhoa());
        holder.txtTenKhoa.setText("Tên Khoa: " + khoa.getTenKhoa());

        // bắt sự kiện xóa và sửa

        holder.edtSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateKhoa.class);
                intent.putExtra("dataKhoa", khoa);
                context.startActivity(intent);
            }
        });

        holder.edtXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XacNhanXoa(khoa.getTenKhoa(), khoa.getMaKhoa());
            }
        });
        return view;

    }
    private void XacNhanXoa(String ten, final String makhoa ){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa khoa " + ten + " không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                context.DeleteKhoa(makhoa);
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
