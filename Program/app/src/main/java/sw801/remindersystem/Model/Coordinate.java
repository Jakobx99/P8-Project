package sw801.remindersystem.Model;
import java.text.DecimalFormat;

/**
 * A class to represent a latitude and longitude
 */
public class Coordinate{

    private double latitude, longitude;

    public Coordinate(String coords)
    {
        String[] parts = coords.split(", ");
        Double longi = parseDouble(parts[0]);
        Double lati = parseDouble(parts[1]);
        setLongitude(longi);
        setLatitude(lati);
    }
    public Coordinate() {}

    public Coordinate(double latitude, double longitude)
    {
        setLongitude(longitude);
        setLatitude(latitude);
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return (longitude + ", " + latitude);
    }

}
