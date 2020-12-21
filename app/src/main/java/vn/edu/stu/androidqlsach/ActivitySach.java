package vn.edu.stu.androidqlsach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Util.sachAdapter;
import model.Sach;

public class ActivitySach extends AppCompatActivity {


    ListView listSach;
    ArrayList<Sach> arraySach;
    sachAdapter adapter;
    String[] tensach={"Ngồi Khóc Trên Cây","Bảy Bước Tới Mùa Hè","Cây Chuối Non Đi Giày Xanh","Con chim xanh biếc bay về","Làm Bạn Với Bầu Trời","Kiêu hảnh và định kiến","Hai Số Phận","Tiếng Chim Hót Trong Bụi Mận","Tiếng Gọi Nơi Hoang dã"};
    String[] tacgia={"Nguyễn Nhật Ánh","Nguyễn Nhật Ánh","Nguyễn Nhật Ánh","Nguyễn Nhật Ánh","Nguyễn Nhật Ánh","Austen ","Jeffrey Archer ","Jeffrey Archer ","Colleen McCullough","Jack London"};
    String[] gia={"Giá: 75000 đ","Giá: 95800 đ","Giá: 35600 đ","Giá: 69400 đ","Giá: 92000 đ","Giá: 118000 đ","Giá: 250000 đ","Giá: 65000 đ","Giá: 180000 đ"};
    String[] phanloai={"vietnam","vietnam","vietnam","vietnam","vietnam","nuocngoai","nuocngoai","nuocngoai","nuocngoai",};
    String[] masanpham={"CODE1","CODE2","CODE3","CODE4","CODE5","CODE6","CODE7","CODE8","CODE9",};
    int[]hinhanh={R.drawable.aikhoctrencay,R.drawable.baybuoctoimuahe,R.drawable.caychuoinondigiayxanh,R.drawable.conchimxanhbiecbayve,R.drawable.lambanvoibauroi,R.drawable.kieuhanhvadinhkien,R.drawable.haisophan,R.drawable.tiengchimhot,R.drawable.tienggoinoihoangia};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);
        addControls();
        AnhXa();
        addEvents();
        adapter.notifyDataSetChanged();
        listSach.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position>=0&&position<arraySach.size()){
                            arraySach.remove(position);
                            adapter.notifyDataSetChanged();
                        }
                        return true;
                    }
                }
        );
        adapter.notifyDataSetChanged();

    }

    private void addEvents() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuexit:
                finishAffinity();
                break;
           // case R.id.menuabout:
               // Intent intent=new Intent(getApplicationContext(),AboutActivity.class);
               // startActivity(intent);
              //  break;
           // case R.id.menukho:
                //Intent intent2=new Intent(getApplicationContext(),KhoActivity.class);
               // startActivity(intent2);
               // break;
            case R.id.menuehome:
                Intent intent3=new Intent(getApplicationContext(),ActivitySach.class);
                startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);
    }

    private void addControls() {
        arraySach=new ArrayList<>();
        adapter=new sachAdapter(ActivitySach.this, R.layout.dong_sach, arraySach);
        listSach=findViewById(R.id.lvsach);
        listSach.setAdapter(adapter);

        listSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),ChitietActivity.class);
                intent.putExtra("name",tensach[position]);
                intent.putExtra("tacgia",tacgia[position]);
                intent.putExtra("gia",gia[position]);
                intent.putExtra("phanloai",phanloai[position]);
                intent.putExtra("image",hinhanh[position]);
                intent.putExtra("masp",masanpham[position]);
                startActivity(intent);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void AnhXa() {


        arraySach.add(new Sach("CODE1","Ngồi Khóc Trên Cây","vietnam","Giá: 75000 đ","Nguyễn Nhật Ánh",(R.drawable.aikhoctrencay)));
        arraySach.add(new Sach("CODE2","Bảy Bước Tới Mùa Hè","vietnam","Giá: 95800 đ","Nguyễn Nhật Ánh",(R.drawable.baybuoctoimuahe)));
        arraySach.add(new Sach("CODE3","Cây Chuối Non Đi Giày Xanh","vietnam","Giá: 35600 đ","Nguyễn Nhật Ánh",(R.drawable.caychuoinondigiayxanh)));
        arraySach.add(new Sach("CODE4","Con chim xanh biếc bay về","vietnam","Giá: 69400 đ","Nguyễn Nhật Ánh",(R.drawable.conchimxanhbiecbayve)));
        arraySach.add(new Sach("CODE5","Làm Bạn Với Bầu Trời","vietnam","Giá: 92000 đ","Nguyễn Nhật Ánh",(R.drawable.lambanvoibauroi)));
        arraySach.add(new Sach("CODE6","Kiêu hảnh và định kiến","nuocngoai","Giá: 118000 đ","Austen ",(R.drawable.kieuhanhvadinhkien)));
        arraySach.add(new Sach("CODE7","Hai Số Phận","nuocngoai","Giá: 250000 đ","Jeffrey Archer ",(R.drawable.haisophan)));
        arraySach.add(new Sach("CODE8","Tiếng Chim Hót Trong Bụi ","nuocngoai","Giá: 65000 đ","Colleen McCullough",(R.drawable.tiengchimhot)));
        arraySach.add(new Sach("CODE9","Tiếng Gọi Nơi Hoang dã","nuocngoai","Giá: 180000 đ","Jack London",(R.drawable.tienggoinoihoangia)));


    }}
