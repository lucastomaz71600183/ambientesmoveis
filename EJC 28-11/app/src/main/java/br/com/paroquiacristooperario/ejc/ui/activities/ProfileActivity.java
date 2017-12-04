package br.com.paroquiacristooperario.ejc.ui.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import br.com.paroquiacristooperario.ejc.R;
import br.com.paroquiacristooperario.ejc.app.EJCApplication;
import br.com.paroquiacristooperario.ejc.model.Member;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.nome)
    EditText nome;

    @BindView(R.id.sobrenome)
    EditText sobrenome;

    @BindView(R.id.telefone)
    EditText telefone;

    @BindView(R.id.celular)
    EditText celular;

    @BindView(R.id.data_nascimento)
    EditText data_nascimento;

    @BindView(R.id.prof_email)
    EditText email;

    @BindView(R.id.prof_foto)
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        carregarDados();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void carregarDados() {
        Member m = EJCApplication.membroAtivo;

        nome.setText(m.getNome());
        sobrenome.setText(m.getSobrenome());
        telefone.setText(m.getTelefone());
        celular.setText(m.getCelular());
        data_nascimento.setText(m.getData_nascimento());
        email.setText(m.getEmail());

        if(m.getFoto() != null) {
            Glide.with(this).load(m.getFoto()).into(foto);
        } else {
            Glide.with(this).load(R.drawable.ic_user_pink).into(foto);
        }
    }
}
