package niccoloSciucco.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class PartitaDiCalcio extends Evento {
    @Column(name = "squadra_di_casa")
    private String squadraDiCasa;
    @Column(name = "squadra_ospite")
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "n_gol_squadra_casa")
    private int nGolCasa;
    @Column(name = "n_gol_squadra_trasferta")
    private int nGolTrasferta;

    protected PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String title, LocalDate date, String description, String eventType, int maxPartecipants, String city, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int nGolCasa, int nGolTrasferta) {
        super(title, date, description, eventType, maxPartecipants, city, location);

        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.nGolCasa = nGolCasa;
        this.nGolTrasferta = nGolTrasferta;
    }
}
