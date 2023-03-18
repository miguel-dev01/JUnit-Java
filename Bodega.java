package Prueba1_Bodega;

/*
 * Clase bodega que simula una bodega que puede tener varios depositos
 */

public class Bodega {
	
	public String nombre;
	public Deposito[] depositos;
	
	/*
	 * Constructor de clase que crea una bodega con nombre de bodega v_nombre y espacio para v_numdepositos
	 * Si v_numdepositos es negativo se deberá crear la bodega sin espacio  
	 */
	public Bodega(String v_nombre, int v_numdepositos) {
		nombre = v_nombre;
		depositos = new Deposito[v_numdepositos];
		/*
		if(v_numdepositos <= 0) {
			depositos = new Deposito[0];
		} else  {
			depositos = new Deposito[v_numdepositos];
		}
		*/
		
	}
	
	/*
	 * Método que añade un deposito en la bodega con las característcas pasadas como valor
	 * y su posición en el array 
	 * devuelve la posición del array donde se ha creado
	 */
	
	public int anyadeDeposito(int v_largo, int v_ancho, int v_alto, String v_nombreDeposito, int pos) {
		
		Deposito deposito = new Deposito(v_largo, v_ancho, v_alto, v_nombreDeposito);
		depositos[pos] = deposito; 
		
		return(pos);
	}
	
	/*
	 * Metodo que quita un deposito de la bodega de la posición pos
	 * y devuelve pos
	 */
	public int quitaDeposito(int pos) {
	    depositos[pos] = null;	
		return(pos);
	}
	
	/*
	 * Metodo que calcula el volumen total (Sumados) de todos los depositos 
	 */
	
	public int volumen() {
		int totalVolumen = 0;
			
			for (int i = 0; i  < depositos.length; i++) { 
				if (depositos[i] != null) {
					totalVolumen += depositos[i].volumen();
				}
			}
			return totalVolumen;
	}
	
	/*
	 *  Metodo que llena la bodega entera
	 *  LLena todos los deposistos
	 *  y devuelve el valor total actual de la bodega en cms3
	 */
	
	public int llenaBodega() {
		int capacidad = 0;
		for (int i = 0; i  < depositos.length; i++) { 
			if (depositos[i] != null) {
				 depositos[i].llenar();
				 capacidad += depositos[i].lleno_actual;
			}
		}

		return capacidad;
	}
		
}