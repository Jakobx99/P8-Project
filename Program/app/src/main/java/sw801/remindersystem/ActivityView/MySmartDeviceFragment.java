package sw801.remindersystem.ActivityView;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.app.Fragment;


import java.util.ArrayList;

import sw801.remindersystem.R;


public class MySmartDeviceFragment extends Fragment{
    //Import viewmodel here

    //Setup of burger menu
    private ListView listview;
    ArrayList<String> smartDevices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_my_smart_device, container, false);


        //----------------Rest of the code
        listview = (ListView) rootView.findViewById(R.id.listView_mysmartdevices);

        //------Creation of list of smart devices
        smartDevices = new ArrayList<String>();
        smartDevices.add("Hue");
        smartDevices.add("Nest");

        MySmartDeviceAdapter myAdapter = new MySmartDeviceAdapter(rootView.getContext(), smartDevices);


        listview.setAdapter(myAdapter);
        //------Creation of list of smart devices



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                //Click for entire box
                String selectedDevice=smartDevices.get(position);
                Toast.makeText(rootView.getContext(), "Smart device Selected : "+selectedDevice,   Toast.LENGTH_LONG).show();
            }
        });


        //Add new smart device

        ImageView add = rootView.findViewById(R.id.imageView_mysmartdeviceadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start new fragment
            }
        });


        return rootView;
    }

}