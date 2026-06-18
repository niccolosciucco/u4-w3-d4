package niccoloSciucco.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento {
    protected String title;
    protected LocalDate date;
    protected String description;
    @Column(name = "event_type")
    protected String eventType;
    @Column(name = "max_partecipants")
    protected int maxPartecipants;
    protected String city;
    @ManyToOne
    @JoinColumn(name = "location_id")
    protected Location location;
    @Id
    @GeneratedValue
    private UUID id;

    protected Evento() {
    }

    public Evento(String title, LocalDate date, String description, String eventType, int maxPartecipants, String city, Location location) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.eventType = eventType;
        this.maxPartecipants = maxPartecipants;
        this.city = city;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }
}
