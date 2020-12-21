package Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import model.Sach;
import vn.edu.stu.androidqlsach.R;


public class sachAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Sach> sachList;

    public sachAdapter(Context context, int layout, List<Sach> sachList) {
        this.context = context;
        this.layout = layout;
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class Viewholder{
        ImageView imghinh;
        TextView txtten;
        TextView txtmota;
        TextView txtphanloai;
        TextView masanpham;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Viewholder holder;
        if (view==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder=new Viewholder();
            holder.txtten=(TextView) view.findViewById(R.id.textviewten);
            holder.txtmota=(TextView) view.findViewById(R.id.txtviewmota);
            holder.imghinh=(ImageView) view.findViewById(R.id.imgsach);
            holder.txtphanloai=view.findViewById(R.id.txtphanloai);
            holder.masanpham=view.findViewById(R.id.masanpham);
            view.setTag(holder);
        }else {
            holder=(Viewholder) view.getTag();
        }


        //gan gia tri
        Sach sach= sachList.get(position);
        holder.txtten.setText(sach.getTensach());
        holder.txtmota.setText(sach.getTacgia());
        holder.masanpham.setText(sach.getMasach());
        holder.txtphanloai.setText(sach.getGia());
        holder.imghinh.setImageResource(sach.getHinhanh());

        return view;
    }
}
