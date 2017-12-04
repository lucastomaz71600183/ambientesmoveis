package br.com.paroquiacristooperario.ejc.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

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

    private Member m;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.btnCadastrar)
    Button btnCadastrar;

    @BindView(R.id.email)
    TextView txtEmail;

    @BindView(R.id.senha)
    TextView txtSenha;

//    @BindView(R.id.login_button)
//    LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        txtEmail.setText("lucastomazrm@gmail.com");
        txtSenha.setText("oixd");

//        txtEmail.setText("tatisantcar@outlook.com");
//        txtSenha.setText("tatiane");

        //loginButton.setReadPermissions("email");
    }


//    @OnClick(R.id.login_button)
//    public void facebook_login() {
//
//        CallbackManager callbackManager = CallbackManager.Factory.create();
//
//        LoginManager.getInstance().registerCallback(callbackManager,
//                new FacebookCallback<LoginResult>() {
//                    @Override
//                    public void onSuccess(LoginResult loginResult) {
//                        Toast.makeText(LoginActivity.this, "Sucesso." + loginResult, Toast.LENGTH_SHORT).show();
//                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//                        startActivity(i);
//
//                        finish();
//                    }
//
//                    @Override
//                    public void onCancel() {
//                        Toast.makeText(LoginActivity.this, "Cancelado.", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(FacebookException exception) {
//                        Toast.makeText(LoginActivity.this, "Erro: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//        startActivity(i);
//
//        finish();
//    }

    @OnClick(R.id.btnLogin)
    public void login() {

        RestService r = EJCApplication.getInstance().getRestService();
        ServiceMember su = r.getService(ServiceMember.class);

        m = new Member();

        m.setEmail(txtEmail.getText().toString());
        m.setSenha(txtSenha.getText().toString());

        Call<Member> call = su.autenticar(m);

        call.enqueue(new Callback<Member>() {

            @Override
            public void onResponse(Call<Member> call, Response<Member> response) {
                if (response.code() == 200) {

                    EJCApplication.membroAtivo = response.body().getUsuario_logado();

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

    @OnClick(R.id.btnCadastrar)
    public void cadastrar() {
        Intent i = new Intent(LoginActivity.this, SignUpActivity.class);

        startActivity(i);
    }
}
