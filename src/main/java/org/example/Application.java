package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.GestioneEventi;
import DAO.GestioneEventiDAO;
import entities.Tipoevento;

import java.util.Scanner;

public class Application
{
    private static final EntityManagerFactory emf=Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        EntityManager em=emf.createEntityManager();
        GestioneEventiDAO sd= new GestioneEventiDAO(em);
        System.out.println("titolo");
        String titolo=input.nextLine();
        System.out.println("data");
        String data=input.nextLine();
        System.out.println("descrizione");
        String desc=input.nextLine();
        System.out.println("numero persone");
        int numberofpeople=input.nextInt();
        GestioneEventi evento1=new GestioneEventi(titolo,data,desc,Tipoevento.PRIVATO,numberofpeople);
        sd.save(evento1);
        input.close();
    }
}
