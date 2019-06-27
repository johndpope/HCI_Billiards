package trung.hci_billiards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ListBilliards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_billiards);
    }


    public void clickToDatBan(View view) {
        Button button = findViewById(R.id.btnDatBan);
        Intent intent = new Intent(this, DatBan.class);
        startActivity(intent);
    }


    public void clicktoviewdetailByNear(View view) {
        ImageView imageView = findViewById(R.id.imgDetail);
        Intent intent = new Intent(this, BilliardDetail.class);
        startActivity(intent);
    }
}
