package sw801.remindersystem.ActivityView.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import sw801.remindersystem.MapsActivity;
import sw801.remindersystem.R;

/**
 * Created by clubd on 22-03-2018.
 */

public class AddLocationSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location_setting);
        setTitle("Notify me - Add predefined location");

        final Button buttonSettings = findViewById(R.id.button_MarkLocation);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddLocationSettingActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });


    }
}
