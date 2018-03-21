package sw801.remindersystem.ActivityView;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

        //Add new smart device

        ImageView add = rootView.findViewById(R.id.imageView_mysmartdeviceadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), AddEventActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    //TODO add onResume to redraw list after edit
}
