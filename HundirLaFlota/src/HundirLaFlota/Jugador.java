package HundirLaFlota;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public abstract class Jugador {
	
	private int dinero;
	private Integer[] listaArmas = {1000, 5, 5, 1};
	private TableroDisparo tableroDisparo;
	private TableroBarco tableroBarco;
	private Jugador jugadorOponente;
	private Random ran = new Random();
	
	private PropertyChangeSupport support;
	
	public Jugador() {
		listaArmas = new Integer[4];
		tableroDisparo = new TableroDisparo();
		tableroBarco = new TableroBarco();	
		support = new PropertyChangeSupport(this);
		dinero = 1000;

	}
	
	public void setOponente(Jugador pJugador) {
		jugadorOponente = pJugador;
	}
	
	public RegistroDisparo disparo(Coordenada pCoordenada, TipoDisparo pDisparo) {
		RegistroDisparo rDisp = null;
		
		if(tableroBarco.hayBarco(pCoordenada)) {
				if(listaArmas[pDisparo.getOrden()] >= 1) {
					tableroDisparo.actuarCasilla(pCoordenada);
					rDisp = tableroBarco.tocarBarco(tableroBarco.getTabla()[pCoordenada.getX()][pCoordenada.getY()].getBarco(), pCoordenada, pDisparo);
					listaArmas[pDisparo.getOrden()] -= 1;
				}
		}else
			rDisp = new RegistroDisparo(pCoordenada, null, false, pDisparo, false, true);
			
		support.firePropertyChange("tableroDisparo", null, rDisp);
		
		return rDisp;
	}
	
	public void prepararDisparo(Coordenada pCoordenada, TipoDisparo pDisparo) {
		RegistroDisparo rDisp;
			if(pDisparo.equals(TipoDisparo.BOMBA) || pDisparo.equals(TipoDisparo.MISIL)) {
				rDisp = jugadorOponente.disparo(pCoordenada, pDisparo);
			}
			else {
				rDisp = jugadorOponente.disparo(pCoordenada, pDisparo);
			}
		support.firePropertyChange("tableroBarco", null, rDisp);
	}
		
	public void reparar(Coordenada pCoordenada) {
		if(this.tableroBarco.hayBarco(pCoordenada) && !this.tableroBarco.getCasilla(pCoordenada).getBarco().getHundido()) {
			this.tableroBarco.getCasilla(pCoordenada).getBarco().reparar();
			support.firePropertyChange("barcoReparado", null, this.tableroBarco.getCasilla(pCoordenada).getBarco());
		}
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
	
	public void addObserver(PropertyChangeListener pList) {
		support.addPropertyChangeListener(pList);
	}
	
	public void colocarBarcosAleatorio(TipoBarco[] pListaTipoBarcos ) {
		for(int i=0; i<pListaTipoBarcos.length; i++) {
			Boolean bool = ran.nextBoolean();
			Coordenada coord = new Coordenada(ran.nextInt(10), ran.nextInt(10));
			
			if(!this.hayBarcoEnZona(pListaTipoBarcos[i], coord, bool) && coordenadasDentro(coord, pListaTipoBarcos[i].getTamano(), bool)) {
				this.colocarBarco(pListaTipoBarcos[i], coord, bool);
				support.firePropertyChange("barcoColocado", null, new Barco( pListaTipoBarcos[i], coord, bool));
			}
			else {
				i -= 1;
			}
		}
		
		System.out.println(this.getClass().getName());
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(this.getTableroBarco().getTabla()[i][j].getHayBarco())
					System.out.print("B");
				else
					System.out.print("0");
			}
			System.out.println("");
			
		}
		
	}
	
	private boolean coordenadasDentro(Coordenada pCoord, int pTamano, boolean pDireccion) {
		if(pDireccion)
			return pCoord.getX()+pTamano-1<=9;
		return pCoord.getY()+pTamano-1<=9;
	}
}
