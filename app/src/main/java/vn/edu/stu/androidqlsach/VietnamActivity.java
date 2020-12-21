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

public class VietnamActivity extends AppCompatActivity {
    ListView listSach1;
    ArrayList<Sach> arraySach1;
    sachAdapter adapter1;
    String[] tensach={"Ngồi Khóc Trên Cây","Bảy Bước Tới Mùa Hè","Cây Chuối Non Đi Giày Xanh","Con chim xanh biếc bay về","Làm Bạn Với Bầu Trời"};
    String[] tacgia={"Nguyễn Nhật Ánh","Nguyễn Nhật Ánh","Nguyễn Nhật Ánh","Nguyễn Nhật Ánh","Nguyễn Nhật Ánh"};
    String[] gia={"Giá: 75000 đ","Giá: 95800 đ","Giá: 35600 đ","Giá: 69400 đ","Giá: 92000 đ"};
    String[] phanloai={"vietnam","vietnam","vietnam","vietnam","vietnam"};
    String[] masanpham={"CODE1","CODE2","CODE3","CODE4","CODE5"};
    int[]hinhanh={R.drawable.aikhoctrencay,R.drawable.baybuoctoimuahe,R.drawable.caychuoinondigiayxanh,R.drawable.conchimxanhbiecbayve,R.drawable.lambanvoibauroi};

    public ArrayList<Sach> getArraySach1() {
        return arraySach1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vietnam);
        addControls();
        AnhXa();

        adapter1.notifyDataSetChanged();
        listSach1.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position>=0&&position<arraySach1.size()){
                            arraySach1.remove(position);
                            adapter1.notifyDataSetChanged();
                        }
                        return true;
                    }
                }
        );
        adapter1.notifyDataSetChanged();
    }
    private void addControls() {
        arraySach1=new ArrayList<>();
        adapter1=new sachAdapter(VietnamActivity.this, R.layout.dong_sach, arraySach1);
        listSach1=findViewById(R.id.lvvietnam);
        listSach1.setAdapter(adapter1);

        listSach1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                adapter1.notifyDataSetChanged();
            }
        });

    }
    private void AnhXa() {

        arraySach1.add(new Sach("CODE1","Ngồi Khóc Trên Cây","vietnam","Giá: 75000 đ","Nguyễn Nhật Ánh",(R.drawable.aikhoctrencay)));
        arraySach1.add(new Sach("CODE2","Bảy Bước Tới Mùa Hè","vietnam","Giá: 95800 đ","Nguyễn Nhật Ánh",(R.drawable.baybuoctoimuahe)));
        arraySach1.add(new Sach("CODE3","Cây Chuối Non Đi Giày Xanh","vietnam","Giá: 35600 đ","Nguyễn Nhật Ánh",(R.drawable.caychuoinondigiayxanh)));
        arraySach1.add(new Sach("CODE4","Con chim xanh biếc bay về","vietnam","Giá: 69400 đ","Nguyễn Nhật Ánh",(R.drawable.conchimxanhbiecbayve)));
        arraySach1.add(new Sach("CODE5","Làm Bạn Với Bầu Trời","vietnam","Giá: 92000 đ","Nguyễn Nhật Ánh",(R.drawable.lambanvoibauroi)));
        getArraySach1();
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
            case R.id.menuabout:
                Intent intent=new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.menukho:
                Intent intent2=new Intent(getApplicationContext(),khoActivity.class);
                startActivity(intent2);
                break;
            case R.id.menuehome:
                Intent intent3=new Intent(getApplicationContext(),ActivitySach.class);
                startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);
    }
}