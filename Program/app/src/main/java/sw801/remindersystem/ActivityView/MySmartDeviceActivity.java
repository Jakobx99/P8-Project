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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sw801.remindersystem.R;

public class MySmartDeviceActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    //Implement viewmodel here

    //Setup of burger menu
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ListView listview;
    ArrayList<String> smartDevices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Notify Me - My Smart Devices");
        setContentView(R.layout.activity_my_smart_device);

        //--------------------------Navigation bar----------------------------------
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_mysmartdevices);
        //--------------------------Navigation bar----------------------------------

        //--------------------------Burger menu-------------------------------------
        drawerLayout = findViewById(R.id.mysmartdeviceactivity);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv = findViewById(R.id.burgermenu);
        nv.setNavigationItemSelectedListener(this);
        //--------------------------Burger menu-------------------------------------

        //----------------Rest of the code
        listview = (ListView) findViewById(R.id.listView_mysmartdevices);

        //------Creation of list of smart devices
        smartDevices = new ArrayList<String>();
        smartDevices.add("Hue");
        smartDevices.add("Nest");

        MySmartDeviceAdapter myAdapter = new MySmartDeviceAdapter(this, smartDevices);
        listview.setAdapter(myAdapter);
        //------Creation of list of smart devices



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                //Click for entire box
                String selectedDevice=smartDevices.get(position);
                Toast.makeText(getApplicationContext(), "Smart device Selected : "+selectedDevice,   Toast.LENGTH_LONG).show();
            }
        });


        //Add new smart device

        ImageView add = findViewById(R.id.imageView_mysmartdeviceadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start new fragment
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
                intent = new Intent(MySmartDeviceActivity.this, MyEventsActivity.class);
                break;
            case R.id.menumysmartdevices:
                break;
            case R.id.menuaddsmartdevies:
                Toast.makeText(this, "TESRE",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menusettings:
                intent = new Intent(MySmartDeviceActivity.this, SettingsActivity.class);
                break;
            case R.id.menuaboutus:
                AlertDialog alertDialogabout = new AlertDialog.Builder(MySmartDeviceActivity.this).create();
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
                AlertDialog alertDialogcontact = new AlertDialog.Builder(MySmartDeviceActivity.this).create();
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
                    Intent intent1 = new Intent(MySmartDeviceActivity.this, HomeActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.navigation_myevents:
                    Intent intent2 = new Intent(MySmartDeviceActivity.this, MyEventsActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_mysmartdevices:
                    return true;
            }
            return false;
        }
    };

}
