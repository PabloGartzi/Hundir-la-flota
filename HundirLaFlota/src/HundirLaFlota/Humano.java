package HundirLaFlota;

public class Humano extends Jugador {
	
	private static Humano mHumano = new Humano();
	
	private Humano() {
		mHumano = this;
	}
	
	public static Humano getHumano() {
		return mHumano;
	}

}
