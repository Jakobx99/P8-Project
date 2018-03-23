package sw801.remindersystem.ActivityView.Activity;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import sw801.remindersystem.ActivityView.AddEventAdapter;
import sw801.remindersystem.ActivityView.Fragment.TimePickerFragment;
import sw801.remindersystem.ActivityView.NotificationOrSmartdeviceFragment;
import sw801.remindersystem.R;

public class AddEventActivity extends AppCompatActivity {
    private ListView listview;
    ArrayList<String> addMyEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        //---Calls the mark functions to mark a day in the day picker.
        markButton();

        //------Creation of list of "do this"
        addMyEvents = new ArrayList<String>();
        addMyEvents.add("Choose what the event should trigger");

        LinearLayout doThis = (LinearLayout) findViewById(R.id.linearLayoutAddEvent);
        ListAdapter myAdapter = new AddEventAdapter(this, addMyEvents);

        final int adapterCount = myAdapter.getCount();
        for (int i = 0; i < adapterCount; i++) {
            View item = myAdapter.getView(i, null, null);
            doThis.addView(item);
        }
        //TextView textView = (TextView) findViewById(R.id.addEventDoThis);
       // textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_add_black_18dp, 0, 0, 0);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinnerWhen);

        //------Creation of list of smart devices
        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        //final TextView AddLocation = findViewById(R.id.addLocation);
        final EditText AtTime = findViewById(R.id.editTextTime);
        final Button AtClock = findViewById(R.id.timePickButton);
        final EditText betweenTime = findViewById(R.id.editTextTimeBetween);
        final Button betweenClock = findViewById(R.id.timePickButton2);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Before this time");
        categories.add("At this time");
        categories.add("After this time");
        categories.add("Between these times");
        categories.add("At location only");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position==3) {
                    betweenTime.setEnabled(true);
                    betweenClock.setEnabled(true);
                }
                else if(position==4) {
                    AtTime.setEnabled(false);
                    AtClock.setEnabled(false);
                    betweenTime.setEnabled(false);
                    betweenClock.setEnabled(false);
                }
                else
                {
                    AtTime.setEnabled(true);
                    AtClock.setEnabled(true);
                    betweenTime.setEnabled(false);
                    betweenClock.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public void showNotificationOrSmartdevice(View v){
        DialogFragment newFragment = new NotificationOrSmartdeviceFragment();
        newFragment.show(getSupportFragmentManager(), "notificationOrSmartdevice");
    }

    public void closeAddEvent(View v){
        finish();
    }

    private void markButton(){
        //Day buttons
        ToggleButton tMon;
        ToggleButton tThu;
        ToggleButton tWen;
        ToggleButton tTue;
        ToggleButton tFri;
        ToggleButton tSat;
        ToggleButton tSun;

        tMon = (ToggleButton) findViewById(R.id.tD);
        tThu = (ToggleButton) findViewById(R.id.tL);
        tWen = (ToggleButton) findViewById(R.id.tM);
        tTue = (ToggleButton) findViewById(R.id.tMi);
        tFri = (ToggleButton) findViewById(R.id.tJ);
        tSat = (ToggleButton) findViewById(R.id.tV);
        tSun = (ToggleButton) findViewById(R.id.tS);

        String markedButtons= "";
        //Check individual items.
        if(tMon.isChecked()){
            markedButtons +="M,";
        }
        if(tThu.isChecked()){
            markedButtons +="T,";
        }
        if(tWen.isChecked()){
            markedButtons +="W,";
        }
        if(tTue.isChecked()){
            markedButtons +="T,";
        }
        if(tFri.isChecked()){
            markedButtons +="F,";
        }
        if(tSat.isChecked()){
            markedButtons +="S,";
        }
        if(tSun.isChecked()){
            markedButtons +="S,";
        }
        //Toast.makeText(this, markedButtons, Toast.LENGTH_SHORT).show();



    }

}
