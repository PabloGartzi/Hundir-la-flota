package HundirLaFlota;

public class TableroDisparo {
	
	private boolean[][] tablaDisparos;
	
	public TableroDisparo() {
		tablaDisparos = new boolean[10][10];
				
	}
	
	public boolean disparo(Coordenada pCoordenada, TableroBarco pTableroBarco) {
		if(pTableroBarco.hayBarco(pCoordenada)) {
			tablaDisparos[pCoordenada.getX()][pCoordenada.getY()] = true;
			pTableroBarco.tocarBarco(pTableroBarco.getTabla()[pCoordenada.getX()][pCoordenada.getY()].getBarco(), pCoordenada);
			return true;
		}
		return false;
	}
	
	public void disparoAgua(Coordenada pCoordenada) {
		
	}
	
	public void disparoBarco(Coordenada pCoordenada) {
		
	}
	
	public boolean estaRepetido(Coordenada pCoordenada) {
		return false;
	}
	
	public void actuarCasilla(Coordenada pCoordenada) {
		
	}
	
	public boolean quedanBarcos() {
		return false;
	}
	
}
