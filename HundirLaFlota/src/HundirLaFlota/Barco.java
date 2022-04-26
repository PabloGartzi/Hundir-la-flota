
package HundirLaFlota;

public class Barco {
	private int tamano;
	private int turnosEscudo;
	private boolean hundido;
	private boolean[] partesBarco;
	private TipoBarco tipo;
	private Coordenada coordenadaInicial;
	private boolean orientacion;
	
	public Barco(TipoBarco pTipo, Coordenada pCoordenada, boolean pOrientacion) {
		tipo = pTipo;
		orientacion = pOrientacion;
		coordenadaInicial = pCoordenada;
		tamano = pTipo.getTamano();
		hundido = false;
		partesBarco = new boolean[tamano];
		for(int i=0; i<tamano; i++) {
			partesBarco[i]=false;
		}
	}
	
	public boolean getOrientacion() {
		return orientacion;
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
	
	public void setHundido() {
		hundido = true;
		
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
		int i=0;
		for(boolean b: partesBarco) {
			if(b)
				i++;
			if(i==tamano)
				setHundido();
			}
		}
	}
