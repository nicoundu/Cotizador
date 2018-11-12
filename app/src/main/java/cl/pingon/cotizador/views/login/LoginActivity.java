package cl.pingon.cotizador.views.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;

import cl.pingon.cotizador.data.CurrentUser;
import cl.pingon.cotizador.R;
import cl.pingon.cotizador.views.main.MainActivity;


public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 007;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        if (new CurrentUser().getCurrentUser() != null) {
            logged();
        } else {
            signUp();
        }

    }

    private void signUp() {

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.EmailBuilder().build()))

                        .setTheme(R.style.LoginTheme)
                        .setLogo(R.mipmap.logo)

                        .build(),
                RC_SIGN_IN);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (RC_SIGN_IN == requestCode) {

            if (RESULT_OK == resultCode) ;
            {
                logged();
            }
        }
    }

    private void logged() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
