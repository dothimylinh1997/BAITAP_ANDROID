package com.example.tuan6bai1;
import java.util.ArrayList;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NhanVienAdapter  extends ArrayAdapter<NhanVien>
{
    Activity context=null;
    ArrayList<NhanVien>myArray=null;
    int layoutId;
    public NhanVienAdapter(Activity context,
                          int layoutId,
                          ArrayList<NhanVien>arr){
        super(context, layoutId, arr);
        this.context=context;
        this.layoutId=layoutId;
        this.myArray=arr;
    }
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater=
                context.getLayoutInflater();
        convertView=inflater.inflate(layoutId, null);
        //chỉ là test thôi, bạn có thể bỏ If đi
        if(myArray.size()>0 && position>=0)
        {
            //dòng lệnh lấy TextView ra để hiển thị Mã và tên lên
            final TextView txtdisplay=(TextView)
                    convertView.findViewById(R.id.txtitem);
            //lấy ra nhân viên thứ position
            final NhanVien emp=myArray.get(position);
            //đưa thông tin lên TextView
            //emp.toString() sẽ trả về Id và Name
            txtdisplay.setText(emp.toString());
            //lấy ImageView ra để thiết lập hình ảnh cho đúng
            final ImageView imgitem=(ImageView)
                    convertView.findViewById(R.id.imgitem);
            //nếu là Nữ thì lấy hình con gái
            if(emp.isGender())
                imgitem.setImageResource(R.drawable.icongirl);
            else//nếu là Nam thì lấy hình con trai
                imgitem.setImageResource(R.drawable.iconboy );
        }
        //Vì View là Object là dạng tham chiếu đối tượng, nên
        //mọi sự thay đổi của các object bên trong convertView
        //thì nó cũng biết sự thay đổi đó
        return convertView;//trả về View này, tức là trả luôn
        //về các thông số mới mà ta vừa thay đổi
    }
    }
}
