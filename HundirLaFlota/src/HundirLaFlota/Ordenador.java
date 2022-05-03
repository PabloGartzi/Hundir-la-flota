package HundirLaFlota;

import java.util.Random;

public class Ordenador extends Jugador {
	
	private static Ordenador mOrdenador = new Ordenador();
	private Random ran = new Random();
	
	private Ordenador() {
		mOrdenador = this;
	}
	
	public static Ordenador getOrdenador() {
		return mOrdenador;
	}

	public void disparar() {
		this.prepararDisparo(new Coordenada(ran.nextInt(10), ran.nextInt(10)), TipoDisparo.BOMBA);
		
	}
	
}