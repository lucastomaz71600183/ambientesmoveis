package br.com.paroquiacristooperario.ejc.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.paroquiacristooperario.ejc.R;
import br.com.paroquiacristooperario.ejc.app.EJCApplication;
import br.com.paroquiacristooperario.ejc.model.Member;
import br.com.paroquiacristooperario.ejc.model.MemberList;
import br.com.paroquiacristooperario.ejc.services.RestService;
import br.com.paroquiacristooperario.ejc.services.ServiceMember;
import br.com.paroquiacristooperario.ejc.ui.adapter.AdapterMembers;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MembersActivity extends AppCompatActivity {

    private List<Member> memberlist;
    private List<Member> productList;

    private boolean show = false;

    @BindView(R.id.listview)
    ListView list;

    @BindView(R.id.llSearch)
    LinearLayout linearLayout;

    @BindView(R.id.txtSearch)
    EditText txtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);

        ButterKnife.bind(this);
        getMembers("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //INSERE O BUTTON NA ACTIONBAR
        getMenuInflater().inflate(R.menu.filter, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //DISPARA O EVENTO "EXIBIR LINEAR LAYOUT DE FILTRO

        int id = item.getItemId();

        if (id == R.id.btnFilter) {
            if (!show) {
                linearLayout.setVisibility(View.VISIBLE);
                show = true;
            } else {
                linearLayout.setVisibility(View.GONE);
                show = false;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @OnTextChanged(R.id.txtSearch)
    public void filtrar() {
        getMembers(txtSearch.getText().toString());
    }

    public void getMembers(final String product) {

        if (product.isEmpty()) {
            RestService r = EJCApplication.getInstance().getRestService();

            ServiceMember s = r.getService(ServiceMember.class);
            Call<MemberList> c = s.getMembers();

            c.enqueue(new Callback<MemberList>() {
                @Override
                public void onResponse(Call<MemberList> call, Response<MemberList> response) {
                    if (response.code() == 200) {

                        memberlist = response.body().getList();

                        AdapterMembers adapter = new AdapterMembers(memberlist, MembersActivity.this);
                        list.setAdapter(adapter);

                    } else {
                        Toast.makeText(MembersActivity.this, "Erro", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<MemberList> call, Throwable t) {

                }


            });
        } else {

            productList = new ArrayList<Member>();
            productList.clear();

            for(int i = 0; i < memberlist.size(); i++) {
                if(memberlist.get(i).getNome().toUpperCase().contains(product.toUpperCase())) {
                    productList.add(memberlist.get(i));
                }
            }

            AdapterMembers adapter = new AdapterMembers(productList, MembersActivity.this);
            list.setAdapter(adapter);
        }
    }
}
