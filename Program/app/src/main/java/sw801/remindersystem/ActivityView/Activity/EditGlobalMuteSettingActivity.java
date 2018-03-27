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
import android.widget.Switch;
import android.widget.TextView;

import sw801.remindersystem.R;

/**
 * Created by clubd on 21-03-2018.
 */

public class EditGlobalMuteSettingActivity extends AppCompatActivity {

    private String globalSettingName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_global_mute);
        Intent i = getIntent();
        globalSettingName = i.getStringExtra(globalSettingName);

        final TextView textView = findViewById(R.id.textView_editglobalmutename);
        textView.setText(globalSettingName);

        final EditText editTextName = findViewById(R.id.textInputGlobalMuteName);
        editTextName.setText(globalSettingName);

        editTextName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Remove focus and hide keyboard

                    textView.setText(editTextName.getText());
                    findViewById(R.id.editGlobalMuteLayout).requestFocus();

                    //Hide keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    handled = true;
                }
                return handled;
            }
        });

        Button confirmButton = findViewById(R.id.button_editGlobalMuteConfirm);
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