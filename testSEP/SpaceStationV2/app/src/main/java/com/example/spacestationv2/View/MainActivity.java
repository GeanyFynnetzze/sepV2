package com.example.spacestationv2.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.spacestationv2.Autenthication.Login;
import com.example.spacestationv2.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();

        Toolbar toolbar = findViewById(R.id.toolbar);
        String text = intent.getStringExtra(MainMenuActivity.EXTRA_TEXT);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


       switch(text){
           case "Livingroom":
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new LivingRoomFragment()).commit();
               navigationView.setCheckedItem(R.id.nav_livingRoom);
               break;
           case "Toilet" :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new ToiletFragment()).commit();
               navigationView.setCheckedItem(R.id.nav_toilet);
               break;
           case "Kitchen" :
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new KitchenFragment()).commit();
               navigationView.setCheckedItem(R.id.nav_kitchen);
               break;

       }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_homepage:
                startActivity(new Intent(getApplicationContext(),MainMenuActivity.class));
                break;
            case R.id.nav_livingRoom:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LivingRoomFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_kitchen:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new KitchenFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_toilet:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ToiletFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(getApplicationContext(),MainMenuActivity.class));
        }

    }

}
