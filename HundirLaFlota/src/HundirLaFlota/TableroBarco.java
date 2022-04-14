package HundirLaFlota;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TableroBarco {
	private Casilla[][] tablero = new Casilla[10][10];
	
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
	
	public boolean hayBarcoEnLaZona(Coordenada pCoordenadaPrimera, Coordenada pCoordenadaUltima) {
		return getStreamCoordenadas(pCoordenadaPrimera, pCoordenadaUltima)
				.allMatch(c -> tablero[c.getX()][c.getY()].getHayBarco());
	}
	
	public boolean hayBarco(Coordenada pCoordenada) {
		return tablero[pCoordenada.getX()][pCoordenada.getY()].getHayBarco();
	}
	
	public void tocarBarco(Barco pBarco, Coordenada pCoordenada) {
		int posicion = pCoordenada.getX() - pBarco.getCoordenadaIncial().getX() + pCoordenada.getY() - pBarco.getCoordenadaIncial().getY();
		pBarco.tocarParte(posicion);
	}
	
	public void setBarco(Coordenada pCoordenada, Barco pBarco, boolean pOrientacion) {
		Coordenada coorUltima;
		if(pOrientacion)
			coorUltima = new Coordenada(pCoordenada.getX(), pCoordenada.getY() + pBarco.getTamano());
		else
			coorUltima = new Coordenada(pCoordenada.getX() + pBarco.getTamano(), pCoordenada.getY());
		if(!hayBarcoEnLaZona(pCoordenada, coorUltima)) {
			for(int i=pCoordenada.getX(); i<=coorUltima.getX(); i++) {
				for(int j=pCoordenada.getY(); j<=coorUltima.getY(); j++) {
					
					tablero[i][j] = new Casilla(new Coordenada(i,j), true, pBarco);
					
				}
			}
		}		
	}
	
	private Stream<Coordenada> getStreamCoordenadas (Coordenada pCoordenadaPrimera, Coordenada pCoordenadaUltima) {
		return IntStream.range(Math.max(0, pCoordenadaPrimera.getX()-1), Math.min(9, pCoordenadaPrimera.getX()+1))
				.mapToObj(x -> IntStream.range(Math.max(0, pCoordenadaPrimera.getY()-1), Math.min(9, pCoordenadaPrimera.getY()+1))
						.mapToObj(y -> new Coordenada(x, y)))
				.flatMap(c -> c); // Para convertir un flujo de flujos de coordenadas en un flujo de coordenadas
	}
}
