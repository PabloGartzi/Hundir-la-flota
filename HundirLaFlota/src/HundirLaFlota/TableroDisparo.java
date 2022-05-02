package HundirLaFlota;

public class TableroDisparo {
	
	private boolean[][] tablaDisparos;
	
	public TableroDisparo() {
		tablaDisparos = new boolean[10][10];
				
	}
	
	public void disparoAgua(Coordenada pCoordenada) {
		
	}
	
	public void disparoBarco(Coordenada pCoordenada) {
		
	}
	
	public boolean estaRepetido(Coordenada pCoordenada) {
		return false;
	}
	
	public void actuarCasilla(Coordenada pCoordenada) {
		tablaDisparos[pCoordenada.getX()][pCoordenada.getY()]=true;
	}
	
	public boolean quedanBarcos() {
		return false;
	}
	
	
}
