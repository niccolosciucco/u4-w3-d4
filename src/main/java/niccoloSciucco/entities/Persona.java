package niccoloSciucco.entities;

import jakarta.persistence.*;
import niccoloSciucco.enums.Sex;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    protected Persona() {
    }

    public Persona(String name, String lastName, String email, LocalDate dateOfBirth, Sex sex) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }
}
