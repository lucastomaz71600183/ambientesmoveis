package br.com.paroquiacristooperario.ejc.ui.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.paroquiacristooperario.ejc.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openHome();
    }

    public void openHome() {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                finish();
            }
        },3500);
    }
}
