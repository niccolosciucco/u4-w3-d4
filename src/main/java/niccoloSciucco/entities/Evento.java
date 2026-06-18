package niccoloSciucco.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private LocalDate date;
    private String description;
    @Column(name = "event_type")
    private String eventType;
    @Column(name = "max_partecipants")
    private int maxPartecipants;
    private String city;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

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
}
