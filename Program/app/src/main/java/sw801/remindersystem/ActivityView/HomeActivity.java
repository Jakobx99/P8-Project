package sw801.remindersystem.ActivityView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import sw801.remindersystem.R;
import sw801.remindersystem.ViewModel.HomeActivityViewModel;

public class HomeActivity extends AppCompatActivity {
    private HomeActivityViewModel viewModel = new HomeActivityViewModel();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_myevents:
                    // Intent intent = new Intent(HomeActivity.this, MyEventActivity.class);
                    // startActivity(intent);
                    break;
                case R.id.navigation_mysmartdevices:
                    Intent intent = new Intent(HomeActivity.this, MySmartDeviceActivity.class);
                    startActivity(intent);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        final Button buttonCreate = findViewById(R.id.button_Create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(HomeActivity.this, MyCreateActivity.class);
                // startActivity(intent);
            }
        });

        final Button buttonMyEvents = findViewById(R.id.button_MyEvents);
        buttonMyEvents.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(HomeActivity.this, MyEventActivity.class);
               // startActivity(intent);
            }
        }));

        final Button buttonMySmartDevices = findViewById(R.id.button_MySmartDevices);
        buttonMySmartDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MySmartDeviceActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                // startActivity(intent);
            }
        });
    }

}
