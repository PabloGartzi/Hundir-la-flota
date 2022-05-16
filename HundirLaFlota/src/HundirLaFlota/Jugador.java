package HundirLaFlota;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public abstract class Jugador {
	
	private int dinero;
	protected Integer[] listaArmas = {1000, 5, 1, 1};
	private TableroBarco tableroBarco;
	private Jugador jugadorOponente;
	private Random ran = new Random();
	private Almacen almacen;
	
	private PropertyChangeSupport support;
	
	public Jugador() {
		tableroBarco = new TableroBarco();	
		support = new PropertyChangeSupport(this);
		dinero = 1000;
	}
	
	public void setOponente(Jugador pJugador) {
		jugadorOponente = pJugador;
	}
	
	public void setAlmacen(Almacen pAlmacen) {
		almacen = pAlmacen;
	}
	
	public void comprar(TipoDisparo pDisparo) {
		listaArmas[pDisparo.getOrden()] += 1;
		dinero -= pDisparo.getPrecio();
		almacen.comprar(pDisparo.getOrden());
		support.firePropertyChange("compra", (Integer) dinero, (Integer) listaArmas[pDisparo.getOrden()]);
	}
	
	public RegistroDisparo accion(Coordenada pCoordenada, TipoDisparo pDisparo) {
		RegistroDisparo rDisp = null;
		
		rDisp = tableroBarco.accion(pCoordenada, pDisparo);
		switch (pDisparo) {
			case BOMBA:
			case MISIL:
				support.firePropertyChange("tableroDisparo", listaArmas[pDisparo.getOrden()], rDisp);
				break;
			case ESCUDO:
				support.firePropertyChange("escudo", listaArmas[pDisparo.getOrden()], rDisp);
				break;		
			case RADAR:
				support.firePropertyChange("radar", listaArmas[pDisparo.getOrden()], rDisp);
				break;			
		}
		
		return rDisp;
	}
	
	public void prepararAccion(Coordenada pCoordenada, TipoDisparo pDisparo) {
		RegistroDisparo rDisp;
		if(this.listaArmas[pDisparo.getOrden()] >= 1) {
			this.listaArmas[pDisparo.getOrden()] -= 1;
			switch (pDisparo) {
				case BOMBA:
				case MISIL:
					rDisp = jugadorOponente.accion(pCoordenada, pDisparo);
					support.firePropertyChange("tableroBarco", listaArmas[pDisparo.getOrden()], rDisp);
					break;
				case ESCUDO:
					this.accion(pCoordenada, pDisparo);
					break;		
				case RADAR:
					rDisp = jugadorOponente.accion(pCoordenada, pDisparo);
					support.firePropertyChange("radar", listaArmas[pDisparo.getOrden()], rDisp);
					break;	
			}		
		}
		else 
			support.firePropertyChange("noQuedaMunicion", null, null);	
			
	}

		
	public void reparar(Coordenada pCoordenada) {
		if(this.tableroBarco.hayBarco(pCoordenada) && !this.tableroBarco.getCasilla(pCoordenada).getBarco().getHundido()) {
			this.tableroBarco.getCasilla(pCoordenada).getBarco().reparar();
			dinero -= 100;
			support.firePropertyChange("barcoReparado", dinero, this.tableroBarco.getCasilla(pCoordenada).getBarco());
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
		imprimirBarcos();
	}
	
	private boolean coordenadasDentro(Coordenada pCoord, int pTamano, boolean pDireccion) {
		if(pDireccion)
			return pCoord.getX()+pTamano-1<=9;
		return pCoord.getY()+pTamano-1<=9;
	}
	
	private void imprimirBarcos() {
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
}

