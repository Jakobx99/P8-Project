package sw801.remindersystem.ActivityView.Activity;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import sw801.remindersystem.data.Model.Persistence.Entity.SmartDevice;
import sw801.remindersystem.data.Model.UserPreference;
import sw801.remindersystem.R;

public class EditSmartDeviceActivity extends AppCompatActivity {
    private Integer deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_smart_device);
        Intent i = getIntent();

        deviceId = i.getIntExtra("device_id", 0);

        UserPreference.getSmartDeviceById(getApplicationContext(), deviceId).observe(this, new Observer<SmartDevice>() {
            @Override
            public void onChanged(@Nullable final SmartDevice smartDevice) {
                if (smartDevice == null) {
                    finish();

                }


                final TextView textView = findViewById(R.id.textView_editdeviceName);
                textView.setText(smartDevice.getDeviceName());

                final EditText editTextName = findViewById(R.id.editText_editname);
                editTextName.setText(smartDevice.getDeviceName());

                final Switch enabledDisabled = findViewById(R.id.switch_deviceswitch);
                enabledDisabled.setChecked(smartDevice.getActive());

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

                        smartDevice.setDeviceName(name);
                        smartDevice.setActive(active);

                        UserPreference.updateSmartDevice(getApplicationContext(), smartDevice);

                        finish();
                    }
                });

            }
        });
    }
}
