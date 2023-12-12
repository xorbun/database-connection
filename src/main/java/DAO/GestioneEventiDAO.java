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
    public GestioneEventi findby(Long id)
    {
        return em.find(GestioneEventi.class,id);
    }

    public void deleteevent(long id)
    {
        GestioneEventi found=this.findby(id);
        if(found !=null)
        {
            EntityTransaction transaction= em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("evento cancellato");
        }
        else
        {
            System.out.println("id evento non trovato");
        }
    }

}
