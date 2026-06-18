package niccoloSciucco.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.List;

@Entity
public class GaraDiAtletica extends Evento {
    @Column(name = "set_atleti")
    List<String> setAtleti;
    @ManyToOne
    private Persona vincitore;

    protected GaraDiAtletica() {
    }

    public GaraDiAtletica(String title, LocalDate date, String description, String eventType, int maxPartecipants, String city, Location location, List<String> setAtleti, Persona vincitore) {
        super(title, date, description, eventType, maxPartecipants, city, location);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }
}
