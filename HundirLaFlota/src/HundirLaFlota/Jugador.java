package HundirLaFlota;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public abstract class Jugador {
	
	private int dinero;
	private Integer[] listaArmas;
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
		
	}
	
	public void setOponente(Jugador pJugador) {
		jugadorOponente = pJugador;
	}
	
	public boolean[] disparo(Coordenada pCoordenada, TipoDisparo pDisparo) {
		boolean finJuego = false;
		boolean acierto = false;
		
		if(tableroBarco.hayBarco(pCoordenada)) {
			switch(pDisparo) {
			case BOMBA:
				tableroDisparo.actuarCasilla(pCoordenada);
				finJuego = tableroBarco.tocarBarco(tableroBarco.getTabla()[pCoordenada.getX()][pCoordenada.getY()].getBarco(), pCoordenada, TipoDisparo.BOMBA);
				acierto = true;
				break;
			
			case MISIL:
				tableroDisparo.actuarCasilla(pCoordenada);
				finJuego = tableroBarco.tocarBarco(tableroBarco.getTabla()[pCoordenada.getX()][pCoordenada.getY()].getBarco(), pCoordenada, TipoDisparo.MISIL);
				acierto = true;
				break;
			}
		}
		boolean[] listBool = {acierto, finJuego};
		
		support.firePropertyChange("tableroDisparo", pCoordenada, listBool);
		
		return listBool;
	}
	
	public void prepararDisparo(Coordenada pCoordenada, TipoDisparo pDisparo) {
		boolean[] listBool = new boolean[2];
			if(pDisparo.equals(TipoDisparo.BOMBA) || pDisparo.equals(TipoDisparo.MISIL)) {
				listBool = jugadorOponente.disparo(pCoordenada, pDisparo);
			}
			else {
				listBool = jugadorOponente.disparo(pCoordenada, pDisparo);
			}
		support.firePropertyChange("tableroBarco", pCoordenada, listBool);
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
