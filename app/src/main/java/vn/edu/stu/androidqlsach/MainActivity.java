package vn.edu.stu.androidqlsach;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtUsername, txtPassword;
    CheckBox chkRememberMe;
    Button btndangky,btnexit,btndangnhap;
    final String COOKIE="COOKIE_DATA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        addControls();
        addEvents();
    }

    private void addControls() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        chkRememberMe = findViewById(R.id.chkRememberMe);
        btndangnhap = findViewById(R.id.btndangnhap);
        btnexit=findViewById(R.id.btnexit);
    }
    private void addEvents() {
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLogin();
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void xuLyLogin() {
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        if (kiemTraDangNhap(username, password)){
            Toast.makeText(
                    MainActivity.this,
                    "Login succeeded",
                    Toast.LENGTH_SHORT

            ).show();
            //Intent intent=new Intent(MainActivity.this,ActivitySach.class);
           // startActivity(intent);
            //finish();
            if (chkRememberMe.isChecked()){
                SharedPreferences preferences = getSharedPreferences(
                        COOKIE,
                        MODE_PRIVATE
                );
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();
            }


        }else{
            Toast.makeText(
                    MainActivity.this,
                    "Login failed",
                    Toast.LENGTH_SHORT
            ).show();
            SharedPreferences preferences = getSharedPreferences(
                    COOKIE,
                    MODE_PRIVATE
            );
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove("username");
            editor.remove("password");
            editor.apply();
        }
    }

    private boolean kiemTraDangNhap(String username, String password) {
        if (username.equalsIgnoreCase("admin")){
            if (password.equals("12345")){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences(
                COOKIE,
                MODE_PRIVATE
        );
        String username = preferences.getString("username", "");
        String password = preferences.getString("password", "");
        txtUsername.setText(username);
        txtPassword.setText(password);
    }

}