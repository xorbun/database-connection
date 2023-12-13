package DAO;

import entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO
{

    private final EntityManager em;

    public LocationDAO(EntityManager em)
    {
        this.em = em;
    }
    public void save(Location location)
    {
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("fatto");
    }
    public Location findby(long id)
    {
        return em.find(Location.class,id);

    }
    public void findbyanddelete(long id)
    {
        Location found=em.find(Location.class,id);
        if(found!=null)
        {
            EntityTransaction transaction=em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("eliminato");
        }
        else
        {
            System.out.println("elemento non trovato");
        }
    }
}
