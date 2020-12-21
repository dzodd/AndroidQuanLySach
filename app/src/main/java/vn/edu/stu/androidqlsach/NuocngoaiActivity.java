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

public class NuocngoaiActivity extends AppCompatActivity {

    ListView listSach1;
    ArrayList<Sach> arraySach1;
    sachAdapter adapter1;
    String[] tensach={"Kiêu hảnh và định kiến","Hai Số Phận","Tiếng Chim Hót Trong Bụi Mận","Tiếng Gọi Nơi Hoang dã"};
    String[] tacgia={"Austen ","Jeffrey Archer ","Jeffrey Archer ","Colleen McCullough","Jack London"};
    String[] gia={"Giá: 118000 đ","Giá: 250000 đ","Giá: 65000 đ","Giá: 180000 đ"};
    String[] phanloai={"nuocngoai","nuocngoai","nuocngoai","nuocngoai"};
    String[] masanpham={"CODE6","CODE7","CODE8","CODE9",};
    int[]hinhanh={R.drawable.kieuhanhvadinhkien,R.drawable.haisophan,R.drawable.tiengchimhot,R.drawable.tienggoinoihoangia};

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
        adapter1=new sachAdapter(NuocngoaiActivity.this, R.layout.dong_sach, arraySach1);
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

        arraySach1.add(new Sach("CODE6","Kiêu hảnh và định kiến","nuocngoai","Giá: 118000 đ","Austen ",(R.drawable.kieuhanhvadinhkien)));
        arraySach1.add(new Sach("CODE7","Hai Số Phận","nuocngoai","Giá: 250000 đ","Jeffrey Archer ",(R.drawable.haisophan)));
        arraySach1.add(new Sach("CODE8","Tiếng Chim Hót Trong Bụi ","nuocngoai","Giá: 65000 đ","Colleen McCullough",(R.drawable.tiengchimhot)));
        arraySach1.add(new Sach("CODE9","Tiếng Gọi Nơi Hoang dã","nuocngoai","Giá: 180000 đ","Jack London",(R.drawable.tienggoinoihoangia)));

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
    }}

