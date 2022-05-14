package HundirLaFlota;

//Es un Singleton
public class Juego {
	private static Juego mJuego = new Juego();
	public static Humano humanoJ;
	public static Ordenador ordenadorJ;
	private TipoBarco[] listaTiposBarco = { TipoBarco.PORTAAVIONES, TipoBarco.SUBMARINO, TipoBarco.SUBMARINO, TipoBarco.DESTRUCTOR, TipoBarco.DESTRUCTOR, TipoBarco.DESTRUCTOR, TipoBarco.FRAGATA, TipoBarco.FRAGATA, TipoBarco.FRAGATA, TipoBarco.FRAGATA};
	
	//Main para iniciar el juego
	public static void main(String[] args) {
		inicializar();
	}
	
	private Juego() {
		mJuego = this;
	}
	
	public static Juego getMJuego() {
		return mJuego;
	}
	
	//Creo al jugador humano y al ordenador y añado a ambos como el jugador oponente del otro
	public static void inicializar() {
		humanoJ = crearHumano();
		ordenadorJ = crearOrdenador();	
		humanoJ.setOponente(ordenadorJ);
		ordenadorJ.setOponente(humanoJ);
		VentanaInicial vI = new VentanaInicial();
		vI.setVisible(true);
	}
	
	private static Humano crearHumano() {
		Humano jugadorH = Humano.getHumano();
		return jugadorH;
	}
	
	private static Ordenador crearOrdenador() {
		Ordenador jugadorO = Ordenador.getOrdenador();
		return jugadorO;
	}
	
	public TipoBarco[] getTiposBarco() {
		return listaTiposBarco;
	}
}
