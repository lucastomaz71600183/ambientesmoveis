package br.com.paroquiacristooperario.ejc.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class SignUpActivity extends AppCompatActivity {

    private Member m;
    private ServiceMember su;

    @BindView(R.id.cad_celular)
    EditText celular;

    @BindView(R.id.cad_data_nascimento)
    EditText data_nascimento;

    @BindView(R.id.cad_edicao)
    EditText edicao;

    @BindView(R.id.cad_email)
    EditText email;

    @BindView(R.id.cad_nome)
    EditText nome;

    @BindView(R.id.cad_senha)
    EditText senha;

    @BindView(R.id.cad_telefone)
    EditText telefone;

    @BindView(R.id.cad_sobrenome)
    EditText sobrenome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @OnClick(R.id.btn_cadastrar_final)
    public void cadastrar() {

        RestService r = EJCApplication.getInstance().getRestService();
        su = r.getService(ServiceMember.class);

        m = new Member();

        m.setSenha(senha.getText().toString());
        m.setEmail(email.getText().toString());
        m.setCelular(celular.getText().toString());
        m.setData_nascimento(data_nascimento.getText().toString());
        m.setEdicao(Integer.parseInt(edicao.getText().toString()));
        m.setNome(nome.getText().toString());
        m.setSobrenome(sobrenome.getText().toString());
        m.setTelefone(telefone.getText().toString());

        Call<Member> call = su.cadastrar(m);

        call.enqueue(new Callback<Member>() {
            @Override
            public void onResponse(Call<Member> call, Response<Member> response) {
                if (response.code() == 200) {
                    EJCApplication.membroAtivo = m;

                    Intent i = new Intent(SignUpActivity.this, HomeActivity.class);

                    startActivity(i);

                    finish();

                } else {
                    Toast.makeText(SignUpActivity.this, "Não foi possível cadastrar.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Member> call, Throwable t) {

            }
        });

    }
}
