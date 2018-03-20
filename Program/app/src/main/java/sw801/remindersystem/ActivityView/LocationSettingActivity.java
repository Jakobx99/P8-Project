package sw801.remindersystem.ActivityView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import sw801.remindersystem.R;

public class LocationSettingActivity extends AppCompatActivity {

    private ListView listview;
    ArrayList<String> locationSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_setting);


        listview = (ListView) this.findViewById(R.id.listView_mylocationsettings);

        //------Creation of list of smart devices
        locationSettings = new ArrayList<String>();
        locationSettings.add("Home sweet home");

        MySmartDeviceAdapter myAdapter = new MySmartDeviceAdapter(this, locationSettings);


        listview.setAdapter(myAdapter);
        //------Creation of list of smart devices



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                //Click for entire box
                String selectedDevice=locationSettings.get(position);
                Toast.makeText(getApplicationContext(), "Predefined location selected : "+selectedDevice,   Toast.LENGTH_LONG).show();
            }
        });
    }}
