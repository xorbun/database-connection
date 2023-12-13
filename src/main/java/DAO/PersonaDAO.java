package DAO;

import entities.Persona;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO
{
    private final EntityManager em;

    public PersonaDAO(EntityManager em)
    {
        this.em = em;
    }
    public void save(Persona persona)
    {
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("fatto");

    }
    public Persona findby(long id)
    {
        return em.find(Persona.class,id);
    }
    public void findbyanddelete(long id)
    {
        Persona found=em.find(Persona.class,id);
        if(found!=null)
        {
            EntityTransaction transaction=em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("utente cancellato");
        }
        else
        {
            System.out.println("utente non trovato");
        }
    }
}
