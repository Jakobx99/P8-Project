package sw801.remindersystem.ActivityView;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import sw801.remindersystem.R;

public class EditSmartDeviceActivity extends AppCompatActivity {

    private String deviceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_smart_device);
        Intent i = getIntent();
        deviceName = i.getStringExtra(deviceName);

        final TextView textView = findViewById(R.id.textView_editdeviceName);
        textView.setText(deviceName);

        final EditText editTextName = findViewById(R.id.editText_editname);
        editTextName.setText(deviceName);

        final Switch enabledDisabled = findViewById(R.id.switch_deviceswitch);

        editTextName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Remove focus and hide keyboard

                    textView.setText(editTextName.getText());
                    findViewById(R.id.editSmartDeviceLayout).requestFocus();

                    //Hide keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    handled = true;
                }
                return handled;
            }
        });

        Button confirmButton = findViewById(R.id.button_editSmartdeviceConfirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                Boolean active = enabledDisabled.isChecked();

                //TODO change in database

                finish();
            }
        });

    }
}
