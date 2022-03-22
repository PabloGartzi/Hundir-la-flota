
package HundirLaFlota;

public class Barco {
	private int tamano;
	private int turnosEscudo;
	private boolean hundido;
	private boolean[] partesBarco;
	private TipoBarco tipo;
	
	public TipoBarco getTipoBarco() {
		return tipo;
	}
	
	private void setTipoBarco(TipoBarco pTipo) {
		tipo=pTipo;
	}
	
	private boolean getHundido() {
		return hundido;
	}
	
	private void setHundido(boolean pHundido) {
		hundido=pHundido;
	}
	
	public void reparar() {
		for (int i=0; i<partesBarco.length; i++) {
			if (partesBarco[i]==true){
				partesBarco[i]=false;
			}
		}
	}
	
	public boolean[] getPartesBarco(){
		return partesBarco;
	}
	
	public void setPartesBarco (boolean[] pPartesBarco) {
		partesBarco=pPartesBarco;
	}
}