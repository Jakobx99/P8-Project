package sw801.remindersystem.ActivityView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import sw801.remindersystem.R;

public class MySmartDeviceActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(MySmartDeviceActivity.this, HomeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_myevents:
                    // Intent intent = new Intent(HomeActivity.this, MyEventActivity.class);
                    // startActivity(intent);
                    break;
                case R.id.navigation_mysmartdevices:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_smart_device);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Set active
        navigation.setSelectedItemId(R.id.navigation_mysmartdevices);

    }

}
