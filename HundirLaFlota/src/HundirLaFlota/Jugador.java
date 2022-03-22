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
	
	public void colocarBarco(Barco pBarco, Coordenada pCoordenada, boolean pDireccion) {
		if(pDireccion) {
			for(int i=0; i<=pBarco.getTamano(); i++) {
				tableroBarco.setBarco(new Coordenada(pCoordenada.getX()+i, pCoordenada.getY()));
			}
		}
		else {
			for(int i=0; i<=pBarco.getTamano(); i++) {
				tableroBarco.setBarco(new Coordenada(pCoordenada.getX(), pCoordenada.getY()+i));
			}
		}
	}
	
	public TableroDisparo getTableroDisparo() {
		return tableroDisparo;
	}
	
	public TableroBarco getTableroBarco() {
		return tableroBarco;
	}
	
}
