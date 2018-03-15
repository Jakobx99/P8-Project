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

import sw801.remindersystem.R;

public class SettingsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Implement viewmodel here

    //Setup of burger menu
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Notify Me - Settings");
        setContentView(R.layout.activity_settings);

        //--------------------------Navigation bar----------------------------------
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //--------------------------Navigation bar----------------------------------

        //--------------------------Burger menu-------------------------------------
        drawerLayout = findViewById(R.id.settingsactivity);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv = findViewById(R.id.burgermenu);
        nv.setNavigationItemSelectedListener(this);
        //--------------------------Burger menu-------------------------------------

        //----------------Rest of the code

        EditText globalmute = findViewById(R.id.editText_globalmute);
        globalmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Global mute pressed",Toast.LENGTH_SHORT).show();
            }
        });

        EditText predefinedlocation = findViewById(R.id.editText_predefinedlocationsettings);
        predefinedlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Predefined locations pressed",Toast.LENGTH_SHORT).show();
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

    //--------------------------Burger menu-------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        switch (id){
            case R.id.menumyevent:
                intent = new Intent(SettingsActivity.this, MyEventsActivity.class);
                break;
            case R.id.menumysmartdevices:
                intent = new Intent(SettingsActivity.this, MySmartDeviceActivity.class);
                break;
            case R.id.menuaddsmartdevies:
                Toast.makeText(this, "TESRE",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menusettings:
                break;
            case R.id.menuaboutus:
                AlertDialog alertDialogabout = new AlertDialog.Builder(SettingsActivity.this).create();
                alertDialogabout.setTitle("About us");
                alertDialogabout.setMessage("This application have been created by group SW801f18 at Aalborg University");
                alertDialogabout.setIcon(R.drawable.ic_dashboard_black_24dp);

                alertDialogabout.setButton(Dialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alertDialogabout.show();
                break;
            case R.id.menucontactus:
                AlertDialog alertDialogcontact = new AlertDialog.Builder(SettingsActivity.this).create();
                alertDialogcontact.setTitle("Contact us");
                alertDialogcontact.setMessage("We can be contacted on email: sw801f18@cs.aau.dk");
                alertDialogcontact.setIcon(R.drawable.ic_dashboard_black_24dp);

                alertDialogcontact.setButton(Dialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alertDialogcontact.show();
                break;
        }
        if (intent == null){
            return false;
        }
        startActivity(intent);
        return false;
    }
    //--------------------------Burger menu-------------------------------------

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent1 = new Intent(SettingsActivity.this, HomeActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.navigation_myevents:
                    Intent intent2 = new Intent(SettingsActivity.this, MyEventsActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_mysmartdevices:
                    Intent intent3 = new Intent(SettingsActivity.this, MySmartDeviceActivity.class);
                    startActivity(intent3);
                    break;
            }
            return false;
        }
    };
}

