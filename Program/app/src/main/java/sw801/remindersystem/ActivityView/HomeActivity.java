package sw801.remindersystem.ActivityView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import sw801.remindersystem.R;
import sw801.remindersystem.ViewModel.HomeActivityViewModel;

public class HomeActivity extends AppCompatActivity {
    private HomeActivityViewModel viewModel = new HomeActivityViewModel();

    private TextView mTextMessage;
    private EditText testthingy;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Home");
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
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

        mTextMessage = findViewById(R.id.TestText);
        testthingy = findViewById(R.id.TestNumber);

        final Button buttonCreate = findViewById(R.id.button_Create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //Bind values from user input
                String a = testthingy.getText().toString();
                Integer b = Integer.parseInt(a);

                //Call method in viewmodel and render result from viewmodel
                mTextMessage.setText(viewModel.onClickCreate(b).toString());
            }
        });



        final Button button = findViewById(R.id.button_MySmartDevices);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MySmartDeviceActivity.class);
                startActivity(intent);
            }
        });
        //viewModel.onCreate();  Kalder intet lige pt.

    }

}
