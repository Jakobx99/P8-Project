package sw801.remindersystem.Model;
import  java.util.Date;
public class Events{
    private String name;
    private int radius;
    private Date DateTime;
    private boolean recurring = false;
    private SmartDevice Device = null;
    private int When = null;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public int getRadius() {
        return radius;
    }

    public int getWhen() {
        return When;
    }

    public SmartDevice getDevice() {
        return Device;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public void setDevice(SmartDevice device) {
        Device = device;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public void setWhen(int when) {
        When = when;
    }
}