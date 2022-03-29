package HundirLaFlota;

public class TableroBarco {
	private Casilla[][] tablero = new Casilla[10][10];
	
	public TableroBarco() {
		super();
		
	}
	public Casilla[][] getTabla() {
		return tablero;
	}
	public boolean hayBarco() {
		return false;
	}
	public void tocarBarco(Barco pBarco) {
		
	}
	

	public void setBarco(Coordenada pCoordenada) {
		Casilla casilla = new Casilla(pCoordenada, true);
		tablero[pCoordenada.getX()][pCoordenada.getY()] = casilla;
	}
}
