package HundirLaFlota;

public class Humano extends Jugador {
	
	private static Humano mHumano = new Humano();
	
	private Humano() {
	}
	
	public static Humano getHumano() {
		return mHumano;
	}

	@Override
	public void prepararAccion(Coordenada pCoordenada, TipoDisparo pDisparo) {
		// TODO Auto-generated method stub
		super.prepararAccion(pCoordenada, pDisparo);
	}
}
