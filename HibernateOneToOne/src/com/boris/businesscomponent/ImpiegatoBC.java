package com.boris.businesscomponent;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.boris.entity.DatiAziendali;
import com.boris.entity.Impiegato;

public class ImpiegatoBC {
	private static SessionFactory factory;

	public static SessionFactory getSessionFactory() {
		try {
			factory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Throwable exc) {
			System.err.println("Errore di inizializzazione");
			throw new ExceptionInInitializerError(exc);
		}
	}

	public static DatiAziendali createDati(String codice, String reparto, double stipendio) {
		Session session = factory.openSession();
		Transaction tx = null;
		DatiAziendali dati = null;
		try {
			tx = session.beginTransaction();
			dati = new DatiAziendali(codice, reparto, stipendio);
			session.save(dati);
			tx.commit();
		} catch (HibernateException exc) {
			if (tx != null)
				tx.rollback();
			exc.printStackTrace();
		} finally {
			session.close();
		}
		return dati;
	}

	public static void create(String nome, String cognome, String indirizzo, DatiAziendali dati) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Impiegato imp = new Impiegato(nome, cognome, indirizzo, dati);
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
				System.out.print("Cognome: " + impiegato.getCognome() + "\t");
				System.out.println("Reparto: " + impiegato.getIndirizzo());
				DatiAziendali dati = impiegato.getDatiAziendali();
				System.out.println("Dati: ");
				System.out.println("\tCodice: " + dati.getCodice());
				System.out.println("\tReparto: " + dati.getReparto());
				System.out.println("\tStipendio: " + dati.getStipendio());
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