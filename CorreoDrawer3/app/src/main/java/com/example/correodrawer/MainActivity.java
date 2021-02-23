package com.example.correodrawer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.ListView;

import com.example.correodrawer.ui.borrador.onremoveBorrador;
import com.example.correodrawer.ui.gallery.CorreosSalidaAdapter;
import com.example.correodrawer.ui.gallery.onborrarCorreo;
import com.example.correodrawer.ui.home.onborrarCorreoEntrada;
import com.example.correodrawer.ui.slideshow.onborrarCorreoBorrador;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements onborrarCorreo, onborrarCorreoEntrada, onborrarCorreoBorrador, onremoveBorrador {

    private AppBarConfiguration mAppBarConfiguration;
    private List<CorreosSalidaAdapter> averiaList;
    private ListView lista;
    private int pos;
    private FloatingActionButton fab;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("miCaller","info");
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        fab.show();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.hide();
                monew n = new monew(view);
                n.show(getSupportFragmentManager(),"");
                n.dismiss();
            }
        });
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    protected void onResume() {
        Log.i("miCaller","info");
        super.onResume();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("miCaller","info");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.i("miCaller","info");
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        fab.show();
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void borra() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.nav_gallery);
    }

    @Override
    public void borraEntrada() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.nav_home);
    }

    @Override
    public void borraBorrador() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.nav_slideshow);
    }

    @Override
    public void actionPerformed() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.nav_gallery);
    }
}
