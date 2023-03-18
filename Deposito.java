package Prueba1_Bodega;

//Clase depósito que simula un depósito rectangular de bodega para almacenar 
//líquidos como aceite, vino etc

public class Deposito {
	
	public int largo; //en cms
	public int ancho; //en cms
	public int alto; //en cms
	public int lleno_actual = 0; //en cms3
	public String nombreDeposito;
	 
	
	/*Constructor de la clase que crea un depósito con los parámetros dados con lleno actual=0
	Si largo,ancho o alto es < 50 cm o > 1000 cms se fija para ese valor a 100 cm por defecto
	Sino se le pasa nombre el depósito se llamará "Depósito Genérico"
	Los tests deberán comprobar la correcta creación y que el largo, ancho y alto están efectivamente 
	entre 50cm y 1000 cms y sino verificar que pone el valor por defecto
	También deberán comprobar que sino se le pasa un string vacío en la creación 
	el nombre se fija a "Depósito Genérico" en la creación*/
	
	public Deposito(int v_largo, int v_ancho, int v_alto, String v_nombreDeposito) {
		if (v_largo < 50 || v_largo > 1000) {
			largo = 100;
		} else {
			largo = v_largo;
		}
		if (v_ancho < 50 || v_ancho > 1000) {
			ancho = 100;
		} else {
			ancho = v_ancho;
		}
		if (v_alto < 50 || v_alto > 1000) {
			alto = 100;
		} else {
			alto = v_alto;
		}
		if (v_nombreDeposito == "") {
			nombreDeposito = "Deposito Generico";
		} else {
			nombreDeposito = v_nombreDeposito;
		}
		
	}
	
	/*
	 * Método que devuelve el volumen del depósito (se calcula en base a largo * ancho * alto) 
	 */
	public int volumen() {
		
		return (largo * ancho * alto);
		
	}
	
	/*
	 * Método que calcula y fija el estado final de lleno actual como lleno actual mas el valor de cm3s de transvase
	 * v_transvase puede ser positivo (para añadir liquido) o negativo (para sacar líquido del depósito)
	 * Si se obtiene un lleno actual negativo se fija lleno actual a 0
	 * Si se obtiene un lleno actual superior al volumen posible se fija lleno actual al valor obtenido por volumen()   
	 */
	public void transvase(int v_transvase) {
		int lleno_result;
		int volumen_max;
		
		volumen_max = volumen();
		
		lleno_result = lleno_actual + v_transvase;
				
		if (lleno_result <= 0) {
			lleno_actual = 0;
		} else if (lleno_result > volumen_max){
			lleno_actual = volumen_max;
		} else {
			lleno_actual = lleno_result;
		}
	}
	
	/*
	 * Método que vacía totalmente el depósito
	 * Pone lleno_actual a 0
	 * 
	 */
	public void vaciar() {
		lleno_actual = 0;
	}
	
	/*
	 * Método que llena completamente el depósito a su volumen máximo posible
	 */
	public void llenar() {
		lleno_actual = volumen(); 
	}

}
