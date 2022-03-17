package HundirLaFlota;

public enum TipoBarco {
	
	PORTAAVIONES(4), SUBMARINO(3), DESTRUCTOR(2), FRAGATA(1) ;
	
	private int tamano;

	private TipoBarco (int pTamano) {
	this.tamano= pTamano;
	}
	
	
}