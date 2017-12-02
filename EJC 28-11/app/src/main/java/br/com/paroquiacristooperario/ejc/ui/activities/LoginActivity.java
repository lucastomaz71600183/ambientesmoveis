package br.com.paroquiacristooperario.ejc.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import br.com.paroquiacristooperario.ejc.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnLogin)
    public void login() {
        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(i);

        finish();
    }
}
