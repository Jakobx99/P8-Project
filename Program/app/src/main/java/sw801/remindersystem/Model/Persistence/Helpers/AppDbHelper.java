package sw801.remindersystem.Model.Persistence.Helpers;

import javax.inject.Singleton;

import sw801.remindersystem.data.Model.Persistence.Entity.PredefinedLocation;

@Singleton
public class AppDbHelper {
    public EventHelper eventHelper;
    public GlobalMuteHelper globalMuteHelper;
    public PredefinedLocation predefinedLocation;
    public SmartDeviceHelper smartDeviceHelper;
    public TriggerHelper triggerHelper;
    public WhenHelper whenHelper;
}
