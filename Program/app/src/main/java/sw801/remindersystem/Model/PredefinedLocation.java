package sw801.remindersystem.Model;

public class PredefinedLocation {
    private String Name;
    private Coordinate Coords;

    public Coordinate getCoords() {
        return Coords;
    }

    public void setCoords(Coordinate coords) {
        Coords = coords;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}