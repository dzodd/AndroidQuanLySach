package vn.edu.stu.androidqlsach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ChitietActivity extends AppCompatActivity {

    TextView name;
    ImageView image;
    Button fabthem;

    TextView tacgia1;
    TextView phanloai1;
    TextView gia1;
    TextView code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet);
        name = findViewById(R.id.txtchitiet);
        image=findViewById(R.id.imgchitiet);


        gia1=findViewById(R.id.txtchitietgia);
        tacgia1=findViewById(R.id.txttacgia);
        fabthem=findViewById(R.id.fabthem);
        phanloai1=findViewById(R.id.txtchitietloai);
        code=findViewById(R.id.txtchitietma);

        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image",0));

        phanloai1.setText(intent.getStringExtra("phanloai"));
        code.setText(intent.getStringExtra("masp"));
        tacgia1.setText(intent.getStringExtra("tacgia"));
        gia1.setText(intent.getStringExtra("gia"));
        addEvents();
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
    private void addEvents() {
        fabthem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ThemsuachitietActivity.class);
                startActivity(intent);

            }
        });
    }
}