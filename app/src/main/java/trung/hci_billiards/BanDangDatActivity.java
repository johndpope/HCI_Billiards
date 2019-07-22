package trung.hci_billiards;

import androidx.appcompat.app.AppCompatActivity;


import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BanDangDatActivity extends AppCompatActivity {
    private static final String TAG = "BanDangDatActivity";
    Button banDangDat, lichSuDatBan;
    String loaiBan,ngayDen,gioDen, name, diachi;
    TextView textView,textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_dang_dat);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_banDangDat, new BookingFragment());
        transaction.commit();

        Log.d(TAG, "onCreate: Added bookingFragment");

        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.BILLIARD_NAME);
        diachi = intent.getStringExtra(MainActivity.BILLIARD_ADDRESS);
        textView = findViewById(R.id.txtBanDangDatName);

         loaiBan = intent.getStringExtra(DatBan.LOAI_BAN);
         ngayDen = intent.getStringExtra(DatBan.NGAY_DEN);
         gioDen = intent.getStringExtra(DatBan.GIO_DEN);
        Log.d(TAG, "onCreate: getId" + String.valueOf(textView));
        Toast.makeText(this,"Loại bàn : " + loaiBan +"\n" + "Ngày đến: " + ngayDen + "\n"+ "Giờ đến: " + gioDen,Toast.LENGTH_LONG ).show();

//         textView.setText(name);
//         textView1.setText(diachi);


    }

    public void clickToShowToask(View view) {
        Toast.makeText(this,"Loại bàn : " + loaiBan +"\n" + "Ngày đến: " + ngayDen + "\n"+ "Giờ đến: " + gioDen,Toast.LENGTH_LONG ).show();
    }
}
