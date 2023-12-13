package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.LocationDAO;
import DAO.PartecipazioneDAO;
import DAO.PersonaDAO;
import entities.*;
import DAO.GestioneEventiDAO;

import java.util.Scanner;

public class Application
{
    private static final EntityManagerFactory emf=Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        EntityManager em=emf.createEntityManager();
        GestioneEventiDAO sd= new GestioneEventiDAO(em);
        PersonaDAO pd=new PersonaDAO(em);
        LocationDAO ld=new LocationDAO(em);
        PartecipazioneDAO pad=new PartecipazioneDAO(em);
        System.out.println("cosa vuoi fare?1)carica dati nel db,2)cerca id evento nel db,3)cancella evento nel db");
        int menu;
        menu= input.nextInt();
        switch (menu)
        {
            case 1:
            {
                Scanner input2=new Scanner(System.in);
                System.out.println("titolo");
                String titolo;
                titolo= input2.nextLine();
                System.out.println("data");
                String data;
                data= input2.nextLine();
                System.out.println("descrizione");
                String desc;
                desc = input2.nextLine();
                System.out.println("numero persone");
                int numberofpeople;
                numberofpeople= input2.nextInt();
                GestioneEventi evento1 = new GestioneEventi(titolo, data, desc, Tipoevento.PRIVATO, numberofpeople);
                System.out.println("nome persona");
                String nomep;
                nomep=input2.nextLine();
                System.out.println("cognome persona");
                String cognome;
                cognome=input2.nextLine();
                System.out.println("email");
                String mail;
                mail=input2.nextLine();
                System.out.println("data nascita");
                String datan;
                datan=input2.nextLine();
                Persona persona1=new Persona(nomep,cognome,mail,datan, Sesso.MASCHIO);
                System.out.println("nome location");
                String locationn;
                locationn=input2.nextLine();
                System.out.println("città");
                String citta;
                citta=input2.nextLine();
                Location location1=new Location(locationn,citta);
                Partecipazione partecipazione1=new Partecipazione(persona1,location1);
                sd.save(evento1);
                pd.save(persona1);
                ld.save(location1);
                pad.save(partecipazione1);
                break;
            }
            case 2:
            {
                System.out.println("inserisci l id da cercare");
                long idevento;
                idevento= input.nextInt();
                GestioneEventi eventofromdb = sd.findby(idevento);
                if (eventofromdb != null)
                {
                    System.out.println(eventofromdb);
                    Partecipazione partecipazionefromdb=pad.findby(1);
                    System.out.println(partecipazionefromdb);
                } else
                {
                    System.out.println("l'id" + idevento + "non è stato trovato");
                }
                break;
            }
            case 3:
            {
                System.out.println("cerca l evento da cancellare");
                long idevento2;
                idevento2=input.nextInt();
                sd.deleteevent(idevento2);
                break;
            }
        }
        input.close();
        em.close();
        emf.close();
    }
}
