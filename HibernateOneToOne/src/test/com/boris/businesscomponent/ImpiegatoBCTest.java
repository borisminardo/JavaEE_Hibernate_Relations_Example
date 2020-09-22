package test.com.boris.businesscomponent;

import static org.junit.Assert.fail;


import org.junit.jupiter.api.Test;
import com.boris.businesscomponent.ImpiegatoBC;
import com.boris.entity.DatiAziendali;

class ImpiegatoBCTest {

	@Test
	void testMetodiCRUD() {
		try {
			
			ImpiegatoBC.getSessionFactory();
			System.out.println("Connessione ottenuta");
			
			DatiAziendali dati= ImpiegatoBC.createDati("00kko", "informatica", 3000);
			DatiAziendali dati2= ImpiegatoBC.createDati("00mmo", "informatica", 2000);
			
			ImpiegatoBC.create("Boris", "Minardo","Via michele barbi 30 00125 Roma RM", dati);
			ImpiegatoBC.create("Giudi", "Minardo","Via michele barbi 30 00125 Roma RM", dati2);
			
						
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
