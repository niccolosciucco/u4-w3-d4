package niccoloSciucco.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String city;

    protected Location() {
    }

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
