package sw801.remindersystem.ActivityView.Activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import sw801.remindersystem.ActivityView.Adapter.GlobalMuteSettingAdapter;
import sw801.remindersystem.R;

public class GlobalMuteSettingActivity extends AppCompatActivity {

    private ListView listview;
    ArrayList<String> globalMuteSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_mute);


        listview = (ListView) this.findViewById(R.id.listView_myglobalmutesettings);

        //------Creation of list of smart devices
        globalMuteSettings = new ArrayList<String>();
        globalMuteSettings.add("Off at home");

        GlobalMuteSettingAdapter myAdapter = new GlobalMuteSettingAdapter(this, globalMuteSettings);


        listview.setAdapter(myAdapter);
        //------Creation of list of smart devices

        ImageView add = findViewById(R.id.imageView_globalmuteadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GlobalMuteSettingActivity.this, AddGlobalMuteSettingActivity.class);
                startActivity(intent);
            }
        });

    }
}