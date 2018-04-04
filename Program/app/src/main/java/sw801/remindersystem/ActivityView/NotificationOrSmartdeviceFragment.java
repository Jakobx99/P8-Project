package sw801.remindersystem.ActivityView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import sw801.remindersystem.ActivityView.Activity.AddEventActivity;
import sw801.remindersystem.R;

public class NotificationOrSmartdeviceFragment extends DialogFragment {
    private Button addNotitication;
    private EditText notification;
    private AddEventActivity addEventActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification_or_smartdevice, container, false);

        addNotitication = v.findViewById(R.id.buttonAddNotification);
        notification = v.findViewById(R.id.editTextNotification);
        addEventActivity = (AddEventActivity) getActivity();

        addNotitication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = notification.getText().toString();
                addEventActivity.addMyEvents.add(message);
                addEventActivity.refreshData();
                getActivity().getSupportFragmentManager().beginTransaction().remove(NotificationOrSmartdeviceFragment.this).commit();

            }
        });

        return v;
    }
}
