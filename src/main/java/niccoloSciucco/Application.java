package niccoloSciucco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import niccoloSciucco.dao.EventoDAO;
import niccoloSciucco.dao.LocationDAO;
import niccoloSciucco.dao.PartecipazioneDAO;
import niccoloSciucco.dao.PersonaDAO;
import niccoloSciucco.entities.Concerto;
import niccoloSciucco.entities.Evento;
import niccoloSciucco.entities.Location;
import niccoloSciucco.entities.Persona;
import niccoloSciucco.enums.Genere;
import niccoloSciucco.enums.Sex;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4-w3-d4");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);
        EventoDAO eventoDAO = new EventoDAO(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);

        Persona p1 = new Persona("Aldo", "Baglio", "aldo.baglio@example.com", LocalDate.of(1958, 9, 28), Sex.MASCHIO);
        Persona p2 = new Persona("Giovanni", "Storti", "giovanni.storti@example.com", LocalDate.of(1957, 2, 20), Sex.MASCHIO);
        Persona p3 = new Persona("Giacomo", "Poretti", "giacomo.poretti@example.com", LocalDate.of(1956, 4, 26), Sex.MASCHIO);
        Persona p4 = new Persona("Marina", "Massironi", "marina.massironi@example.com", LocalDate.of(1963, 5, 16), Sex.FEMMINA);
        Persona p5 = new Persona("Silvana", "Fallisi", "silvana.fallisi@example.com", LocalDate.of(1964, 12, 9), Sex.FEMMINA);
        Persona p6 = new Persona("Ajeje", "Brazorf", "ajeje.brazorf@example.com", LocalDate.of(1970, 1, 1), Sex.MASCHIO);
        Persona p7 = new Persona("Nico", "Eisolo", "nico.sardo@example.com", LocalDate.of(1965, 3, 10), Sex.MASCHIO);
        Persona p8 = new Persona("Signora", "Rezzonico", "signora.rezzonico@example.com", LocalDate.of(1950, 6, 18), Sex.FEMMINA);
        Persona p9 = new Persona("Fausto", "Gervasoni", "fausto.gervasoni@example.com", LocalDate.of(1955, 11, 4), Sex.MASCHIO);
        Persona p10 = new Persona("Fusi", "Assenzio", "fusi.assenzio@example.com", LocalDate.of(1980, 8, 12), Sex.MASCHIO);

//        personaDAO.save(p1);
//        personaDAO.save(p2);
//        personaDAO.save(p3);
//        personaDAO.save(p4);
//        personaDAO.save(p5);
//        personaDAO.save(p6);
//        personaDAO.save(p7);
//        personaDAO.save(p8);
//        personaDAO.save(p9);
//        personaDAO.save(p10);

        Location l1 = new Location("Teatro Ambra Jovinelli", "Roma");
        Location l2 = new Location("Teatro Ciak", "Milano");
        Location l3 = new Location("Cortile di Ringhiera", "Milano");
        Location l4 = new Location("Ferramenta Garramone", "Milano");
        Location l5 = new Location("Autogrill", "Piacenza");
        Location l6 = new Location("Spiaggia del Calciobalilla", "Gallipoli");
        Location l7 = new Location("Cinema Paradiso", "Palermo");
        Location l8 = new Location("Villetta di Los Angeles", "Milano");
        Location l9 = new Location("Chiosco del Tafazzi", "Genova");
        Location l10 = new Location("Studio del Dottor Alzeimer", "Torino");

