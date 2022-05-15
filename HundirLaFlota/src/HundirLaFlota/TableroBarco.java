package HundirLaFlota;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TableroBarco {
	private Casilla[][] tablero = new Casilla[10][10];
	private ArrayList<Barco> barcosHundidos = new ArrayList<>();
	private Radar radar = new Radar();
	
	public TableroBarco() {
		for(int i=0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				tablero[i][j] = new Casilla(new Coordenada(i,j), false, null);
			}
		}
				
	}
	
	public Casilla[][] getTabla() {
		return tablero;
	}
	
	public Casilla getCasilla(Coordenada pCoordenada) {
		return tablero[pCoordenada.getX()][pCoordenada.getY()];
	}
	public boolean hayBarcoEnLaZona(Coordenada pCoordenadaPrimera, Coordenada pCoordenadaUltima) {
		return getStreamCoordenadas(pCoordenadaPrimera, pCoordenadaUltima)
				.anyMatch(c -> tablero[c.getX()][c.getY()].getHayBarco());
	}
	
	public boolean hayBarco(Coordenada pCoordenada) {
		return tablero[pCoordenada.getX()][pCoordenada.getY()].getHayBarco();
	}
	
	public RegistroDisparo accion(Coordenada pCoordenada, TipoDisparo pDisparo) {
		RegistroDisparo rDisp = null;
		
		switch(pDisparo) {
			case BOMBA:
				if(hayBarco(pCoordenada)) 
					rDisp = disparoBomba(tablero[pCoordenada.getX()][pCoordenada.getY()].getBarco(), pCoordenada);
				else
					rDisp = generarRegistroDisparo(pCoordenada, null, false, pDisparo, false);
				break;
				
			case MISIL:
				if(hayBarco(pCoordenada)) 
					rDisp = disparoMisil(tablero[pCoordenada.getX()][pCoordenada.getY()].getBarco(), pCoordenada);
				else
					rDisp = generarRegistroDisparo(pCoordenada, null, false, pDisparo, false);
				break;
				
			case ESCUDO:
				if(hayBarco(pCoordenada))
					rDisp = accionEscudo(tablero[pCoordenada.getX()][pCoordenada.getY()].getBarco(), pCoordenada);
				else
					rDisp = generarRegistroDisparoEscudo(pCoordenada, null);
				break;
			case RADAR:
					rDisp = accionRadar(this);
				break;
		}
							
		return rDisp;
	}
	
	//Disparos y acciones 
	
	private RegistroDisparo disparoBomba(Barco pBarco, Coordenada pCoordenada) {
		if(pBarco.getTurnosEscudo() == 0) {
			int posicion = pCoordenada.getX() - pBarco.getCoordenadaIncial().getX() + pCoordenada.getY() - pBarco.getCoordenadaIncial().getY();
			pBarco.tocarParte(posicion);
			if(pBarco.getHundido() && !barcosHundidos.contains(pBarco))
				barcosHundidos.add(pBarco);
			return generarRegistroDisparo(pCoordenada, pBarco, true, TipoDisparo.BOMBA, false);
		}
		else {
			pBarco.setTurnosEscudo(pBarco.getTurnosEscudo()-1);
			return generarRegistroDisparo(pCoordenada, pBarco, true, TipoDisparo.BOMBA, true);
		}
		
	}
	
	private RegistroDisparo disparoMisil(Barco pBarco, Coordenada pCoordenada) {
		if(pBarco.getTurnosEscudo() == 0) {
			pBarco.setHundido();
			for(int i=0; i<pBarco.getTamano(); i++) {
				pBarco.tocarParte(i);
			}
			if(!barcosHundidos.contains(pBarco))
				barcosHundidos.add(pBarco);
			return generarRegistroDisparo(pCoordenada, pBarco, true, TipoDisparo.MISIL, false);
		}
		else {
			pBarco.setTurnosEscudo(pBarco.getTurnosEscudo()-1);
			return generarRegistroDisparo(pCoordenada, pBarco, true, TipoDisparo.MISIL, true);
		}
	}
	
	private RegistroDisparo accionEscudo(Barco pBarco, Coordenada pCoordenada) {
		pBarco.setTurnosEscudo(1);
		return generarRegistroDisparoEscudo(pCoordenada, pBarco);
	}
	
	private RegistroDisparo accionRadar(TableroBarco pTablero) {
		radar.usarRadar(pTablero);
		return generarRegistroDisparoRadar(this.radar);
	}
	
	//Creación del Resgitro de Disparo
	
	private RegistroDisparo generarRegistroDisparo(Coordenada pCoordenada, Barco pBarco, boolean pBarcoTocado, TipoDisparo pDisparo, boolean pTocaEscudo) {
		RegistroDisparo rDisp = new RegistroDisparo(pCoordenada, pBarco, pBarcoTocado, pDisparo, false, true, pTocaEscudo);
		
		if(barcosHundidos.size()==10) {
			rDisp.setFinJuego(true);
			if(this.getClass().equals(Humano.getHumano().getClass()))
				rDisp.setGanador(false);
			return rDisp;
			}
		return rDisp;
	}
	
	private RegistroDisparo generarRegistroDisparoEscudo(Coordenada pCoordenada, Barco pBarco) {
		return new RegistroDisparo(pCoordenada, pBarco);
	}
	
	private RegistroDisparo generarRegistroDisparoRadar(Radar pRadar) {
		return new RegistroDisparo(this.radar);
	}
	
	public void setBarco(Coordenada pCoordenada, Barco pBarco, boolean pOrientacion) {
		Coordenada coorUltima;
		if(pOrientacion)
			coorUltima = new Coordenada(Math.max(pCoordenada.getX() + pBarco.getTamano()-1, 0), pCoordenada.getY() );
		else
			coorUltima = new Coordenada(pCoordenada.getX(), Math.min(pCoordenada.getY() + pBarco.getTamano()-1, 9));
		if(!hayBarcoEnLaZona(pCoordenada, coorUltima)) {
			for(int i=pCoordenada.getX(); i<=coorUltima.getX(); i++) {
				for(int j=pCoordenada.getY(); j<=coorUltima.getY(); j++) {
					
					tablero[i][j] = new Casilla(new Coordenada(i,j), true, pBarco);
					
				}
			}
		}		
	}
	
	public Stream<Coordenada> getStreamCoordenadas (Coordenada pCoordenadaPrimera, Coordenada pCoordenadaUltima) {
		return IntStream.rangeClosed(Math.max(0, pCoordenadaPrimera.getX()-1), Math.min(9, pCoordenadaUltima.getX()+1))
				.mapToObj(x -> IntStream.rangeClosed(Math.max(0, pCoordenadaPrimera.getY()-1), Math.min(9, pCoordenadaUltima.getY()+1))
						.mapToObj(y -> new Coordenada(x, y)))
				.flatMap(c -> c); // Para convertir un flujo de flujos de coordenadas en un flujo de coordenadas
	}
}
