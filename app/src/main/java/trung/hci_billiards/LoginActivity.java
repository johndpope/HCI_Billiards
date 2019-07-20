package trung.hci_billiards;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.facebook.accountkit.AccessToken;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.PhoneNumber;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.facebook.accountkit.ui.SkinManager;
import com.facebook.accountkit.ui.UIManager;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends FragmentActivity {

    Button btnLogin;

    public static int APP_REQUEST_CODE = 999;
//    public static final String TAG = "MainActivity";
    private Button login, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoginPage(LoginType.PHONE);

            }
        });
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoginPage(LoginType.EMAIL);
            }
        });

//

    }

//    private void getCurrentAccount() {
//        AccessToken accessToken = AccountKit.getCurrentAccessToken();
//        if (accessToken != null) {
//            //Handle Returning User
//            AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
//
//                @Override
//                public void onSuccess(final Account account) {
//
//                    // Get Account Kit ID
//                    String accountKitId = account.getId();
//                    Log.e("Account Kit Id", accountKitId);
//
//                    if (account.getPhoneNumber() != null) {
//                        Log.e("CountryCode", "" + account.getPhoneNumber().getCountryCode());
//                        Log.e("PhoneNumber", "" + account.getPhoneNumber().getPhoneNumber());
//
//                        // Get phone number
//                        PhoneNumber phoneNumber = account.getPhoneNumber();
//                        String phoneNumberString = phoneNumber.toString();
//                        logout.setVisibility(View.VISIBLE);
//                        login.setVisibility(View.GONE);
//                        Log.e("NumberString", phoneNumberString);
//
//
//                    }
//
//                    if (account.getEmail() != null)
//                        Log.e("Email", account.getEmail());
//                }
//
//                @Override
//                public void onError(final AccountKitError error) {
//                    // Handle Error
//                    Log.e(TAG, error.toString());
//                }
//            });
//
//        } else {
//            //Handle new or logged out user
//            Log.e(TAG, "Logged Out");
//            Toast.makeText(this, "Logged Out User", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    public void phoneLogin(LoginType loginType) {
//        PhoneNumber phoneNumber = new PhoneNumber("+84", "VN");
//        final Intent intent = new Intent(this, AccountKitActivity.class);
//
//        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder = new AccountKitConfiguration.AccountKitConfigurationBuilder(
//                LoginType.PHONE, AccountKitActivity.ResponseType.TOKEN); // or .ResponseType.CODE
//        configurationBuilder.setDefaultCountryCode("VN");
//        configurationBuilder.setInitialPhoneNumber(phoneNumber);
//        configurationBuilder.setReadPhoneStateEnabled(true);
//        // configurationBuilder.setDefaultCountryCode("IN");
//        intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION, configurationBuilder.build());
//        startActivityForResult(intent, APP_REQUEST_CODE);
//    }
//
//
//    @Override
//    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == APP_REQUEST_CODE && resultCode == RESULT_OK) {
//            getCurrentAccount();
//        }
//    }

    private void startLoginPage(LoginType loginType) {

        if (loginType == LoginType.EMAIL) {
            final Intent intent = new Intent(this, AccountKitActivity.class);
            AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                    new AccountKitConfiguration.AccountKitConfigurationBuilder(
                            LoginType.EMAIL,
                            AccountKitActivity.ResponseType.CODE); // Use token when 'Enable client Access Token Flow' is YES
            intent.putExtra(
                    AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                    configurationBuilder.build());
            startActivityForResult(intent, APP_REQUEST_CODE);}
        else if(loginType == LoginType.PHONE){
            String[] smsWhitelist = new String[]{"VN"};
            PhoneNumber phoneNumber = new PhoneNumber("+84","VN");

            Intent intent = new Intent ( this, AccountKitActivity.class );
            AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder = new AccountKitConfiguration.AccountKitConfigurationBuilder ( LoginType.PHONE, AccountKitActivity.ResponseType.TOKEN );
            configurationBuilder.setDefaultCountryCode ("VN");
            configurationBuilder.setInitialPhoneNumber ( phoneNumber );
            configurationBuilder.setReadPhoneStateEnabled(true);
            configurationBuilder.setReceiveSMS(true);
            UIManager uiManager ;


            intent.putExtra ( AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION, configurationBuilder.build () );
            startActivityForResult ( intent, APP_REQUEST_CODE );
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult ( requestCode, resultCode, data );
        if (requestCode == APP_REQUEST_CODE) {
            AccountKitLoginResult result = data.getParcelableExtra ( AccountKitLoginResult.RESULT_KEY );
            if (result.getError () != null) {
                Toast.makeText ( this, "" + result.getError ().getErrorType ().getMessage (), Toast.LENGTH_SHORT ).show ();
                return;
            } else if (result.wasCancelled ()) {
                Toast.makeText ( this, "Cancel", Toast.LENGTH_SHORT ).show ();
                return;
            } else {
                if (result.getAccessToken () != null) {
                    Toast.makeText ( this, "Success! %s" + result.getAccessToken ().getAccountId (), Toast.LENGTH_SHORT );
                }
                else
                    Toast.makeText ( this, "Successful! %s" + result.getAuthorizationCode ().substring ( 0, 10 ), Toast.LENGTH_SHORT ).show ();

                startActivity ( new Intent ( this, MainActivity.class ) );

            }
        }
    }


//    public void logout(View view) {
//        AccountKit.logOut();
//        AccessToken accessToken = AccountKit.getCurrentAccessToken();
//        if (accessToken != null)
//            Log.e(TAG, "Still Logged in...");
//
//        else
//            logout.setVisibility(View.GONE);
//        login.setVisibility(View.VISIBLE);
//    }
//

    public void clickToHome(View view) {
        btnLogin = findViewById(R.id.btnLogin);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

    }
}
