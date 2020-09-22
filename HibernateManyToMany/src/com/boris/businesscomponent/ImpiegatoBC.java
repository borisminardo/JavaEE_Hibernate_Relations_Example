package com.boris.businesscomponent;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.boris.entity.Impiegato;
import com.boris.entity.Skill;

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

	public static void create(String nome, double stipendio, String reparto, Set<Skill> skill) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Impiegato imp = new Impiegato(nome, stipendio, reparto);
			imp.setSkill(skill);
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

				Set<Skill> skills = impiegato.getSkill();
				Iterator<?> iterator2 = skills.iterator();
				while (iterator2.hasNext()) {
					Skill skill = (Skill) iterator2.next();
					System.out.println("Skill: " + skill.getNome());
				}
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

	public static void update(long id, double stipendio) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Impiegato impiegato = session.get(Impiegato.class, id);
			impiegato.setStipendio(stipendio);
			session.update(impiegato);
			tx.commit();
		} catch (HibernateException exc) {
			if (tx != null)
				tx.rollback();
			exc.printStackTrace();
		} finally {
			session.close();
		}

	}

	public static void delete(long id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Impiegato impiegato = session.get(Impiegato.class, id);
			session.delete(impiegato);
			tx.commit();
		} catch (HibernateException exc) {
			if (tx != null)
				tx.rollback();
			exc.printStackTrace();
		} finally {
			session.close();
		}

	}
}