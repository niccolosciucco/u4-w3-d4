package niccoloSciucco.entities;

import jakarta.persistence.*;
import niccoloSciucco.enums.State;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private State state;

    protected Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento, State state) {
        this.persona = persona;
        this.evento = evento;
        this.state = state;
    }
}
