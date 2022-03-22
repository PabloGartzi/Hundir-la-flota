package HundirLaFlota;

public class Ordenador extends Jugador {
	
	private Ordenador mOrdenador;
	
	private Ordenador() {
		mOrdenador = this;
	}
	
	public Ordenador getHumano() {
		return mOrdenador;
	}

}