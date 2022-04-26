package HundirLaFlota;

public class TableroDisparo {
	
	private boolean[][] tablaDisparos;
	
	public TableroDisparo() {
		tablaDisparos = new boolean[10][10];
				
	}
	
	public boolean[] disparo(Coordenada pCoordenada, TableroBarco pTableroBarco, TipoDisparo pDisparo) {
		boolean finJuego = false;
		boolean acierto = false;
		boolean[] listBool = {acierto, finJuego};
		if(pTableroBarco.hayBarco(pCoordenada)) {
			switch(pDisparo) {
			case BOMBA:
				tablaDisparos[pCoordenada.getX()][pCoordenada.getY()] = true;
				finJuego = pTableroBarco.tocarBarco(pTableroBarco.getTabla()[pCoordenada.getX()][pCoordenada.getY()].getBarco(), pCoordenada, TipoDisparo.BOMBA);
				acierto = true;
			
			case MISIL:
				tablaDisparos[pCoordenada.getX()][pCoordenada.getY()] = true;
				finJuego = pTableroBarco.tocarBarco(pTableroBarco.getTabla()[pCoordenada.getX()][pCoordenada.getY()].getBarco(), pCoordenada, TipoDisparo.MISIL);
				acierto = true;
			
			}
			
		}
		return listBool;
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
