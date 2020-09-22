package com.boris.businesscomponent;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.boris.entity.Impiegato;
import com.boris.entity.Indirizzo;

public class ImpiegatoBC {
	private static SessionFactory factory;

	// creare session factory di hibernate che gli serve per usare i comandi di crud
	public static SessionFactory getSessionFactory() {
		try {
			factory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Throwable exc) {
			System.err.println("Errore di inizializzazione");
			throw new ExceptionInInitializerError(exc);
		}
	}
	

	public static Indirizzo createInd(String via, String citta, String provincia,String cap) {
		Session session = factory.openSession();
		Transaction tx = null;
		Indirizzo indirizzo = null;
		try {
			tx = session.beginTransaction();
			indirizzo = new Indirizzo(via, cap, provincia, citta);
			session.save(indirizzo);
			tx.commit();
		} catch (HibernateException exc) {
			if (tx != null)
				tx.rollback();
			exc.printStackTrace();
		} finally {
			session.close();
		}
		return indirizzo;
	}

	public static void create(String nome, double stipendio, String reparto, Indirizzo indirizzo) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Impiegato imp = new Impiegato(nome, stipendio, reparto, indirizzo);
			session.save(imp);
			tx.commit();
		} catch (HibernateException exc) {
			if (tx != null)
				tx.rollback();
			exc.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void getImpiegati() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<?> impiegati = session.createQuery("FROM Impiegato").getResultList();
			Iterator<?> iterator = impiegati.iterator();
			while (iterator.hasNext()) {
				Impiegato impiegato = (Impiegato) iterator.next();
				System.out.print("Nome: " + impiegato.getNome() + "\t");
				System.out.print("Stipendio: " + impiegato.getStipendio() + "\t");
				System.out.println("Reparto: " + impiegato.getReparto());
				Indirizzo indirizzo = impiegato.getIndirizzo();
				System.out.println("Indirizzo: ");
				System.out.println("\tVia: "+indirizzo.getVia());
				System.out.println("\tCap: "+indirizzo.getCap());
				System.out.println("\tCittà: "+indirizzo.getCitta());
				System.out.println("\tProvincia: "+indirizzo.getProvincia());
			}
			tx.commit();
		} catch (HibernateException exc) {
			if (tx != null)
				tx.rollback();
			exc.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * public static void update(long id, double stipendio) { Session session =
	 * factory.openSession(); Transaction tx = null; try { tx =
	 * session.beginTransaction(); Impiegato impiegato =
	 * session.get(Impiegato.class, id); impiegato.setStipendio(stipendio);
	 * session.update(impiegato); tx.commit(); } catch (HibernateException exc) { if
	 * (tx != null) tx.rollback(); exc.printStackTrace(); } finally {
	 * session.close(); }
	 * 
	 * }
	 * 
	 * public static void delete(long id) { Session session = factory.openSession();
	 * Transaction tx = null; try { tx = session.beginTransaction(); Impiegato
	 * impiegato = session.get(Impiegato.class, id); session.delete(impiegato);
	 * tx.commit(); } catch (HibernateException exc) { if (tx != null)
	 * tx.rollback(); exc.printStackTrace(); } finally { session.close(); }
	 * 
	 * }
	 */
}