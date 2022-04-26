package HundirLaFlota;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TableroBarco {
	private Casilla[][] tablero = new Casilla[10][10];
	private ArrayList<Barco> barcosHundidos = new ArrayList<>();
	
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
	
	public boolean tocarBarco(Barco pBarco, Coordenada pCoordenada, TipoDisparo pDisparo) {
		switch(pDisparo) {
			case BOMBA:
				int posicion = pCoordenada.getX() - pBarco.getCoordenadaIncial().getX() + pCoordenada.getY() - pBarco.getCoordenadaIncial().getY();
				pBarco.tocarParte(posicion);
			case MISIL:
				pBarco.setHundido();
				for(int i=0; i<pBarco.getTamano(); i++) {
					pBarco.tocarParte(i);
				}	
		}
		if(pBarco.getHundido())
			barcosHundidos.add(pBarco);
		
		if(barcosHundidos.size()==10)
			return true;
		return false;
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
	
	private Stream<Coordenada> getStreamCoordenadas (Coordenada pCoordenadaPrimera, Coordenada pCoordenadaUltima) {
		return IntStream.rangeClosed(Math.max(0, pCoordenadaPrimera.getX()-1), Math.min(9, pCoordenadaUltima.getX()+1))
				.mapToObj(x -> IntStream.rangeClosed(Math.max(0, pCoordenadaPrimera.getY()-1), Math.min(9, pCoordenadaUltima.getY()+1))
						.mapToObj(y -> new Coordenada(x, y)))
				.flatMap(c -> c); // Para convertir un flujo de flujos de coordenadas en un flujo de coordenadas
	}
}
