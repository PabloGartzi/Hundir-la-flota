package HundirLaFlota;

public class Ordenador extends Jugador {
	
	private static Ordenador mOrdenador = new Ordenador();
	
	private Ordenador() {
		mOrdenador = this;
	}
	
	public static Ordenador getOrdenador() {
		return mOrdenador;
	}

}