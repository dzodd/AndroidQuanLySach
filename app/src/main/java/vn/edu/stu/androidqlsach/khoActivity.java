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

import Util.khoAdapter;
import model.kho;

public class khoActivity extends AppCompatActivity {

    ListView listkho;
    ArrayList<kho> arraykho;
    khoAdapter adapter;
    String[] tenkho={"Sách Việt Nam","Sách Nước Ngoài"};
    String[] mota={"Bao gồm truyện Nguyễn Nhật Ánh","Hỗn hợp"};

    int[]hinhanh={R.drawable.logosach,R.drawable.ic_sach};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kho);
        addControls();
        AnhXa();
        adapter=new khoAdapter(this,R.layout.dong_kho,arraykho);
        listkho.setAdapter(adapter);
        listkho.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position>=0&&position<arraykho.size()){
                            arraykho.remove(position);
                            adapter.notifyDataSetChanged();
                        }
                        return true;
                    }
                }
        );
        adapter.notifyDataSetChanged();
    }

    private void AnhXa() {

        arraykho.add(new kho("Sách Việt Nam","Bao gồm truyện Nguyễn Nhật Ánh",R.drawable.logosach));
        arraykho.add(new kho("Sách Nước Ngoài","Hỗn hợp",R.drawable.ic_sach));

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



        arraykho=new ArrayList<>();
        adapter=new khoAdapter(khoActivity.this,R.layout.dong_kho,arraykho);
        listkho=findViewById(R.id.lvkho);
        listkho.setAdapter(adapter);
        listkho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent=new Intent(getApplicationContext(),VietnamActivity.class);
                    startActivity(intent);
                    intent.putExtra("name",tenkho[position]);
                    intent.putExtra("tacgia",mota[position]);
                    intent.putExtra("tacgia",hinhanh[position]);
                    adapter.notifyDataSetChanged();}
                if (position==1){
                    Intent intent=new Intent(getApplicationContext(),NuocngoaiActivity.class);
                    startActivity(intent);
                    intent.putExtra("name",tenkho[position]);
                    intent.putExtra("tacgia",mota[position]);
                    intent.putExtra("tacgia",hinhanh[position]);
                    adapter.notifyDataSetChanged();}

            }

        });

    }
}