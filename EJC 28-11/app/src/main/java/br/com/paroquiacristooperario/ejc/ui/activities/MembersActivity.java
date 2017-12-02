package br.com.paroquiacristooperario.ejc.ui.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collections;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MembersActivity extends AppCompatActivity {

    private List<Member> memberlist;

    @BindView(R.id.listview)
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getMembers();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void getMembers() {


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
    }
}
