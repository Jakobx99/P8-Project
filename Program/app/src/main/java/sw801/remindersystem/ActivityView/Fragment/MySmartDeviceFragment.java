package sw801.remindersystem.ActivityView.Fragment;


import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import sw801.remindersystem.ActivityView.Activity.AddSmartDeviceActivity;
import sw801.remindersystem.ActivityView.Adapter.SmartDeviceAdapter;
import sw801.remindersystem.Model.Persistence.Entity.SmartDevice;
import sw801.remindersystem.Model.UserPreference;
import sw801.remindersystem.R;


public class MySmartDeviceFragment extends Fragment {
    //Import viewmodel here

    ArrayList<String> smartDevices;
    //Setup of burger menu
    private ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_my_smart_device, container, false);


        //----------------Rest of the code
        listview = (ListView) rootView.findViewById(R.id.listView_mysmartdevices);

        //------Creation of list of smart devices
        UserPreference.getSmartDeviceList(rootView.getContext()).observe(this, new Observer<List<SmartDevice>>() {
            @Override
            public void onChanged(@Nullable List<SmartDevice> smartDevices) {
                SmartDeviceAdapter smartDeviceAdapter = new SmartDeviceAdapter(
                        rootView.getContext(),
                        smartDevices
                );

                listview.setAdapter(smartDeviceAdapter);

            }
        });
        //------Creation of list of smart devices

        //Add new smart device

        ImageView add = rootView.findViewById(R.id.imageView_myeventadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), AddSmartDeviceActivity.class);
                startActivity(intent);

                /*
                SmartDevice smartDevice = new SmartDevice();
                smartDevice.setDeviceName("HEEEY");
                smartDevice.setActive(false);

                UserPreference.addToSmartDeviceList(getContext(),smartDevice);
                */
            }
        });
        return rootView;
    }

    //TODO add onResume to redraw list after edit
}
