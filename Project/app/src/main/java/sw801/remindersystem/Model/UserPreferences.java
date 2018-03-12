import java.util.*;
public class UserPreferences{
    private ArrayList<GlobalMute> GlobalMuteList;
    private ArrayList<PredefinedLocation> PredefList;
    private ArrayList<SmartDevice> SmartDeviceList;

    public ArrayList<GlobalMute> getGlobalMuteList() {
        return GlobalMuteList;
    }

    public ArrayList<PredefinedLocation> getPredefList() {
        return PredefList;
    }

    public ArrayList<SmartDevice> getSmartDeviceList() {
        return SmartDeviceList;
    }

    public void setGlobalMuteList(ArrayList<GlobalMute> globalMuteList) {
        GlobalMuteList = globalMuteList;
    }

    public void setPredefList(ArrayList<PredefinedLocation> predefList) {
        PredefList = predefList;
    }

    public void setSmartDeviceList(SmartDevice smartDevice) {
        SmartDeviceList.Add(smartDevice);
    }
}