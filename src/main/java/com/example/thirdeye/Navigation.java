package com.example.thirdeye;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Navigation extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);



        drawerLayout=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId() ) {

                    case R.id.profile:
                        Intent intent=new Intent(Navigation.this,Profile.class);
                        startActivity(intent);
                        Toast.makeText(Navigation.this,"Profile Selected",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(Navigation.this,"Logout",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.homeOne:
                        Toast.makeText(Navigation.this,"Home Selected",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.about:
                        Toast.makeText(Navigation.this,"About Selected",Toast.LENGTH_SHORT).show();
                        break;

                }


                return true;
            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem Item) {
        int id=Item.getItemId();
        if (id == R.id.profile){

               


            return false;
        }


        return super.onOptionsItemSelected(Item);
    }


}
