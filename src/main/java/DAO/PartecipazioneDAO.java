package DAO;

import entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO
{
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em)
    {
        this.em = em;
    }
    public void save(Partecipazione partecipazione)
    {
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("fatto");
    }
    public Partecipazione findby(long id)
    {
        return em.find(Partecipazione.class,id);
    }
    public void findbyanddelete(long id)
    {
        Partecipazione found=em.find(Partecipazione.class,id);
        if(found!=null)
        {
            EntityTransaction transaction= em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("eliminato");
        }
    }
}
