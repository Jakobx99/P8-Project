package sw801.remindersystem.Model;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.view.View;

import java.util.ArrayList;

import sw801.remindersystem.Model.Persistence.DAO.GlobalMuteDao;
import sw801.remindersystem.Model.Persistence.DAO.PredefinedLocationDao;
import sw801.remindersystem.Model.Persistence.DAO.SmartDeviceDao;
import sw801.remindersystem.Model.Persistence.Database.AppDatabase;
import sw801.remindersystem.Model.Persistence.Entity.GlobalMute;
import sw801.remindersystem.Model.Persistence.Entity.PredefinedLocation;
import sw801.remindersystem.Model.Persistence.Entity.SmartDevice;

public abstract class UserPreference {
    public LiveData<ArrayList<GlobalMute>> getGlobalMuteList(View rootView) {
        return AppDatabase.getInstance(rootView.getContext()).globalMuteDao().getAll();
    }

    @SuppressLint("StaticFieldLeak")
    public void addToGlobalMuteList(View rootView, GlobalMute globalMute) {
        final GlobalMuteDao globalMuteDao = AppDatabase.getInstance(rootView.getContext()).globalMuteDao();

        new AsyncTask<GlobalMute, Void, Void>() {
            @Override
            protected Void doInBackground(GlobalMute... globalMutes) {
                globalMuteDao.insertAll(globalMutes);

                return null;
            }

        }.execute(globalMute);
    }

    @SuppressLint("StaticFieldLeak")
    public void removeFromGlobalMuteList(View rootView, GlobalMute globalMute) {
        final GlobalMuteDao globalMuteDao = AppDatabase.getInstance(rootView.getContext()).globalMuteDao();

        new AsyncTask<GlobalMute, Void, Void>() {
            @Override
            protected Void doInBackground(GlobalMute... globalMutes) {
                for (GlobalMute globalMute : globalMutes) {
                    globalMuteDao.delete(globalMute);
                }

                return null;
            }

        }.execute(globalMute);
    }

    public LiveData<ArrayList<PredefinedLocation>> getPredefinedLocationList(View rootView) {
        return AppDatabase.getInstance(rootView.getContext()).predefinedLocationDao().getAll();
    }

    @SuppressLint("StaticFieldLeak")
    public void addToPredefinedLocationList(View rootView, PredefinedLocation predefinedLocation) {
        final PredefinedLocationDao predefinedLocationDao = AppDatabase.getInstance(rootView.getContext()).predefinedLocationDao();

        new AsyncTask<PredefinedLocation, Void, Void>() {
            @Override
            protected Void doInBackground(PredefinedLocation... predefinedLocations) {
                predefinedLocationDao.insertAll(predefinedLocations);

                return null;
            }

        }.execute(predefinedLocation);
    }

    @SuppressLint("StaticFieldLeak")
    public void removeFromPredefinedLocationList(View rootView, PredefinedLocation predefinedLocation) {
        final PredefinedLocationDao predefinedLocationDao = AppDatabase.getInstance(rootView.getContext()).predefinedLocationDao();

        new AsyncTask<PredefinedLocation, Void, Void>() {
            @Override
            protected Void doInBackground(PredefinedLocation... predefinedLocations) {
                for (PredefinedLocation predefinedLocation : predefinedLocations) {
                    predefinedLocationDao.delete(predefinedLocation);
                }

                return null;
            }

        }.execute(predefinedLocation);
    }

    public LiveData<ArrayList<SmartDevice>> getSmartDeviceList(View rootView) {
        return AppDatabase.getInstance(rootView.getContext()).smartDeviceDao().getAll();
    }

    @SuppressLint("StaticFieldLeak")
    public void addToGlobalMuteList(View rootView, SmartDevice smartDevice) {
        final SmartDeviceDao smartDeviceDao = AppDatabase.getInstance(rootView.getContext()).smartDeviceDao();

        new AsyncTask<SmartDevice, Void, Void>() {
            @Override
            protected Void doInBackground(SmartDevice... smartDevices) {
                smartDeviceDao.insertAll(smartDevices);

                return null;
            }

        }.execute(smartDevice);
    }

    @SuppressLint("StaticFieldLeak")
    public void removeFromGlobalMuteList(View rootView, SmartDevice smartDevice) {
        final SmartDeviceDao smartDeviceDao = AppDatabase.getInstance(rootView.getContext()).smartDeviceDao();

        new AsyncTask<SmartDevice, Void, Void>() {
            @Override
            protected Void doInBackground(SmartDevice... smartDevices) {
                for (SmartDevice smartDevice : smartDevices) {
                    smartDeviceDao.delete(smartDevice);
                }

                return null;
            }

        }.execute(smartDevice);
    }



    /*
    private ArrayList<PreferredShopping> PrefShopList;


    public ArrayList<PreferredShopping> getPrefShopList() {
        return PrefShopList;
    }

    public void setPrefShopList(PreferredShopping prefShop) {
        PrefShopList.add(prefShop);
    }
    */
}