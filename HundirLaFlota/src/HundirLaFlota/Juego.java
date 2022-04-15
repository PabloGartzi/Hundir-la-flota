package HundirLaFlota;

public class Juego {
	private Juego mJuego;
	public Humano humanoJ;
	public Ordenador ordenadorJ;
	
	private Juego() {
		
	}
	public Juego getMJuego() {
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
	
}
