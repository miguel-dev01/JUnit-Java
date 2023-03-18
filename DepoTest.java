package Prueba1_Bodega;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepoTest {
	
	@Test
	void testDeposito() {
		
		Deposito depo1 = new Deposito(500,500,500,"depo1");
		assertEquals(500, depo1.largo);
		assertEquals(500, depo1.ancho);
		assertEquals(500, depo1.alto);
		assertEquals("depo1", depo1.nombreDeposito);
		
		Deposito depo2 = new Deposito(49,49,49,"");
		assertEquals(100, depo2.largo);
		assertEquals(100, depo2.ancho);
		assertEquals(100, depo2.alto);
		assertEquals("Deposito Generico", depo2.nombreDeposito);
		
		Deposito depo3 = new Deposito(1001,1001,1001,"");
		assertEquals(100, depo3.largo);
		assertEquals(100, depo3.ancho);
		assertEquals(100, depo3.alto);
		
	}
	
	@Test
	void testVolumen() {
		Deposito depo = new Deposito(200,101,250,"depo");
		assertEquals(5050000, depo.volumen());	
	}
	
	@Test
	void testTransvase() {
		
		Deposito depo1 = new Deposito(70,70,70,"depo1");
		depo1.transvase(0);
		assertEquals(0, depo1.lleno_actual);
		
		Deposito depo2 = new Deposito(60,60,60,"depo2");
		depo2.lleno_actual = -50;
		depo2.transvase(0);
		assertEquals(0, depo2.lleno_actual);
		
		Deposito depo3 = new Deposito(60,60,60,"depo3");
		depo3.lleno_actual = 50;
		depo3.transvase(20);
		assertEquals(70, depo3.lleno_actual);
		
		Deposito depo4 = new Deposito(60,60,60,"depo4");
		depo4.lleno_actual = 215999;
		depo4.transvase(10);
		assertEquals(depo4.volumen(), depo4.lleno_actual);
		
	}
	
	@Test
	void testVaciar() {
		
		Deposito depo = new Deposito(60,60,60,"depo");
		depo.lleno_actual = 500;
		depo.vaciar();
		assertEquals(0, depo.lleno_actual);
		
	}
	
	@Test
	void testLlenar() {
		
		Deposito depo = new Deposito(60,60,60,"depo");
		depo.llenar();
		assertEquals(216000, depo.lleno_actual);
		
		
	}
	
	

} // cierre class
