package sw801.remindersystem.ActivityView.Fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import sw801.remindersystem.ActivityView.Activity.AddEventActivity;
import sw801.remindersystem.ActivityView.Adapter.MyEventAdapter;
import sw801.remindersystem.R;

public class MyEventsFragment extends Fragment{
    //Implement viewmodel here

    //Setup of burger menu
    private ListView listview;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    ArrayList<String> myEvents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_my_events, container, false);


        listview = (ListView) rootView.findViewById(R.id.listViewMyEvents);

        //------Creation of list of smart devices
        myEvents = new ArrayList<String>();
        myEvents.add("Hue");
        myEvents.add("Nest");

        MyEventAdapter myAdapter = new MyEventAdapter(rootView.getContext(), myEvents);
        listview.setAdapter(myAdapter);
        //------Creation of list of smart devices



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                String selectedDevice=myEvents.get(position);
                Toast.makeText(rootView.getContext(), "Smart device Selected : "+selectedDevice,   Toast.LENGTH_LONG).show();
            }
        });


        ImageView add = rootView.findViewById(R.id.imageView_myeventadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), AddEventActivity.class);
                startActivity(intent);
            }
        });






        return rootView;


    }




}
