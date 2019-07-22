package trung.hci_billiards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BilliardDetail extends AppCompatActivity {
    String name= "" , diachi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.billiard_detail);

        Intent intent = getIntent();

        name  = intent.getStringExtra(MainActivity.BILLIARD_NAME);
        diachi = intent.getStringExtra(MainActivity.BILLIARD_ADDRESS);

            TextView textView = findViewById(R.id.txtNameDetail);
            TextView textView1 = findViewById(R.id.txtDiaChiDetail);
            textView.setText(name);
            textView1.setText(diachi);


    }
}
