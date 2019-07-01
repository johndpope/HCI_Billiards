package trung.hci_billiards;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Application;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = HomeFragment.newInstance();
                    break;
                case R.id.navigation_near_me:
                    selectedFragment = NearMeFragment.newInstance();
                    break;
                case R.id.navigation_search:
                    selectedFragment = SearchFragment.newInstance();
                    break;
                case R.id.navigation_hot_deal:
                    selectedFragment = HotDealFragment.newInstance();
                    break;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();

            return true;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottom_navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.drawer_navigation);




        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()){
            case R.id.side_nav_dang_xuat:
                Toast.makeText(this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                finish();
                break;

//            case R.id.side_nav_trang_chu:
//                selectedFragment = HomeFragment.newInstance();
//                break;
//
//            case R.id.side_nav_danh_muc:
//                selectedFragment = SearchFragment.newInstance();
//                break;
//
//            case R.id.side_nav_cai_dat:
//                selectedFragment = HomeFragment.newInstance();
//                break;
        }

//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_layout, selectedFragment);
//        transaction.commit();

        return true;
    }

    public void clicktoview(View view) {
        ImageView imageViewHomeFragment = findViewById(R.id.btnPopular);
        Intent intent =new Intent(MainActivity.this,ListBilliards.class);
        startActivity(intent);
    }


    public void clickToViewList(View view) {
        Button button = findViewById(R.id.btnPlaceChallenge);
        Intent intent = new Intent(MainActivity.this, ListBilliards.class);
        startActivity(intent);
    }


    public void clickToviewListByTxt(View view) {
        TextView textView = findViewById(R.id.txtDiemDenUyTin);
        Intent intent = new Intent(MainActivity.this, ListBilliards.class);
        startActivity(intent);
    }

    public void clickToviewListByTxtXuHuong(View view) {
        TextView textView = findViewById(R.id.txtXuhuonghiennay);
        Intent intent = new Intent(MainActivity.this, ListBilliards.class);
        startActivity(intent);
    }

    public void clickToViewListBtnHeader(View view) {
        Button button = findViewById(R.id.btnSearchHeader);
        Intent intent = new Intent(MainActivity.this, ListBilliards.class);
        startActivity(intent);
    }


    public void clicktoviewdetailByNear(View view) {
        ImageView imageView = findViewById(R.id.imgDetail);
        Intent intent = new Intent(this, BilliardDetail.class);
        startActivity(intent);
    }

    public void clickToDatBan(View view) {
        Button button = findViewById(R.id.btnDatBan);
        Intent intent = new Intent(this, DatBan.class);
        startActivity(intent);
    }

    public void clickToDatBanImg(View view) {
        ImageView imageView =findViewById(R.id.imgDiemDenGanNhat);
        Intent intent = new Intent(this,DatBan.class);
        startActivity(intent);
    }

}
