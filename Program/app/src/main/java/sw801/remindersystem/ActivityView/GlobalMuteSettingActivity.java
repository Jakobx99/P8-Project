package sw801.remindersystem.ActivityView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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
        globalMuteSettings.add("Off at night");

    GlobalMuteSettingAdapter myAdapter = new GlobalMuteSettingAdapter(this, globalMuteSettings);


        listview.setAdapter(myAdapter);
    //------Creation of list of smart devices



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
        // argument position gives the index of item which is clicked
        public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
        {
            //Click for entire box
            String selectedDevice=globalMuteSettings.get(position);
            Toast.makeText(getApplicationContext(), "Global mute setting selected : "+selectedDevice,   Toast.LENGTH_LONG).show();
        }
    });
}}
