package niccoloSciucco.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import niccoloSciucco.enums.Genere;

import java.time.LocalDate;

@Entity
public class Concerto extends Evento {
    private Genere genere;
    @Column(name = "streaming")
    private boolean isStreaming;

    protected Concerto() {
    }

    public Concerto(String title, LocalDate date, String description, String eventType, int maxPartecipants, String city, Location location, Genere genere, boolean isStreaming) {
        super(title, date, description, eventType, maxPartecipants, city, location);
        this.genere = genere;
        this.isStreaming = isStreaming;
    }
}
