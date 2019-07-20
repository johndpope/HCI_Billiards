package trung.hci_billiards;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

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
                Log.d(TAG, "onClick: TimePicker");
                final Calendar calendar = Calendar.getInstance();

                TimePickerDialog timePickerDialog = new TimePickerDialog(DatBan.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        textView_Time.setText(hourOfDay+":"+minute);
                    }
                },0,0,false);
                timePickerDialog.show();

            }
        });

        textView_songuoi = findViewById(R.id.txtSoNguoi);
        textView_songuoi.setText(""+soNguoi);

        giam = findViewById(R.id.imgDes);
        giam.setClickable(true);
        giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(soNguoi<2){

                }else{
                    soNguoi--;
                    textView_songuoi.setText(""+soNguoi);
                }

            }
        });

        tang = findViewById(R.id.imgAsc);
        tang.setClickable(true);
        tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soNguoi++;
                textView_songuoi.setText(""+soNguoi);
            }
        });
    }


    public void clickToXemThemThongTin(View view) {
        TextView textView = findViewById(R.id.txtXemThemThongTin);
        Intent intent = new Intent(this,BilliardDetail.class);
        startActivity(intent);
    }

}
