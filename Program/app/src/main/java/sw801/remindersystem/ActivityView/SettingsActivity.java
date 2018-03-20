package sw801.remindersystem.ActivityView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sw801.remindersystem.Model.GlobalMute;
import sw801.remindersystem.R;

public class SettingsActivity extends AppCompatActivity  {
    //Implement viewmodel here

    //Setup of burger menu
    //private DrawerLayout drawerLayout;
    //private ActionBarDrawerToggle actionBarDrawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTitle("Notify Me - Settings");
        setContentView(R.layout.activity_settings);


        //--------------------------Navigation bar----------------------------------
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //--------------------------Navigation bar----------------------------------

        //--------------------------Burger menu-------------------------------------
        //drawerLayout = findViewById(R.id.settingsactivity);
        //actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        //drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //actionBarDrawerToggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //NavigationView nv = findViewById(R.id.burgermenu);
        //nv.setNavigationItemSelectedListener(this);
        //--------------------------Burger menu-------------------------------------

        //----------------Rest of the code

        EditText globalmute = findViewById(R.id.editText_globalmute);
        globalmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, GlobalMuteSettingActivity.class);
                startActivity(intent);
            }
        });

        EditText predefinedlocation = findViewById(R.id.editText_predefinedlocationsettings);
        predefinedlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, LocationSettingActivity.class);
                startActivity(intent);
            }
        });

        EditText preferredshopping = findViewById(R.id.editText_preferredshoppingsettings);
        preferredshopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Preferred shopping pressed",Toast.LENGTH_SHORT).show();
            }
        });

    }

}

