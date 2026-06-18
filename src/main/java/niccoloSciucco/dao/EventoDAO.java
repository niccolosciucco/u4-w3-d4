package niccoloSciucco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import niccoloSciucco.entities.Evento;

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
}
