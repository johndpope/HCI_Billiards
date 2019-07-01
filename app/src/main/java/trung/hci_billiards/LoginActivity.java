package trung.hci_billiards;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void clickToHome(View view) {
        btnLogin = findViewById(R.id.btnLogin);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

    }


}
