package HundirLaFlota;

public class TableroDisparo {
	
	private boolean[][] tablaDisparos;
	
	public TableroDisparo() {
		tablaDisparos = new boolean[10][10];
		for(int i=0; i<10;i++) {
			for(int j=0; j<10;j++) {
				tablaDisparos[i][j] = false;
			}
		}
				
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
	
	public boolean getCasilla(Coordenada pCoordenada) {
		return tablaDisparos[pCoordenada.getX()][pCoordenada.getY()];
	}
	
}
