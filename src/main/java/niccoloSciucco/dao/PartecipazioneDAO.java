package niccoloSciucco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import niccoloSciucco.entities.Partecipazione;

import java.util.UUID;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione newPartecipazione) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newPartecipazione);
        transaction.commit();
    }

    public Partecipazione find(UUID id) {
        Partecipazione partecipazione = this.entityManager.find(Partecipazione.class, id);
        return partecipazione;
    }
}
