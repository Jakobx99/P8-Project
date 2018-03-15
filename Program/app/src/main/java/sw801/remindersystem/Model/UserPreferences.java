package sw801.remindersystem.Model;
import java.util.*;
public class UserPreferences{
    private ArrayList<GlobalMute> GlobalMuteList;
    private ArrayList<PredefinedLocation> PredefList;
    private ArrayList<SmartDevice> SmartDeviceList;
    private ArrayList<PreferredShopping> PrefShopList;

    public ArrayList<GlobalMute> getGlobalMuteList() {
        return GlobalMuteList;
    }

    public ArrayList<PredefinedLocation> getPredefList() {
        return PredefList;
    }

    public ArrayList<SmartDevice> getSmartDeviceList() {
        return SmartDeviceList;
    }

    public void setGlobalMuteList(GlobalMute globalMuteList) {
        GlobalMuteList.add(globalMuteList);
    }

    public void setPredefList(ArrayList<PredefinedLocation> predefList) {
        PredefList = predefList;
    }

    public void setSmartDeviceList(SmartDevice smartDevice)
    {
        SmartDeviceList.add(smartDevice);
    }

    public ArrayList<PreferredShopping> getPrefShopList() {
        return PrefShopList;
    }

    public void setPrefShopList(PreferredShopping prefShop) {
        PrefShopList.add(prefShop);
    }
}