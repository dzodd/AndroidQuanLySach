package vn.edu.stu.androidqlsach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Activityhinhanh extends AppCompatActivity {

    ArrayList<Integer> dshinhanh;
    ArrayAdapter adapterHinh;
    int resultCodeHinh = 115;
    ListView lvhinhanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityhinhanh);

        addControls();
        addEvents();
    }
    private void addEvents() {
        lvhinhanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int hinh=(dshinhanh.get(position));
                Intent intent=new Intent(Activityhinhanh.this,ThemsuachitietActivity.class);
                intent.putExtra("TRAHINH",hinh);
                setResult(resultCodeHinh,intent);
                finish();
            }

        });
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

    private void addControls() {
        dshinhanh = new ArrayList<>();
        dshinhanh.add(R.drawable.baybuoctoimuahe);
        dshinhanh.add(R.drawable.aikhoctrencay);
        dshinhanh.add(R.drawable.conchimxanhbiecbayve);
        dshinhanh.add(R.drawable.caychuoinondigiayxanh);
        dshinhanh.add(R.drawable.haisophan);
        dshinhanh.add(R.drawable.dangnhap);
        dshinhanh.add(R.drawable.kieuhanhvadinhkien);
        dshinhanh.add(R.drawable.tiengchimhot);
        dshinhanh.add(R.drawable.tienggoinoihoangia);
        dshinhanh.add(R.drawable.lambanvoibauroi);
        lvhinhanh=findViewById(R.id.lvhinh);
        adapterHinh = new ArrayAdapter<>(Activityhinhanh.this,android.R.layout.simple_list_item_1, dshinhanh);
        lvhinhanh.setAdapter(adapterHinh);
    }
}