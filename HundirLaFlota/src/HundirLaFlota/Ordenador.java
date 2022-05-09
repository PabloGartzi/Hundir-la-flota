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
		boolean tDis = ran.nextBoolean();
		if(tDis)
			this.prepararDisparo(new Coordenada(ran.nextInt(10), ran.nextInt(10)), TipoDisparo.BOMBA);
		else
			this.prepararDisparo(new Coordenada(ran.nextInt(10), ran.nextInt(10)), TipoDisparo.MISIL);

	}
	
}