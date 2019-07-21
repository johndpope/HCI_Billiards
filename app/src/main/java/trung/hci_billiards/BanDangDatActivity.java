package trung.hci_billiards;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class BanDangDatActivity extends AppCompatActivity {

    Button banDangDat, lichSuDatBan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_dang_dat);

        Intent intent = getIntent();
        String loaiBan = intent.getStringExtra(DatBan.LOAI_BAN);
        String ngayDen = intent.getStringExtra(DatBan.NGAY_DEN);
        String gioDen = intent.getStringExtra(DatBan.GIO_DEN);
        Toast.makeText(this,loaiBan + ngayDen + gioDen, Toast.LENGTH_LONG).show();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_banDangDat, BookingFragment.newInstance());
        transaction.commit();
    }
}
