package HundirLaFlota;

public class TableroBarco {
	private Casilla[] tabla;
	
	public TableroBarco() {
		tabla = new boolean[10][10];
		
		
	}
	public Casilla[] getTabla() {
		return tabla;
	}
	public boolean hayBarco(Casilla pCasilla) {
		
		return false;
	}
	public void tocarBarco(Barco pBarco) {
		
	}

	
}
