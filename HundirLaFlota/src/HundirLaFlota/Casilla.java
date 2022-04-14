package HundirLaFlota;

public class Casilla{
	
	private Coordenada coord;
	private boolean hayBarco;
	private Barco barco;
	
	public Casilla(Coordenada pCoordenada, boolean pHayBarco, Barco pBarco) {
		coord = new Coordenada(pCoordenada.getX(), pCoordenada.getY());
		hayBarco = pHayBarco;
		barco = pBarco;
	}
	public Coordenada getCoordenada() {
		return coord;
	}
	
	public boolean getHayBarco() {
		return hayBarco;
	}
	
	public Barco getBarco() {
		return barco;
	}
	
	public void setBarco(Barco nBarco) {
		barco = nBarco;
		hayBarco = true;
	}
}
