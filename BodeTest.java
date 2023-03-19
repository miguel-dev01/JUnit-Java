package Prueba1_Bodega;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BodeTest {
	
	Bodega bode = new Bodega("Bodega Miguel", 10);
	
	@Test
	void testBodega() {	
		assertEquals("Bodega Miguel", bode.nombre);
		assertEquals(10, bode.depositos.length);
	
	}
	
	@Test
	void testAnyadeDeposito() {
		assertEquals(0, bode.anyadeDeposito(60, 60, 60, "depo0", 0));
		
		bode.anyadeDeposito(60, 60, 60, "depo1", 1);
		assertEquals(60, bode.depositos[1].alto);
		assertEquals(60, bode.depositos[1].ancho);
		assertEquals(60, bode.depositos[1].largo);
		assertEquals("depo1", bode.depositos[1].nombreDeposito);
		
		assertNotNull(bode.depositos[1]);
		
	}
	
	@Test
	void testQuitaDeposito() {
		bode.anyadeDeposito(60, 60, 60, "depo", 5);
		bode.quitaDeposito(5);
		assertEquals(null, bode.depositos[5]);
		
	}
	
	@Test
	void testVolumen() {
		bode.anyadeDeposito(60, 60, 60, "depo", 1);
		bode.anyadeDeposito(60, 60, 60, "depo2", 2);
		bode.anyadeDeposito(60, 60, 60, "depo3", 3);
		//assertEquals(bode.volumen(), 648000);
		assertEquals(bode.volumen(), bode.depositos[1].volumen()+bode.depositos[2].volumen()+bode.depositos[3].volumen());
		
	}
	
	@Test
	void testllenaBodega() {
		bode.anyadeDeposito(60, 60, 60, "depo1", 0);
		bode.anyadeDeposito(60, 60, 60, "depo2", 1);
		bode.llenaBodega();
		bode.depositos[0].lleno_actual = bode.depositos[0].volumen();
		bode.depositos[1].lleno_actual = bode.depositos[1].volumen();
		assertEquals(bode.llenaBodega(), bode.depositos[0].lleno_actual + bode.depositos[1].lleno_actual);
		
	}
	
} // cierre class
