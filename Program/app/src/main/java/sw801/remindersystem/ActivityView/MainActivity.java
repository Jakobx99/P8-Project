package sw801.remindersystem.ActivityView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import sw801.remindersystem.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Setup of burger menu
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    public SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    //-----------------------Changed this to public, to make tabs change on button clicks
    public ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------------------------Burger menu-------------------------------------

        drawerLayout = findViewById(R.id.maindrawermenu);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv = findViewById(R.id.burgermenu);
        nv.setNavigationItemSelectedListener(this);

        //--------------------------Burger menu-------------------------------------

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    //--------------------------Burger menu-------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        switch (id){
            case R.id.menumyevent:
                //intent = new Intent(SettingsActivity.this, MyEventsFragment.class);
                break;
            case R.id.menumysmartdevices:
                //intent = new Intent(SettingsActivity.this, MySmartDeviceFragment.class);
                break;
            case R.id.menuaddsmartdevies:
                Toast.makeText(this, "TESRE",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menusettings:
                break;
            case R.id.menuaboutus:
                AlertDialog alertDialogabout = new AlertDialog.Builder(MainActivity.this).create();
                alertDialogabout.setTitle("About us");
                alertDialogabout.setMessage("This application have been created by group SW801f18 at Aalborg University");
                alertDialogabout.setIcon(R.drawable.ic_dashboard_black_24dp);

                alertDialogabout.setButton(Dialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alertDialogabout.show();
                break;
            case R.id.menucontactus:
                AlertDialog alertDialogcontact = new AlertDialog.Builder(MainActivity.this).create();
                alertDialogcontact.setTitle("Contact us");
                alertDialogcontact.setMessage("We can be contacted on email: sw801f18@cs.aau.dk");
                alertDialogcontact.setIcon(R.drawable.ic_dashboard_black_24dp);

                alertDialogcontact.setButton(Dialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alertDialogcontact.show();
                break;
        }
        if (intent == null){
            return false;
        }
        startActivity(intent);
        return false;
    }
    //--------------------------Burger menu-------------------------------------

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    //Intent intent = new Intent(MainActivity.this, HomeFragment.class);
                    //startActivity(intent);
                    HomeFragment home = new HomeFragment();
                    return home;
                case 1:
                    //Intent intent2 = new Intent(MainActivity.this, SettingsActivity.class);
                    //startActivity(intent2);
                    MyEventsFragment events = new MyEventsFragment();
                    return events;
                case 2:
                    MySmartDeviceFragment SmartDevice = new MySmartDeviceFragment();
                    return SmartDevice;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        //Not Used
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return "MyEvent";
                case 2:
                    return "MySmartDevice";
            }
            return null;
        }
    }

    void ChangeToEvents(){
        // Create fragment and give it an argument specifying the article it should show
        MyEventsFragment newFragment = new MyEventsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.homeactivity, newFragment, "Events" );
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();

        //Removes the fragment after changing the page
        transaction.remove(newFragment);
        mViewPager.setCurrentItem(1);

    }

    void ChangeToSmartDevice(){
        // Create fragment and give it an argument specifying the article it should show
        MySmartDeviceFragment newFragment = new MySmartDeviceFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.homeactivity, newFragment, "Smart" );
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();

        //Removes the fragment after changing the page
        transaction.remove(newFragment);
        mViewPager.setCurrentItem(2);

    }


    //----- NOT used ----------
    private void clearBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public static void performNoBackStackTransaction(final FragmentManager fragmentManager, Fragment fragment) {
        final int newBackStackLength = fragmentManager.getBackStackEntryCount() +1;

        fragmentManager.beginTransaction()
                .replace(R.id.homeactivity, fragment)
                .commit();

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                int nowCount = fragmentManager.getBackStackEntryCount();
                if (newBackStackLength != nowCount) {
                    // we don't really care if going back or forward. we already performed the logic here.
                    fragmentManager.removeOnBackStackChangedListener(this);

                    if ( newBackStackLength > nowCount ) { // user pressed back
                        fragmentManager.popBackStackImmediate();
                    }
                }
            }
        });
    }

    void changetomyevents(){

        android.support.v4.app.FragmentTransaction fm;
        MyEventsFragment hm1 = new MyEventsFragment();
        fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.homeactivity,hm1, "");
        fm.commit();

    }

}
