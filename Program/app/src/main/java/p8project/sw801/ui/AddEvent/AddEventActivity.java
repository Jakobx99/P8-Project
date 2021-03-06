package p8project.sw801.ui.AddEvent;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import p8project.sw801.R;

public class AddEventActivity extends AppCompatActivity {
    private ListView listview;
    public ArrayList<String> addMyEvents;
    public AddEventAdapter myAdapter;
    private Bundle addressBundle;
    private Address address;
    private TextView addressTextView;
    private TextView textViewTime;
    private TextView textViewBetweenTime;
    private TextView addEvent;
    static private EditText AtTime = null;
    static private EditText betweenTime = null;
    private TextView addLocation;
    private Button confirm;
    private TextView eventName;
    private ArrayList<Integer> markedButtons;
    private LinearLayout doThis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        //---Calls the mark functions to mark a day in the day picker.
        markButton();

        //------Creation of list of "do this"
        addMyEvents = new ArrayList<String>();

        doThis = (LinearLayout) findViewById(R.id.linearLayoutAddEvent);

        //------Creation of list of smart devices - Spinner menu
        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerWhen);
        final Spinner spinnerLocation = (Spinner) findViewById(R.id.spinnerLocation);
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
        spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("No time condition chosen");
        categories.add("Before this time");
        categories.add("At this time");
        categories.add("After this time");
        categories.add("Between these times");

        List<String> categoriesLocation = new ArrayList<String>();
        categoriesLocation.add("No Location condition chosen");
        categoriesLocation.add("At location");
        categoriesLocation.add("Near Location");
        categoriesLocation.add("Leaving Location");
        categoriesLocation.add("Predefined Location");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        ArrayAdapter<String> dataAdapterLocation = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriesLocation);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinnerLocation.setAdapter(dataAdapterLocation);

        AtTime = findViewById(R.id.editTextTime);
        betweenTime = findViewById(R.id.editTextTimeBetween);
        addressTextView = findViewById(R.id.addLocation);
        textViewTime = findViewById(R.id.textViewTime);
        textViewBetweenTime  = findViewById(R.id.textViewBetweenTime);
        confirm = findViewById(R.id.buttonCreateEvent);
        eventName = findViewById(R.id.textInputEventName);
        addEvent = findViewById(R.id.addEventTriggerStatic);

        // Click events
        AtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(v, 1);
            }
        });
        betweenTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(v, 2);
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markButton();
                String eName = eventName.getText().toString();
                ArrayList<Integer> weekdays = markedButtons;
                Integer locationCondition = spinnerLocation.getSelectedItemPosition();
                Address confirmAddress = address;
                Integer timeCondition = spinner.getSelectedItemPosition() ;
                Long startTime = Long.parseLong(textViewTime.getText().toString());
                Long endTime = Long.parseLong(textViewBetweenTime.getText().toString());
                //TODO Connect with ViewModel
                //List<TIGGER_TYPE>
            }
        });
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotificationOrSmartdevice(v);
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position==4) {
                    textViewTime.setVisibility(View.VISIBLE);
                    AtTime.setEnabled(true);
                    AtTime.setVisibility(View.VISIBLE);
                    //AtClock.setEnabled(true);
                    //AtClock.setVisibility(View.VISIBLE);
                    textViewBetweenTime.setVisibility(View.VISIBLE);
                    betweenTime.setEnabled(true);
                    betweenTime.setVisibility(View.VISIBLE);
                    //betweenClock.setEnabled(true);
                    //betweenClock.setVisibility(View.VISIBLE);
                }
                else if(position==0) {
                    textViewTime.setVisibility(View.GONE);
                    AtTime.setEnabled(false);
                    AtTime.setVisibility(View.GONE);
                    //AtClock.setEnabled(false);
                     //AtClock.setVisibility(View.INVISIBLE);
                    textViewBetweenTime.setVisibility(View.GONE);
                    betweenTime.setEnabled(false);
                    betweenTime.setVisibility(View.GONE);
                    //betweenClock.setEnabled(false);
                    //betweenClock.setVisibility(View.INVISIBLE);
                }
                else
                {
                    textViewTime.setVisibility(View.VISIBLE);
                    AtTime.setEnabled(true);
                    AtTime.setVisibility(View.VISIBLE);
                    //AtClock.setEnabled(true);
                    //AtClock.setVisibility(View.VISIBLE);
                    textViewBetweenTime.setVisibility(View.GONE);
                    betweenTime.setEnabled(false);
                    betweenTime.setVisibility(View.GONE);
                    //betweenClock.setEnabled(false);
                    //betweenClock.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position==0) {
                    addressTextView.setVisibility(View.GONE);
                }
                else if(position ==4)
                {
                    //TODO OPEN NEW ACTIVITY/FRAGMENT/SPINNER AND CALL VIEWMODEL TO GET DATA
                }
                else{
                    addressTextView.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    public void showTimePickerDialog(View v, int i) {
        if (i == 1){
            DialogFragment newFragment = new TimePickerFragment1();
            newFragment.show(getSupportFragmentManager(), "timePicker");
        }
        else{
            DialogFragment newFragment = new TimePickerFragment2();
            newFragment.show(getSupportFragmentManager(), "timePicker");
        }

    }

    public static class TimePickerFragment1 extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String time = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
            AtTime.setText(time);
        }
    }

    public static class TimePickerFragment2 extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String time = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
            betweenTime.setText(time);
        }
    }

    public void showNotificationOrSmartdevice(View v){
        DialogFragment newFragment = new NotificationOrSmartdeviceFragment();
        newFragment.show(getSupportFragmentManager(), "notificationOrSmartdevice");
    }

    public void showMapActivity(View v){
        Intent mapIntent = new Intent(AddEventActivity.this, CreateEventMapActivity.class);
        startActivityForResult(mapIntent, 0);
    }

    public void closeAddEvent(View v){finish();}

    private void markButton(){
        markedButtons = new ArrayList<Integer>();

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

        //Check individual items.
        if(tMon.isChecked()){
            markedButtons.add(1);
        }
        if(tThu.isChecked()){
            markedButtons.add(2);
        }
        if(tWen.isChecked()){
            markedButtons.add(3);
        }
        if(tTue.isChecked()){
            markedButtons.add(4);
        }
        if(tFri.isChecked()){
            markedButtons.add(5);
        }
        if(tSat.isChecked()){
            markedButtons.add(6);
        }
        if(tSun.isChecked()){
            markedButtons.add(7);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (0) : {
                if (resultCode == Activity.RESULT_OK) {
                    addressBundle = data.getBundleExtra("address");
                    address = addressBundle.getParcelable("address");
                    addressTextView.setText(address.getAddressLine(0)+ ", " + address.getAddressLine(1) + ", " + address.getAddressLine(2));
                }
                break;
            }
        }
    }

    public void refreshData(){
        ArrayList<String> a = new ArrayList<>();
        a.clear();
        a.addAll(addMyEvents);

        doThis.removeAllViews();

        myAdapter = new AddEventAdapter(this, a);

        final int adapterCount = myAdapter.getCount();
        for (int i = 0; i < adapterCount; i++) {
            View item = myAdapter.getView(i, null, null);
            doThis.addView(item);
        }

    }
    public void deleteItem(int pos){
        addMyEvents.remove(pos);
        refreshData();
    }


}
