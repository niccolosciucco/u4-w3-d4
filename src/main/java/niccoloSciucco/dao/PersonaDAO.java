package niccoloSciucco.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import niccoloSciucco.entities.Persona;

import java.util.UUID;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona newPersona) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newPersona);
        transaction.commit();
    }

    public Persona find(UUID id) {
        Persona persona = this.entityManager.find(Persona.class, id);
        return persona;
    }
}
