package sw801.remindersystem.Model.Persistence.RelationEntity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.Set;

import sw801.remindersystem.Model.Persistence.Entity.Coordinate;
import sw801.remindersystem.Model.Persistence.Entity.When;

/**
 * Created by Kasper Helsted on 3/22/2018.
 */

public class WhenWithCoordinate {
    @Embedded
    public When when;

    @Relation(parentColumn = "coordinateId", entityColumn = "id", entity = Coordinate.class)
    public Set<Coordinate> coordinate;
}
