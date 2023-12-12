package DAO;
import entities.GestioneEventi;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;



public class GestioneEventiDAO
{
    private final EntityManager em;

    public GestioneEventiDAO(EntityManager em)
    {
        this.em=em;
    }

    public void save(GestioneEventi evento)
    {
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("fatto");
    }

}
