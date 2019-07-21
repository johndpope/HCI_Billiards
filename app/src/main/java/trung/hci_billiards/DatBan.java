package trung.hci_billiards;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DatBan extends AppCompatActivity {

    TextView textView_date;
    TextView textView_Time;
    TextView textView_songuoi;
    ImageView giam,tang,imgDateBack, imgDateNext;
    int soNguoi = 2;
    int date, month, yean;
    int date_tang;

    private static final String TAG = "DatBan";
    private static final String BIDA_BANG = "Bida Băng";
    private static final String BIDA_LO = "Bida Lỗ";
    String chonban ;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_ban);
        imgDateBack = findViewById(R.id.imgDateBack);
        imgDateNext = findViewById(R.id.imgDateNext);
        textView_date = findViewById(R.id.txtSetDate);
        final Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DATE);
        date_tang = date;
        month = calendar.get(Calendar.MONTH)+1;
        yean = calendar.get(Calendar.YEAR);
        textView_date.setText(date + "/" + month + "/" + yean);
        imgDateNext.setClickable(true);
        imgDateNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((date_tang-date)>7){

                }else{
                    date_tang++;
                    textView_date.setText(date_tang + "/" + month + "/" + yean);
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
                }
            }
        });



        final TextView txtLoaiBan;
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
                }else{
                    txtLoaiBan.setText(BIDA_BANG);
                }
            }
        });
        imgLoaiBan2.setClickable(true);
        imgLoaiBan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtLoaiBan.getText().toString().equals(BIDA_BANG)){
                    txtLoaiBan.setText(BIDA_LO);
                }else{
                    txtLoaiBan.setText(BIDA_BANG);
                }
            }
        });
//        textView_date.setClickable(true);
//        textView_date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Calendar calendar = Calendar.getInstance();
//
//                DatePickerDialog datePickerDialog = new DatePickerDialog(DatBan.this);
//                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        int month_1 = month+1;
//                        String date1 = String.valueOf(dayOfMonth) + "/" + String.valueOf(month_1)
//                                + "/" + String.valueOf(year);
//                        textView_date.setText(date1);
//                    }
//                });
//                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()+86400000);
//                datePickerDialog.show();
//            }
//        });

        textView_Time = findViewById(R.id.txtSetTime);
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
                    Dialog dialog = new Dialog(DatBan.this);
                    dialog.setTitle("Đặt bàn bida băng");
                    dialog.setContentView(R.layout.activity_bida_lo);
                    dialog.show();
                }

            }
        });



        //        textView_Time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: TimePicker");
//                final Calendar calendar = Calendar.getInstance();
//
//                TimePickerDialog timePickerDialog = new TimePickerDialog(DatBan.this, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        textView_Time.setText(hourOfDay+":"+minute);
//                    }
//                },0,0,false);
//                timePickerDialog.show();
//
//            }
//        });
//
//        textView_songuoi = findViewById(R.id.txtSoNguoi);
//        textView_songuoi.setText(""+soNguoi);

//        giam = findViewById(R.id.imgDes);
//        giam.setClickable(true);
//        giam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(soNguoi<2){
//
//                }else{
//                    soNguoi--;
//                    textView_songuoi.setText(""+soNguoi);
//                }
//
//            }
//        });
//
//        tang = findViewById(R.id.imgAsc);
//        tang.setClickable(true);
//        tang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                soNguoi++;
//                textView_songuoi.setText(""+soNguoi);
//            }
//        });
        Button datbanngay = findViewById(R.id.btnDatBanNgay);
        datbanngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(DatBan.this, BookingFragment.class);
//                startActivity(intent);
            }
        });
    }

    public void Ban1sang(View view) {
        Button B = (Button)view;
        chonban = "Sáng - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();

    }

    public void Ban2sang(View view) {
        Button B = (Button)view;
        chonban = "Sáng - " + B.getText().toString();
        textView_Time.setText(chonban);
        dialog.dismiss();

    }
    public void clickToXemThemThongTin(View view) {
        TextView textView = findViewById(R.id.txtXemThemThongTin);
        Intent intent = new Intent(this,BilliardDetail.class);
        startActivity(intent);
    }

    public void BanDaDuocDat(View view) {
        Toast.makeText(DatBan.this,"Bàn này đã có người đặt\nMời bạn chọn bàn khác", Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(DatBan.this)
                .setMessage("Bàn này đã có người đặt.\nMời bạn chọn bàn khác")
                .setPositiveButton("OK",null);
    }
}
