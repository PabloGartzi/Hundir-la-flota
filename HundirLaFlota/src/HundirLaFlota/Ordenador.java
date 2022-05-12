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
		boolean compraOReparar = ran.nextBoolean();
		if(compraOReparar) {
			this.reparar(new Coordenada(ran.nextInt(10), ran.nextInt(10)));
		}
		int tDis = ran.nextInt(2);
		
		while(this.listaArmas[tDis] == 0) {
			tDis = ran.nextInt(2);
		}
		
		switch (tDis) {
			case 0:
				this.prepararDisparo(new Coordenada(ran.nextInt(10), ran.nextInt(10)), TipoDisparo.BOMBA);
				break;
			case 1:
				this.prepararDisparo(new Coordenada(ran.nextInt(10), ran.nextInt(10)), TipoDisparo.MISIL);
				break;
			case 2:
				this.prepararDisparo(new Coordenada(ran.nextInt(10), ran.nextInt(10)), TipoDisparo.ESCUDO);
				break;
			case 3:
				this.prepararDisparo(new Coordenada(ran.nextInt(10), ran.nextInt(10)), TipoDisparo.RADAR);
				break;
		}

	}
	
}