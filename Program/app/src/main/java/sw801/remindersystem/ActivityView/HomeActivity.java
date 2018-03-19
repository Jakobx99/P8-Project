package sw801.remindersystem.ActivityView;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Context;
import sw801.remindersystem.Model.Events;
import sw801.remindersystem.R;
import sw801.remindersystem.ViewModel.HomeActivityViewModel;


//Implements Navigationviewlistener
public class HomeActivity extends Fragment{
    private HomeActivityViewModel viewModel = new HomeActivityViewModel();
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_home, container, false);
        rootView.invalidate();

        //setTitle("Notify Me - Home");

        final Button buttonCreate = rootView.findViewById(R.id.button_Create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((MainActivity)getActivity()).ChangeToEvents();

                //((MainActivity)getActivity()).mViewPager.setCurrentItem(1);
                //((MainActivity)getActivity()).mSectionsPagerAdapter.notifyDataSetChanged();
                //((MainActivity)getActivity()).getSupportFragmentManager().findFragmentByTag("Events");
                // Intent intent = new Intent(HomeActivity.this, MyCreateActivity.class);
                // startActivity(intent);
            }
        });

        //----------------Rest of the code

        final Button buttonMyEvents = rootView.findViewById(R.id.button_MyEvents);
        buttonMyEvents.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).ChangeToEvents();
                //((MainActivity)getActivity()).changetomyevents();
                //Intent intent = new Intent(HomeActivity.this, MyEventsActivity.class);
                //startActivity(intent);
            }
        }));

        final Button buttonMySmartDevices = rootView.findViewById(R.id.button_MySmartDevices);
        buttonMySmartDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).ChangeToSmartDevice();
                //Intent intent = new Intent(HomeActivity.this, MySmartDeviceActivity.class);
                //startActivity(intent);
            }
        });

        final Button buttonSettings = rootView.findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getActivity(), SettingsActivity.class);
                Intent intent = new Intent();
                intent.setClass(HomeActivity.this.getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
