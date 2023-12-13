package entities;

import javax.persistence.*;

@Entity
public class Partecipazione
{
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="persona_id", nullable = false)
    private Persona persona;
    @ManyToOne
    @JoinColumn(name="location_id",nullable = false)
    private Location location;


    public Partecipazione(){}
    public Partecipazione(Persona persona, Location location)
    {
        this.persona = persona;
        this.location = location;
    }
}
