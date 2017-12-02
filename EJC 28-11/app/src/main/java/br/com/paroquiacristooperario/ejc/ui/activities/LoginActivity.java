package br.com.paroquiacristooperario.ejc.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import br.com.paroquiacristooperario.ejc.R;
import br.com.paroquiacristooperario.ejc.app.EJCApplication;
import br.com.paroquiacristooperario.ejc.model.Member;
import br.com.paroquiacristooperario.ejc.services.RestService;
import br.com.paroquiacristooperario.ejc.services.ServiceMember;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.email)
    TextView txtEmail;

    @BindView(R.id.senha)
    TextView txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnLogin)
    public void login() {

        RestService r = EJCApplication.getInstance().getRestService();
        ServiceMember su = r.getService(ServiceMember.class);

        Member m = new Member();

        m.setEmail(txtEmail.getText().toString());
        m.setSenha(txtSenha.getText().toString());

        Call<Member> call = su.autenticar(m);

        call.enqueue(new Callback<Member>() {
            @Override
            public void onResponse(Call<Member> call, Response<Member> response) {
                if (response.code() == 200) {
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);

                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Usuário ou Senha inválidos.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Member> call, Throwable t) {

            }
        });
    }
}
