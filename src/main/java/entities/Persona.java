package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="persone")
public class Persona
{
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="cognome")
    private String cognome;
    @Column(name = "email")
    private String email;
    @Column(name="data_nascita")
    private String datanascita;
    @Column(name="sesso")
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione>Partecipazionelist;



    public Persona()
    {
    }

    public Persona(String nome, String cognome, String email, String datanascita, Sesso sesso)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.datanascita = datanascita;
        this.sesso = sesso;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getDatanascita()
    {
        return datanascita;
    }

    public void setDatanascita(String datanascita)
    {
        this.datanascita = datanascita;
    }

    public Sesso getSesso()
    {
        return sesso;
    }

    public void setSesso(Sesso sesso)
    {
        this.sesso = sesso;
    }

    public List<Partecipazione> getPartecipazionelist() {
        return Partecipazionelist;
    }

    @Override
    public String toString()
    {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", datanascita='" + datanascita + '\'' +
                ", sesso=" + sesso +
                '}';
    }
}
