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
	
	public boolean[] prepararDisparo(Coordenada pCoordenada, TipoDisparo pDisparo) {
		boolean[] listBool = new boolean[2];
		if(this.getClass().equals(Humano.getHumano().getClass())) {
			if(pDisparo.equals(TipoDisparo.BOMBA) || pDisparo.equals(TipoDisparo.MISIL)) {
				listBool = this.tableroDisparo.disparo(pCoordenada, Ordenador.getOrdenador().getTableroBarco(), pDisparo);
			}
			else {
				listBool = this.tableroDisparo.disparo(pCoordenada, this.getTableroBarco(), pDisparo);
			}
		}
		else {
			
		}
		return listBool;
	}
	
	
	
	public boolean reparar() {
		return false;
	}
	
	public void colocarBarco(TipoBarco pTipoBarco, Coordenada pCoordenada, boolean pDireccion) {
		Barco barcoColocando = new Barco(pTipoBarco, pCoordenada, pDireccion);
		if(pDireccion) {
			for(int i=0; i<barcoColocando.getTamano(); i++) {
				tableroBarco.setBarco(new Coordenada(pCoordenada.getX()+i, pCoordenada.getY()), barcoColocando, pDireccion);
			}
		}
		else {
			for(int i=0; i<barcoColocando.getTamano(); i++) {
				tableroBarco.setBarco(new Coordenada(pCoordenada.getX(), pCoordenada.getY()+i), barcoColocando, pDireccion);
			}
		}
	}
	
	public TableroDisparo getTableroDisparo() {
		return tableroDisparo;
	}
	
	public TableroBarco getTableroBarco() {
		return tableroBarco;
	}
	
	public boolean hayBarcoEnZona(TipoBarco pTipoBarco, Coordenada pCoordenada, boolean pDireccion) {
		if(pDireccion)
			return tableroBarco.hayBarcoEnLaZona(pCoordenada, new Coordenada(pCoordenada.getX()+pTipoBarco.getTamano()-1, pCoordenada.getY()));
		return tableroBarco.hayBarcoEnLaZona(pCoordenada, new Coordenada(pCoordenada.getX(), pCoordenada.getY()+pTipoBarco.getTamano()-1));
		
	}
}
