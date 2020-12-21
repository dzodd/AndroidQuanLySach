    package vn.edu.stu.androidqlsach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import Util.MyMapFragment;

    public class AboutActivity extends AppCompatActivity implements OnMapReadyCallback {
        private MyMapFragment myMapFragment;
        GoogleMap gMap;
        Button button1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_about);

            SupportMapFragment supportMapFragment=(SupportMapFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragment2);
            supportMapFragment.getMapAsync(this);

        }




        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.menu, menu);

            return super.onCreateOptionsMenu(menu);


        }

        /*@Override
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
                    Intent intent2=new Intent(getApplicationContext(),KhoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.menuehome:
                    Intent intent3=new Intent(getApplicationContext(),ActivitySach.class);
                    startActivity(intent3);
            }

            return super.onOptionsItemSelected(item);
        }*/

        @Override
        public void onMapReady(GoogleMap googleMap) {
            gMap=googleMap;
            gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    LatLng sydney = new LatLng(10.738266670055731, 106.67779698237196);
                    googleMap.addMarker(new MarkerOptions()
                            .position(sydney)
                            .title("Marker in STU"));
                }
            });
        }
    }