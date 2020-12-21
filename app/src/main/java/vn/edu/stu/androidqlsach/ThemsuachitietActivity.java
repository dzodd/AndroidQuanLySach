package vn.edu.stu.androidqlsach;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import model.Sach;

public class ThemsuachitietActivity extends AppCompatActivity {


    int resultCode=115;
    int requsetCodeHinh=113,resultCodeHinh=115;
    ImageView hinh;
    int hinhtrave;


    EditText txtten,txttacgia,txtgia,txtloai,txtma;
    Button btnthem;
    Button btnsua;
    Button btnChonhinh;
    Sach nn;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themsuachitiet);
        //lay cac control
        hinh=findViewById(R.id.imgchitiet);
        txtma=(EditText)findViewById(R.id.editText_ma);
        txtten=(EditText)findViewById(R.id.editText_ten);
        txttacgia=(EditText)findViewById(R.id.editText_tacgia);
        txtgia=(EditText)findViewById(R.id.editText_gia);
        txtloai=(EditText)findViewById(R.id.editText_loai);
        btnthem = findViewById(R.id.btnthem);
        btnsua=findViewById(R.id.btnsua);
        btnChonhinh=findViewById(R.id.btnChonhinh);
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
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLuu();

            }
        });

        btnChonhinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThemsuachitietActivity.this,Activityhinhanh.class);
                startActivityForResult(intent,requsetCodeHinh);

            }
        });
    }

    private void xuLyLuu() {
        nn=new Sach();
        nn.setMasach(txtma.getText().toString());
        nn.setTensach(txtten.getText().toString());
        nn.setPhanLoai(txtloai.getText().toString());
        nn.setGia(txtgia.getText().toString());
        nn.setTacgia(txttacgia.getText().toString());
        nn.setHinhanh(hinhtrave);
        Intent intent=getIntent();
        intent.putExtra("TRA", nn);
        setResult(resultCode,intent);

        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requsetCodeHinh == this.requsetCodeHinh) {
            if (resultCodeHinh == this.resultCodeHinh) {
                if (data.hasExtra("TRAHINH")) {
                    hinhtrave = (Integer) data.getSerializableExtra("TRAHINH");
                    hinh.setImageResource(hinhtrave);
                }
            }}}}