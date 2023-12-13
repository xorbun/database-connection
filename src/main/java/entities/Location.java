package entities;

import javax.persistence.*;


@Entity
@Table(name="location")
public class Location
{
    @Id
    @GeneratedValue
    private long id;
    @Column(name="nome_location")
    private String nome;
    @Column(name="nome_città")
    private String città;


    public Location(){}

    public Location(String nome, String città)
    {
        this.nome = nome;
        this.città = città;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCittà()
    {
        return città;
    }

    public void setCittà(String città)
    {
        this.città = città;
    }

    @Override
    public String toString()
    {
        return "Location{" +
                "nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
