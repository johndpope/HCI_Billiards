package trung.hci_billiards;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.vorlonsoft.android.rate.AppRate;
import com.vorlonsoft.android.rate.OnClickButtonListener;
import com.vorlonsoft.android.rate.StoreType;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String BILLIARD_NAME = "bida_name";
    public static final String BILLIARD_ADDRESS = "bida_address";
    private static final String TAG = "MainActivity";

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
                    selectedFragment = BookingFragment.newInstance();
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

        Button den = findViewById(R.id.btnDen);

        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
            @Override
            public void onSuccess(Account account) {
                TextView txtId = findViewById(R.id.txtId);
                TextView txtInfo = findViewById(R.id.txtInfo);
                txtId.setText("Id: " + account.getId());
//                if(account.getPhoneNumber().){
//                    txtInfo.setText(String.format("Email: %s", account.getEmail()));
//                }else{
//                    txtId.setText(String.format("Phone: %s", account.getPhoneNumber()));
//                }


            }

            @Override
            public void onError(AccountKitError accountKitError) {

            }
        });

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
        switch (item.getItemId()) {
            case R.id.side_nav_dang_xuat:
                Toast.makeText(this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                AccountKit.logOut();
                finish();
                break;

            case R.id.side_nav_thong_ton:
                selectedFragment = new ThongTinNguoiDungFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                break;

            case R.id.side_nav_cai_dat:
                selectedFragment = HomeFragment.newInstance();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.frame_layout, selectedFragment);
                transaction1.commit();
                break;
        }


        return true;
    }

    public void clicktoview(View view) {
        ImageView imageViewHomeFragment = findViewById(R.id.btnPopular);
        Intent intent = new Intent(MainActivity.this, DatBan.class);
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

//    public void clickToViewListBtnHeader(View view) {
//        Button button = findViewById(R.id.btnSearchHeader);
//        Intent intent = new Intent(MainActivity.this, ListBilliards.class);
//        startActivity(intent);
//    }


    public void clicktoviewdetailByNear(View view) {
        ImageView imageView = findViewById(R.id.imgDetail);
        Intent intent = new Intent(this, BilliardDetail.class);
        intent.putExtra(MainActivity.BILLIARD_NAME,"Billiard HCI Assignment");
        intent.putExtra(MainActivity.BILLIARD_ADDRESS,"Quận 12 Tô Ký");
        startActivity(intent);
    }

    public void clickToDatBan(View view) {
        Button button = findViewById(R.id.btnDatBan);
        Intent intent = new Intent(this, DatBan.class);
        intent.putExtra(MainActivity.BILLIARD_NAME,"Billiard HCI Assignment");
        intent.putExtra(MainActivity.BILLIARD_ADDRESS,"Quận 12 Tô Ký");
        startActivity(intent);
    }

    public void clickToDatBanImg(View view) {
        ImageView imageView = findViewById(R.id.imgDiemDenGanNhat);
        Intent intent = new Intent(this, DatBan.class);
        startActivity(intent);
    }

    public void rate(View view) {
        AppRate.with(MainActivity.this).setStoreType(StoreType.GOOGLEPLAY)

                .setInstallDays((byte) 0) // default 10, 0 means install day
                .setLaunchTimes((byte) 3) // default 10
                .setRemindInterval((byte) 2) // default 1
                .setRemindLaunchTimes((byte) 2) // default 1 (each launch)
                .setShowLaterButton(true) // default true
                .setDebug(false) // default false
                //Java 8+: .setOnClickButtonListener(which -> Log.d(MainActivity.class.getName(), Byte.toString(which)))
                .setOnClickButtonListener(new OnClickButtonListener() { // callback listener.
                    @Override
                    public void onClickButton(byte which) {
                        Log.d(MainActivity.class.getName(), Byte.toString(which));
                    }
                })
                .monitor();

        if (AppRate.with(MainActivity.this).getStoreType() == StoreType.GOOGLEPLAY) {
            //Check that Google Play is available
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this) != ConnectionResult.SERVICE_MISSING) {
                // Show a dialog if meets conditions
                AppRate.showRateDialogIfMeetsConditions(MainActivity.this);
            }
        } else {
            // Show a dialog if meets conditions
            AppRate.showRateDialogIfMeetsConditions(MainActivity.this);
        }
    }

    public void layoutgannhat1(View view) {
        Intent intent = new Intent(this,DatBan.class);
        TextView textView = findViewById(R.id.txtNameGanNhat1);
        TextView textView1 = findViewById(R.id.txtDiaChiGanNhat1);
        String diachi = textView1.getText().toString();
        intent.putExtra(BILLIARD_ADDRESS,diachi);
        String name = textView.getText().toString();
        intent.putExtra(BILLIARD_NAME,name);
        startActivity(intent);
    }
    public void layoutgannhat2(View view) {
        Intent intent = new Intent(this,DatBan.class);
        TextView textView = findViewById(R.id.txtNameGanNhat2);
        TextView textView1 = findViewById(R.id.txtDiaChiGanNhat2);
        String diachi = textView1.getText().toString();
        intent.putExtra(BILLIARD_ADDRESS,diachi);
        String name = textView.getText().toString();
        intent.putExtra(BILLIARD_NAME,name);
        startActivity(intent);
    }
    public void layoutgannhat3(View view) {
        Intent intent = new Intent(this,DatBan.class);
        TextView textView = findViewById(R.id.txtNameGanNhat3);
        TextView textView1 = findViewById(R.id.txtDiaChiGanNhat3);
        String diachi = textView1.getText().toString();
        intent.putExtra(BILLIARD_ADDRESS,diachi);
        String name = textView.getText().toString();
        intent.putExtra(BILLIARD_NAME,name);
        startActivity(intent);
    }
    public void layoutgannhat4(View view) {
        Intent intent = new Intent(this,DatBan.class);
        TextView textView = findViewById(R.id.txtNameGanNhat4);
        TextView textView1 = findViewById(R.id.txtDiaChiGanNhat4);
        String diachi = textView1.getText().toString();
        intent.putExtra(BILLIARD_ADDRESS,diachi);
        String name = textView.getText().toString();
        intent.putExtra(BILLIARD_NAME,name);
        startActivity(intent);
    }
    public void layoutgannhat5(View view) {
        Intent intent = new Intent(this,DatBan.class);
        TextView textView = findViewById(R.id.txtNameGanNhat5);
        String name = textView.getText().toString();
        TextView textView1 = findViewById(R.id.txtDiaChiGanNhat5);
        String diachi = textView1.getText().toString();
        intent.putExtra(BILLIARD_ADDRESS,diachi);
        intent.putExtra(BILLIARD_NAME,name);
        startActivity(intent);
    }
    public void layoutgannhat6(View view) {
        Intent intent = new Intent(this,DatBan.class);
        TextView textView = findViewById(R.id.txtNameGanNhat6);
        String name = textView.getText().toString();
        TextView textView1 = findViewById(R.id.txtDiaChiGanNhat6);
        String diachi = textView1.getText().toString();
        intent.putExtra(BILLIARD_ADDRESS,diachi);
        intent.putExtra(BILLIARD_NAME,name);
        startActivity(intent);
    }
}
