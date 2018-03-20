package sw801.remindersystem.ActivityView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import sw801.remindersystem.R;

public class AddEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        markButton();


        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinnerWhen);

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

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Before this time");
        categories.add("At this time");
        categories.add("After this time");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
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
            markedButtons +="S";
        }
        //Toast.makeText(this, markedButtons, Toast.LENGTH_SHORT).show();



    }


}
