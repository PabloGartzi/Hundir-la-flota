package HundirLaFlota;

public abstract class Jugador {
	
	private int dinero;
	private Integer[] listaArmas;
	private TableroDisparo tableroDisparo;
	private TableroBarco tableroBarco;
	
	public Jugador() {
		listaArmas = new Integer[4];
		
	}
	
	public boolean disparar(Integer pX, Integer pY) {
		return false;
	}
	
	public boolean reparar() {
		return false;
	}
	
	public boolean colocarBarco(Barco pBarco, Integer pX, Integer pY, boolean pDireccion) {
		if(pDireccion) {
			for(int i=0; i=pBarco.getTipoBarco().tamano; i++) {
				tableroBarco.
			}
		}
		return false;
	}
	
	public TableroDisparo getTableroDisparo() {
		return tableroDisparo;
	}
	
	public TableroBarco getTableroBarco() {
		return tableroBarco;
	}
	
}
