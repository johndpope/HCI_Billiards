package trung.hci_billiards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends FragmentActivity {

    MaterialButton btnLogin;
    EditText edtPhone, edtCode;
    FirebaseAuth mAuth;
    String codeSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        edtPhone = findViewById(R.id.edtTextPhone);
        edtCode = findViewById(R.id.edtCode);

        findViewById(R.id.btnGetCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendVerifycationCode();
            }
        });

        findViewById(R.id.btnSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySignInCode();
            }
        });

    }


    private void verifySignInCode() {

        String code = edtCode.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSend, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);

                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(getApplicationContext(),"Incorrect verification Code" , Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private void sendVerifycationCode() {

        String phone = edtPhone.getText().toString();
//        if (phone.isEmpty()) {
//            edtPhone.setError("required");
//            edtPhone.requestFocus();
//            return;
//        }
//
//        if (phone.length() < 10) {
//            edtPhone.setError("required");
//            edtPhone.requestFocus();
//            return;
//
//        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                callbacks

        );
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            codeSend = s;
        }
    };

    public void clickToHome(View view) {
        btnLogin = findViewById(R.id.btnLogin);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

    }


}
