package HundirLaFlota;


public class Juego {
	private static Juego mJuego = new Juego();
	public Humano humanoJ;
	public Ordenador ordenadorJ;
	private TipoBarco[] listaTiposBarco = { TipoBarco.PORTAAVIONES, TipoBarco.SUBMARINO, TipoBarco.SUBMARINO, TipoBarco.DESTRUCTOR, TipoBarco.DESTRUCTOR, TipoBarco.DESTRUCTOR, TipoBarco.FRAGATA, TipoBarco.FRAGATA, TipoBarco.FRAGATA, TipoBarco.FRAGATA};
	
	private Juego() {
		mJuego = this;
	}
	public static Juego getMJuego() {
		return mJuego;
	}
	
	public void act() {
		
	}
	public void inicializar() {
		humanoJ = crearHumano();
		ordenadorJ = crearOrdenador();	
		VentanaInicial vI = new VentanaInicial();
		vI.setVisible(true);
	}
	
	private Humano crearHumano() {
		Humano jugadorH = Humano.getHumano();
		return jugadorH;
	}
	
	private Ordenador crearOrdenador() {
		Ordenador jugadorO = Ordenador.getOrdenador();
		return jugadorO;
	}
	
	public TipoBarco[] getTiposBarco() {
		return listaTiposBarco;
	}
}
