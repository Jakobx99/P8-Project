package sw801.remindersystem.ActivityView.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import sw801.remindersystem.MapsActivity;
import sw801.remindersystem.R;

/**
 * Created by clubd on 22-03-2018.
 */

public class EditLocationSettingActivity extends AppCompatActivity {

    private String locationSettingName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_location_setting);
        Intent i = getIntent();
        locationSettingName = i.getStringExtra(locationSettingName);

        final TextView textView = findViewById(R.id.textView_editlocationsettingname);
        textView.setText(locationSettingName);

        final EditText editTextName = findViewById(R.id.textInputLocationName);
        editTextName.setText(locationSettingName);

        editTextName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Remove focus and hide keyboard

                    textView.setText(editTextName.getText());
                    findViewById(R.id.editLocationSettingLayout).requestFocus();

                    //Hide keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    handled = true;
                }
                return handled;
            }
        });

        final Button buttonSettings = findViewById(R.id.button_MarkLocation);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditLocationSettingActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        Button confirmButton = findViewById(R.id.button_editLocationSettingConfirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();

                //TODO change in database

                finish();
            }
        });

    }
}