
package HundirLaFlota;

public class Barco {
	private int tamano;
	private int turnosEscudo;
	private boolean hundido;
	private boolean[] partesBarco;
	private TipoBarco tipo;
	private Coordenada coordenadaInicial;
	
	public Barco(TipoBarco pTipo, Coordenada pCoordenada) {
		tipo = pTipo;
		coordenadaInicial = pCoordenada;
		tamano = pTipo.getTamano();
		hundido = false;
		partesBarco = new boolean[tamano];
		for(int i=0; i<tamano; i++) {
			partesBarco[i]=false;
		}
	}
	
	public TipoBarco getTipoBarco() {
		return tipo;
	}
	
	public Coordenada getCoordenadaIncial() {
		return coordenadaInicial;
	}

	public boolean getHundido() {
		return hundido;
	}
	
	public void setHundido(boolean pHundido) {
		hundido=pHundido;
	}
	
	public void reparar() {
		for (int i=0; i<partesBarco.length; i++) {
			if (partesBarco[i]==true){
				partesBarco[i]=false;
			}
		}
	}
	
	public int getTamano() {
		return tamano;
	}
	
	public void tocarParte(int pParte) {
		partesBarco[pParte] = true;
		
		for(boolean b: partesBarco) {
			if(b)
				hundido = true;
			else {
				hundido = false;
				break;
			}
		}
	}
}