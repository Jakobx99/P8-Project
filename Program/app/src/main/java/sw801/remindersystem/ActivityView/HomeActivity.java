package sw801.remindersystem.ActivityView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import sw801.remindersystem.R;
import sw801.remindersystem.ViewModel.HomeActivityViewModel;

//Implements Navigationviewlistener
public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private HomeActivityViewModel viewModel = new HomeActivityViewModel();

    //Setup of burger menu
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_myevents:
                    Intent intent2 = new Intent(HomeActivity.this, MyEventsActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_mysmartdevices:
                    Intent intent3 = new Intent(HomeActivity.this, MySmartDeviceActivity.class);
                    startActivity(intent3);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Notify Me - Home");
        setContentView(R.layout.activity_home);

        //--------------------------Navigation bar----------------------------------
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //--------------------------Navigation bar----------------------------------

        //--------------------------Burger menu-------------------------------------
        drawerLayout = findViewById(R.id.homeactivity);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv = findViewById(R.id.burgermenu);
        nv.setNavigationItemSelectedListener(this);
        //--------------------------Burger menu-------------------------------------

        final Button buttonCreate = findViewById(R.id.button_Create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(HomeActivity.this, MyCreateActivity.class);
                // startActivity(intent);
            }
        });

        //----------------Rest of the code

        final Button buttonMyEvents = findViewById(R.id.button_MyEvents);
        buttonMyEvents.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this, MyEventsActivity.class);
               startActivity(intent);
            }
        }));

        final Button buttonMySmartDevices = findViewById(R.id.button_MySmartDevices);
        buttonMySmartDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MySmartDeviceActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(intent);
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
                intent = new Intent(HomeActivity.this, MyEventsActivity.class);
                break;
            case R.id.menumysmartdevices:
                intent = new Intent(HomeActivity.this, MySmartDeviceActivity.class);
                break;
            case R.id.menuaddsmartdevies:
                Toast.makeText(this, "TESRE",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menusettings:
                intent = new Intent(HomeActivity.this, SettingsActivity.class);
                break;
            case R.id.menuaboutus:
                AlertDialog alertDialogabout = new AlertDialog.Builder(HomeActivity.this).create();
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
                AlertDialog alertDialogcontact = new AlertDialog.Builder(HomeActivity.this).create();
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
}
