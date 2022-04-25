package HundirLaFlota;

public abstract class Jugador {
	
	private int dinero;
	private Integer[] listaArmas;
	private TableroDisparo tableroDisparo;
	private TableroBarco tableroBarco;
	
	public Jugador() {
		listaArmas = new Integer[4];
		tableroDisparo = new TableroDisparo();
		tableroBarco = new TableroBarco();	
		
	}
	
	public boolean disparar(Integer pX, Integer pY) {
		return false;
	}
	
	public boolean reparar() {
		return false;
	}
	
	public void colocarBarco(Barco pBarco, Coordenada pCoordenada, boolean pDireccion) {
		if(pDireccion) {
			for(int i=0; i<pBarco.getTamano(); i++) {
				tableroBarco.setBarco(new Coordenada(pCoordenada.getX()+i, pCoordenada.getY()), pBarco, pDireccion);
			}
		}
		else {
			for(int i=0; i<pBarco.getTamano(); i++) {
				tableroBarco.setBarco(new Coordenada(pCoordenada.getX(), pCoordenada.getY()+i), pBarco, pDireccion);
			}
		}
	}
	
	public TableroDisparo getTableroDisparo() {
		return tableroDisparo;
	}
	
	public TableroBarco getTableroBarco() {
		return tableroBarco;
	}
	
	public boolean hayBarcoEnZona(Barco pBarco, Coordenada pCoordenada, boolean pDireccion) {
		if(pDireccion)
			return tableroBarco.hayBarcoEnLaZona(pCoordenada, new Coordenada(pCoordenada.getX()+pBarco.getTamano()-1, pCoordenada.getY()));
		return tableroBarco.hayBarcoEnLaZona(pCoordenada, new Coordenada(pCoordenada.getX(), pCoordenada.getY()+pBarco.getTamano()-1));
		
	}
}
