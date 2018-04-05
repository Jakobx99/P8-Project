package sw801.remindersystem.ActivityView.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import sw801.remindersystem.R;

public class AddEventSmartDeviceList extends AppCompatActivity {
    private final ArrayList<String> arrayList = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_smart_device_list);
        listView = findViewById(R.id.listViewSmartDevice);
        populateList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AddEventSmartDeviceList.this, AddEventAccessory.class);
                intent.putExtra("Name", arrayList.get(position));
                startActivityForResult(intent, 1);
            }
        });
    }
    private void populateList(){
        //TODO Change to call to viewmodel
        arrayList.add("Hue - Smart Lights");
        arrayList.add("Nest - Termostat");
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.activity_add_event_list_layout, arrayList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null && requestCode == 1){
            Bundle result = data.getBundleExtra("key");
            Intent returnIntent = new Intent();
            returnIntent.putExtra("key", result);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }else{}
    }
}
