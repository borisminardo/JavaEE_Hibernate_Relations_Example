package test.com.boris.businesscomponent;

import static org.junit.Assert.fail;


import org.junit.jupiter.api.Test;
import com.boris.businesscomponent.ImpiegatoBC;
import com.boris.entity.Indirizzo;

class ImpiegatoBCTest {

	@Test
	void testMetodiCRUD() {
		try {
			
			ImpiegatoBC.getSessionFactory();
			System.out.println("Connessione ottenuta");
			
			Indirizzo indirizzo= ImpiegatoBC.createInd("Via michele barbi 30", "Roma", "RM", "00125");
			
			ImpiegatoBC.create("Boris", 2000, "Developing", indirizzo);
			ImpiegatoBC.create("Giudi", 1000, "Developing", indirizzo);
			
						
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
