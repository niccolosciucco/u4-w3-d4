package niccoloSciucco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import niccoloSciucco.entities.Concerto;
import niccoloSciucco.entities.Evento;
import niccoloSciucco.enums.Genere;

import java.util.List;
import java.util.UUID;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newEvento);
        transaction.commit();
    }

    public Evento find(UUID id) {
        Evento evento = this.entityManager.find(Evento.class, id);
        return evento;
    }

    public List<Concerto> getConcertiInStreaming(boolean isStreaming) {
        TypedQuery<Concerto> query = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.isStreaming = :streaming", Concerto.class
        );
        query.setParameter("streaming", isStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> query = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class
        );
        query.setParameter("genere", genere);
        return query.getResultList();
    }
}
