package sw801.remindersystem.Model;

import java.util.Date;

public class Events {
    private String name;
    private Integer radius;
    private Date DateTime;
    private boolean recurring = false;
    private SmartDevice Device = null;
    private Integer when;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Integer getWhen() {
        return when;
    }

    public void setWhen(Integer when) {
        when = when;
    }

    public SmartDevice getDevice() {
        return Device;
    }

    public void setDevice(SmartDevice device) {
        Device = device;
    }
}