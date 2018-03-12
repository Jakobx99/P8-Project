public class PredefinedLocation{
    private String Name;
    private Coordinate Coords;

    public void setCoords(Coordinate coords) {
        Coords = coords;
    }

    public Coordinate getCoords() {
        return Coords;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}