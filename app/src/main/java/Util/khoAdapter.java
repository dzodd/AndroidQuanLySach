package Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import model.kho;
import vn.edu.stu.androidqlsach.R;

public class khoAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<kho> khoList;

    public khoAdapter(Context context, int layout, List<kho> khoList) {
        this.context = context;
        this.layout = layout;
        this.khoList = khoList;
    }

    @Override
    public int getCount() {
        return  khoList.size();
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
        ImageView imgkho1;
        TextView txtloai1;
        TextView txtloaimota1;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder;
        if (convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            holder=new Viewholder();
            holder.txtloai1=(TextView) convertView.findViewById(R.id.txtloai);
            holder.txtloaimota1=(TextView) convertView.findViewById(R.id.txtloaimota);
            holder.imgkho1=(ImageView) convertView.findViewById(R.id.imgkho);

            convertView.setTag(holder);
        }else {
            holder=(Viewholder) convertView.getTag();
        }


        //gan gia tri
        kho kho= khoList.get(position);
        holder.txtloai1.setText(kho.getPhanloai());
        holder.txtloaimota1.setText(kho.getMota());
        holder.imgkho1.setImageResource(kho.getHinhanh());

        return convertView;


    }
}
