package sw801.remindersystem.Model.Persistence.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Kasper Helsted on 3/21/2018.
 */

@Entity(foreignKeys = @ForeignKey(
        entity = Coordinate.class, parentColumns = "id", childColumns = "coordinate_id", onDelete = CASCADE
))
public class PredefinedLocation {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "coordinate_id")
    private Integer coordinate_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoordinate_id() {
        return coordinate_id;
    }

    public void setCoordinate_id(Integer coordinate_id) {
        this.coordinate_id = coordinate_id;
    }
}