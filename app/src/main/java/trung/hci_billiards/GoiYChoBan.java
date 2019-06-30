package trung.hci_billiards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GoiYChoBan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goi_ycho_ban);
    }

    public void clickToDatBanImg(View view) {
        ImageView imageView = findViewById(R.id.imgGoiYChoBan);
        Intent intent = new Intent(this,DatBan.class);
        startActivity(intent);
    }
}
