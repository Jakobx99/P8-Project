package sw801.remindersystem.ActivityView.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import sw801.remindersystem.ActivityView.Adapter.LocationSettingAdapter;
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

        LocationSettingAdapter myAdapter = new LocationSettingAdapter(this, locationSettings);


        listview.setAdapter(myAdapter);
        //------Creation of list of smart devices

        ImageView add = findViewById(R.id.imageView_mysmartdeviceadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocationSettingActivity.this, AddLocationSettingActivity.class);
                startActivity(intent);
            }
        });


    }
}
