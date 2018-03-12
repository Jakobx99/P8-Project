import java.util.Date;
public class GlobalMute{
    private String name;
    private Date StartTime;
    private Date EndTime;
    private Coordinate Coords;
    private string Note;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoords() {
        return Coords;
    }

    public void setCoords(Coordinate Coords) {
        this.Coords = Coords;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public void setNote(string note) {
        Note = note;
    }

    public string getNote() {
        return Note;
    }
}