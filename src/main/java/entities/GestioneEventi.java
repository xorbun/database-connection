package entities;

import javax.persistence.*;

@Entity
@Table(name="GestioneEventi")
public class GestioneEventi
{
    @Id
    @GeneratedValue
    private long id;

    @Column(name="titolo")
    private String titolo;
    @Column(name="data_evento")
    private String dataevento;
    @Column(name="descrizione")
    private  String descrizione;
    @Column(name="tipo")
    @Enumerated(EnumType.STRING)
    private Tipoevento tipoevento;
    @Column(name="numero_persone")
    private int numeropersone;


    public GestioneEventi()
    {

    }
    public GestioneEventi(String titolo, String dataevento, String descrizione, Tipoevento tipoevento,int numeropersone)
    {
        this.titolo=titolo;
        this.dataevento=dataevento;
        this.descrizione=descrizione;
        this.tipoevento=tipoevento;
        this.numeropersone=numeropersone;
    }
    public String getTitolo()
    {
        return titolo;
    }

    public void setTitolo(String titolo)
    {
        this.titolo = titolo;
    }

    public String getDataevento()
    {
        return dataevento;
    }

    public void setDataevento(String dataevento)
    {
        this.dataevento = dataevento;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public int getNumeropersone()
    {
        return numeropersone;
    }

    public void setNumeropersone(int numeropersone)
    {
        this.numeropersone = numeropersone;
    }

    public Tipoevento getTipoevento()
    {
        return tipoevento;
    }

    public void setTipoevento(Tipoevento tipoevento)
    {
        this.tipoevento = tipoevento;
    }

    @Override
    public String toString() {
        return "GestioneEventi{" +
                "titolo='" + titolo + '\'' +
                ", dataevento='" + dataevento + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipoevento=" + tipoevento +
                ", numeropersone=" + numeropersone +
                '}';
    }
}
