package test.com.boris.businesscomponent;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import com.boris.businesscomponent.ImpiegatoBC;
import com.boris.entity.Skill;

class ImpiegatoBCTest {

	@Test
	void testMetodiCRUD() {
		try {
			
			ImpiegatoBC.getSessionFactory();
			System.out.println("Connessione ottenuta");
			
			Set<Skill> set = new HashSet<Skill>();
			set.add(new Skill("Java"));
			set.add(new Skill("Angular"));
			set.add(new Skill("Spring"));
			ImpiegatoBC.create("Boris", 2000, "Developing",set);
			Set<Skill> set2 = new HashSet<Skill>();
			set2.add(new Skill("Javascript"));
			set2.add(new Skill("PHP"));			
			ImpiegatoBC.create("Giudi", 1000, "Developing",set2);
			
						
			System.out.println("--getImpiegati--");
			ImpiegatoBC.getImpiegati();

			/*
			 * System.out.println("--delete imp 2--"); ImpiegatoBC.delete(2);
			 * ImpiegatoBC.getImpiegati();
			 */

			/*
			 * System.out.println("--update imp 3--"); ImpiegatoBC.update(3, 2500);
			 * ImpiegatoBC.getImpiegati();
			 */
		} 
		catch (Throwable exc) {
			System.err.println("Oggetto SessionFactory non funzionante");
			exc.printStackTrace();
			fail();
		}
	}

}
