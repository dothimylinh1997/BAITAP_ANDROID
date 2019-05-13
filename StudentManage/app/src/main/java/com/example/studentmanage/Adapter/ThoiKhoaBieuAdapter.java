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

import com.example.studentmanage.Activity.ActivityTKB;
import com.example.studentmanage.Activity.AddTKB;
import com.example.studentmanage.Activity.UpdateTKB;
import com.example.studentmanage.Class.ThoiKhoaBieu;
import com.example.studentmanage.R;

import java.util.List;

public class ThoiKhoaBieuAdapter extends BaseAdapter {
    private ActivityTKB context;
    private int layout;
    private List<ThoiKhoaBieu> thoiKhoaBieuList;

    public ThoiKhoaBieuAdapter(ActivityTKB context, int layout, List<ThoiKhoaBieu> thoiKhoaBieuList){
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
        ImageView imgEdit, imgDelete;
    }

    public View getView(int i, View view, ViewGroup viewGroup){
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaLop      = (TextView) view.findViewById(R.id.textviewMaLop1);
            holder.txtMaMon     = (TextView) view.findViewById(R.id.textviewMaMon1);
            holder.txtThoiGian  = (TextView) view.findViewById(R.id.textviewThoiGian);
            holder.txtPhong    = (TextView) view.findViewById(R.id.textviewPhong);
            holder.txtThu  = (TextView) view.findViewById(R.id.textviewThu);
            holder.txtTiet     = (TextView) view.findViewById(R.id.textviewTiet);
            holder.imgEdit = (ImageView) view.findViewById(R.id.imageviewEdittkb);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imageviewDeletetkb);
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

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateTKB.class);
                intent.putExtra("dataTKB", thoiKhoaBieu);
                context.startActivity(intent);
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                XacNhanXoa(thoiKhoaBieu.getMaLop(), thoiKhoaBieu.getMaMH());
            }
        });
        return view;
    }
    private void XacNhanXoa(final String malop, final String mamon ){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa thời khóa biểu môn " + mamon + " của lớp " + malop + " không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                context.DeleteTKB(malop, mamon);
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