//        locationDAO.save(l1);
//        locationDAO.save(l2);
//        locationDAO.save(l3);
//        locationDAO.save(l4);
//        locationDAO.save(l5);
//        locationDAO.save(l6);
//        locationDAO.save(l7);
//        locationDAO.save(l8);
//        locationDAO.save(l9);
//        locationDAO.save(l10);

        Location location1FromDb = locationDAO.find(UUID.fromString("01729c19-a93a-4bcf-a228-f1739224ec11"));
        Location location2FromDb = locationDAO.find(UUID.fromString("5ba7cd15-32d9-46fe-81f9-d3e476c0f5e9"));
        Location location3FromDb = locationDAO.find(UUID.fromString("961a6967-96c9-4f1a-8ead-34f856d55144"));
        Location location4FromDb = locationDAO.find(UUID.fromString("d4eb8696-0ab0-44a1-8607-ff52db71d019"));

        Evento e1 = new Evento("Partita sulla Spiaggia", LocalDate.of(2026, 7, 15), "Sfida leggendaria Italia contro Marocco", "CALCIO", 10, "Gallipoli", location1FromDb);
        Evento e2 = new Evento("Scapoli vs Ammogliati", LocalDate.of(2026, 9, 20), "Incontro aziendale di calcetto del giovedì sera", "CALCIO", 14, "Milano", location2FromDb);
        Evento e3 = new Evento("Derby Inter-Milan", LocalDate.of(2026, 10, 5), "Partita vista sulla sedia del soggiorno", "CALCIO", 80000, "Milano", location3FromDb);

        Evento e4 = new Evento("Maratona sul tapis roulant", LocalDate.of(2026, 11, 12), "Tentativo di record mondiale di corsa stazionaria", "ATLETICA", 5, "Milano", location4FromDb);
        Evento e5 = new Evento("100 metri piatti", LocalDate.of(2026, 5, 18), "Gara di velocità tra amici con annesso infortunio", "ATLETICA", 8, "Torino", location1FromDb);
        Evento e6 = new Evento("Lancio del Peso", LocalDate.of(2026, 6, 22), "Gara del lancio dell'oggetto contundente", "ATLETICA", 15, "Roma", location2FromDb);

        Evento e7 = new Evento("I Corti Live", LocalDate.of(2026, 4, 30), "Grande spettacolo teatrale con intermezzi musicali", "CONCERTO", 2000, "Milano", location3FromDb);
        Evento e8 = new Evento("Tel chi el telù", LocalDate.of(2026, 8, 25), "Sotto il tendone del circo tra sketch e risate", "CONCERTO", 3500, "Cernusco sul Naviglio", location4FromDb);
        Evento e9 = new Evento("Anplagghed al Teatro", LocalDate.of(2026, 12, 1), "Spettacolo completamente live senza filtri", "CONCERTO", 1500, "Roma", location1FromDb);
        Evento e10 = new Evento("Concerto a San Siro", LocalDate.of(2026, 7, 1), "Evento musicale dell'anno all'aperto", "CONCERTO", 60000, "Milano", location2FromDb);

        eventoDAO.save(e1);
        eventoDAO.save(e2);
        eventoDAO.save(e3);
        eventoDAO.save(e4);
        eventoDAO.save(e5);
        eventoDAO.save(e6);
        eventoDAO.save(e7);
        eventoDAO.save(e8);
        eventoDAO.save(e9);
        eventoDAO.save(e10);

        Persona persona1 = personaDAO.find(UUID.fromString("259e440e-ca38-45be-89d2-3e5f5032dcb7"));
        Evento evento1 = eventoDAO.find(UUID.fromString("6584ae55-5c32-4300-9467-044176fdfbf6"));
//
//        Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, State.CONFERMATO);
//        partecipazioneDAO.save(partecipazione1);
//
//        PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio("Derby di Milano", LocalDate.of(2026, 10, 5), "Il grande scontro della Madonnina", "CALCIO", 80000, "Milano", location1FromDb, "Milan", "Inter", "Milan", 2, 1);
//        eventoDAO.save(partitaDiCalcio);

//        List<String> atleti = List.of("Aldo Baglio", "Giovanni Storti", "Giacomo Poretti");
//
//        GaraDiAtletica garaDiAtletica = new GaraDiAtletica("Maratona del Secolo", LocalDate.of(2026, 8, 12), "Gara di velocità estrema nel deserto", "ATLETICA", 3, "Milano", location1FromDb, atleti, persona1);
//        eventoDAO.save(garaDiAtletica);

//        Concerto concerto = new Concerto("I Corti Live", LocalDate.of(2026, 4, 30), "Grande spettacolo teatrale", "CONCERTO", 2000, "Milano", location1FromDb, Genere.ROCK, true);
//        eventoDAO.save(concerto);

        List<Concerto> concertiInStreaming = eventoDAO.getConcertiInStreaming(true);
        if (!concertiInStreaming.isEmpty()) {
            Concerto singoloConcertoStream = concertiInStreaming.get(0);
            System.out.println("Concerto in streaming trovato: " + singoloConcertoStream.getTitle());
        } else {
            System.out.println("Nessun concerto in streaming trovato.");
        }

        List<Concerto> concertiPop = eventoDAO.getConcertiPerGenere(Genere.POP);
        if (!concertiPop.isEmpty()) {
            Concerto singoloConcertoRock = concertiPop.get(0);
            System.out.println("Concerto Rock trovato: " + singoloConcertoRock.getTitle());
        } else {
            System.out.println("Nessun concerto Rock trovato.");
        }
    }
}
