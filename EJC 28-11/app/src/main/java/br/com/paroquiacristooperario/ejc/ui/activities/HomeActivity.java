package br.com.paroquiacristooperario.ejc.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import br.com.paroquiacristooperario.ejc.R;
import br.com.paroquiacristooperario.ejc.app.EJCApplication;
import br.com.paroquiacristooperario.ejc.model.Member;
import br.com.paroquiacristooperario.ejc.model.MemberList;
import br.com.paroquiacristooperario.ejc.model.News;
import br.com.paroquiacristooperario.ejc.model.NewsList;
import br.com.paroquiacristooperario.ejc.services.RestService;
import br.com.paroquiacristooperario.ejc.services.ServiceMember;
import br.com.paroquiacristooperario.ejc.services.ServiceNews;
import br.com.paroquiacristooperario.ejc.ui.adapter.AdapterMembers;
import br.com.paroquiacristooperario.ejc.ui.adapter.AdapterNews;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private List<News> newsList;

    @BindView(R.id.listview)
    ListView list;

    NavigationView navigationView = null;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);

        TextView user_lastname = (TextView) header.findViewById(R.id.user_lastname);
        TextView user_firstname = (TextView) header.findViewById(R.id.user_name);
        ImageView user_picture = (ImageView) header.findViewById(R.id.user_picture);

        user_firstname.setText(EJCApplication.membroAtivo.getNome());
        user_lastname.setText(EJCApplication.membroAtivo.getSobrenome());


        if(EJCApplication.membroAtivo.getFoto() != null) {
            Glide.with(header).load(EJCApplication.membroAtivo.getFoto()).into(user_picture);
        } else {
            Glide.with(header).load(R.drawable.ic_user_pink).into(user_picture);
        }

        getNews();
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < navigationView.getMenu().size(); i++) {
            navigationView.getMenu().getItem(i).setChecked(false);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        if (id == R.id.profile) {
            Intent i = new Intent(HomeActivity.this, ProfileActivity.class);

            startActivity(i);

        } else if (id == R.id.members) {
            Intent i = new Intent(HomeActivity.this, MembersActivity.class);

            startActivity(i);
        } else if (id == R.id.help) {

        } else if (id == R.id.logout) {
            Intent i = new Intent(HomeActivity.this, LoginActivity.class);

            startActivity(i);

            finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        //navigationView.getMenu().getItem(0).setChecked(false);
        return true;

    }


    public void getNews() {

        RestService r = EJCApplication.getInstance().getRestService();

        ServiceNews s = r.getService(ServiceNews.class);

        Call<NewsList> c = s.getNews();

        c.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                if(response.code() == 200) {
                    newsList = response.body().getList();

                    AdapterNews adapter = new AdapterNews(newsList, HomeActivity.this);
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d("ERRO",call.toString());
            }
        });
    }
}
