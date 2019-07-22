package trung.hci_billiards;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DatBan extends AppCompatActivity {
    public static final String LOAI_BAN = "LoaiBan";
    String loaiBan = BIDA_BANG;
    String ngayDen;
    public static final String NGAY_DEN = "NgayDen";
    public static final String GIO_DEN = "GioDen";
    TextView textView_date;
    TextView textView_Time;
    ImageView imgDateBack, imgDateNext;
    int date, month, yean;
    int date_tang;

    private static final String TAG = "DatBan";
    private static final String BIDA_BANG = "Bida Băng";
    private static final String BIDA_LO = "Bida Lỗ";
    String chonban ="";
    Dialog dialog;
    TextView txtLoaiBan,txtNameDatBan, txtDiachi;
    Button datbanngay;
    String name,diachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_ban);
        txtDiachi = findViewById(R.id.txtDiaChiDatBan);
        txtNameDatBan = findViewById(R.id.txtNameDatBan);

        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.BILLIARD_NAME);
        diachi = intent.getStringExtra(MainActivity.BILLIARD_ADDRESS);

        txtNameDatBan.setText(name);
        txtDiachi.setText(diachi);

        imgDateBack = findViewById(R.id.imgDateBack);
        imgDateNext = findViewById(R.id.imgDateNext);
        textView_date = findViewById(R.id.txtSetDate);
        textView_Time = findViewById(R.id.txtSetTime);

        final Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DATE);
        date_tang = date;
        month = calendar.get(Calendar.MONTH)+1;
        yean = calendar.get(Calendar.YEAR);
        textView_date.setText(date + "/" + month + "/" + yean);
        ngayDen = date + "/" + month + "/" + yean;
        imgDateNext.setClickable(true);
        imgDateNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((date_tang-date)>7){

                }else{
                    date_tang++;
                    textView_date.setText(date_tang + "/" + month + "/" + yean);
                    ngayDen = date_tang + "/" + month + "/" + yean;
                    chonban = "";
                    textView_Time.setText(chonban);
                }

            }
        });
        imgDateBack.setClickable(true);
        imgDateBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (date_tang==date){

                }else{
                    date_tang--;
                    textView_date.setText(date_tang + "/" + month + "/" + yean);
                    ngayDen = date_tang + "/" + month + "/" + yean;
                    chonban = "";
                    textView_Time.setText(chonban);
                }
            }
        });




        txtLoaiBan = findViewById(R.id.txtLoaiBan);
        txtLoaiBan.setText(BIDA_BANG);
        ImageView imgLoaiBan1, imgLoaiBan2;
        imgLoaiBan1 = findViewById(R.id.imgLoaiBan1);
        imgLoaiBan2 = findViewById(R.id.imgLoaiBan2);
        imgLoaiBan1.setClickable(true);
        imgLoaiBan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtLoaiBan.getText().toString().equals(BIDA_BANG)){
                    txtLoaiBan.setText(BIDA_LO);
                    loaiBan = BIDA_LO;
                    chonban = "";
                    textView_Time.setText(chonban);
                }else{
                    txtLoaiBan.setText(BIDA_BANG);
                    loaiBan = BIDA_BANG;
                    chonban = "";
                    textView_Time.setText(chonban);
                }
            }
        });
        imgLoaiBan2.setClickable(true);
        imgLoaiBan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtLoaiBan.getText().toString().equals(BIDA_BANG)){
                    txtLoaiBan.setText(BIDA_LO);
                    loaiBan = BIDA_LO;
                    chonban = "";
                    textView_Time.setText(chonban);
                }else{
                    txtLoaiBan.setText(BIDA_BANG);
                    loaiBan = BIDA_BANG;
                    chonban = "";
                    textView_Time.setText(chonban);
                }
            }
        });


        textView_Time.setClickable(true);
        textView_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loaiBan = txtLoaiBan.getText().toString();
                if (loaiBan.equals(BIDA_BANG)){
                    dialog = new Dialog(DatBan.this, android.R.style.Theme_Material_NoActionBar_Fullscreen);
                    dialog.setTitle("Đặt bàn bida lỗ");
                    dialog.setContentView(R.layout.activity_bida_bang);
                    dialog.show();
                }else{
                    dialog = new Dialog(DatBan.this, android.R.style.Theme_Material_NoActionBar_Fullscreen);
                    dialog.setTitle("Đặt bàn bida băng");
                    dialog.setContentView(R.layout.activity_bida_lo);
                    dialog.show();
                }

            }
        });

        datbanngay = findViewById(R.id.btnDatBanNgay);


    }

    public void Ban1sang(View view) {
        Button B = (Button)view;
        chonban = "Sáng: 8h - 12h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();

    }

    public void Ban2sang(View view) {
        Button B = (Button)view;
        chonban = "Sáng: 8h - 12h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();

    }
    public void clickToXemThemThongTin(View view) {
        TextView textView = findViewById(R.id.txtXemThemThongTin);
        Intent intent = new Intent(this,BilliardDetail.class);
        intent.putExtra(MainActivity.BILLIARD_NAME,name);
        intent.putExtra(MainActivity.BILLIARD_ADDRESS,diachi);
        startActivity(intent);
    }

    public void BanDaDuocDat(View view) {
        Toast.makeText(DatBan.this,"Bàn này đã có người đặt\nMời bạn chọn bàn khác", Toast.LENGTH_SHORT).show();
        new AlertDialog.Builder(DatBan.this)
                .setMessage("Bàn này đã có người đặt.\nMời bạn chọn bàn khác")
                .setPositiveButton("OK",null);
    }

    public void Ban3trua(View view) {
        Button B = (Button)view;
        chonban = "Trưa: 12h - 16h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }
    public void Ban3trua_lo(View view) {
        Button B = (Button)view;
        chonban = "Trưa: 12h - 16h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }
    public void Ban4trua(View view) {
        Button B = (Button)view;
        chonban = "Trưa: 12h - 16h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }


    public void Ban5trua(View view) {
        Button B = (Button)view;
        chonban = "Trưa: 12h - 16h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }
    public void Ban6trua(View view) {
        Button B = (Button)view;
        chonban = "Trưa: 12h - 16h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }

    public void Ban3chieu(View view) {
        Button B = (Button)view;
        chonban = "Chiều: 16h - 19h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }
    public void Ban3chieu_lo(View view) {
        Button B = (Button)view;
        chonban = "Chiều: 16h - 19h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }
    public void Ban4chieu(View view) {
        Button B = (Button)view;
        chonban = "Chiều: 16h - 19h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }
    public void Ban5chieu(View view) {
        Button B = (Button)view;
        chonban = "Chiều: 16h - 19h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }

    public void Ban6toi(View view) {
        Button B = (Button)view;
        chonban = "Tối: 19h - 21h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();
    }

    public void Ban1sang_lo(View view) {
        Button B = (Button)view;
        chonban = "Sáng: 8h - 12h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();

    }

    public void Ban2sang_lo(View view) {
        Button B = (Button)view;
        chonban = "Sáng: 8h - 12h - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();

    }

    public void clickToDatBanNgay(View view) {
        Log.d(TAG, "clickToDatBanNgay: " +  "dat ban");
        if (chonban.length()>0){
            Intent intent = new Intent(DatBan.this, BanDangDatActivity.class);
            intent.putExtra(MainActivity.BILLIARD_NAME,name);
            intent.putExtra(MainActivity.BILLIARD_ADDRESS,diachi);
            intent.putExtra(NGAY_DEN,ngayDen);
            intent.putExtra(GIO_DEN,chonban);
            intent.putExtra(LOAI_BAN,loaiBan);
            startActivity(intent);
        }else{
            Toast.makeText(DatBan.this,"Mời bạn chọn giờ đến !", Toast.LENGTH_SHORT).show();
        }
    }

    public void showDialog(){
        String loaiBan = txtLoaiBan.getText().toString();
        if (loaiBan.equals(BIDA_BANG)){
            dialog = new Dialog(DatBan.this, android.R.style.Theme_Material_NoActionBar_Fullscreen);
            dialog.setTitle("Đặt bàn bida lỗ");
            dialog.setContentView(R.layout.activity_bida_bang);
            dialog.show();
        }else{
            dialog = new Dialog(DatBan.this, android.R.style.Theme_Material_NoActionBar_Fullscreen);
            dialog.setTitle("Đặt bàn bida băng");
            dialog.setContentView(R.layout.activity_bida_lo);
            dialog.show();
        }
    }
}
