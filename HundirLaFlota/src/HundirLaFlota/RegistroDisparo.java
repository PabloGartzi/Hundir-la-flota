package HundirLaFlota;

public class RegistroDisparo {
	private Coordenada coorDisparo;
	private Barco barcoAtacado;
	private boolean tocaBarco;
	private TipoDisparo tipoDeDisparo;
	private boolean finJuego;
	private boolean ganador;
	
	public RegistroDisparo(Coordenada pCoordenada, Barco pBarco, boolean pTocaBarco, TipoDisparo pTipoDeDisparo, boolean pFinJuego, boolean pGanador) {
		setCoorDisparo(pCoordenada);
		setBarcoAtacado(pBarco);
		setTocaBarco(pTocaBarco);
		setTipoDeDisparo(pTipoDeDisparo);
		setFinJuego(pFinJuego);
		setGanador(pGanador);
	}

	public void setGanador(boolean pGanador) {
		this.ganador = pGanador;
	}
	
	public boolean getGanador() {
		return ganador;
	}

	public Coordenada getCoorDisparo() {
		return coorDisparo;
	}

	public void setCoorDisparo(Coordenada coorDisparo) {
		this.coorDisparo = coorDisparo;
	}

	public Barco getBarcoAtacado() {
		return barcoAtacado;
	}

	public void setBarcoAtacado(Barco barcoAtacado) {
		this.barcoAtacado = barcoAtacado;
	}

	public boolean isTocaBarco() {
		return tocaBarco;
	}

	public void setTocaBarco(boolean tocaBarco) {
		this.tocaBarco = tocaBarco;
	}

	public TipoDisparo getTipoDeDisparo() {
		return tipoDeDisparo;
	}

	public void setTipoDeDisparo(TipoDisparo tipoDeDisparo) {
		this.tipoDeDisparo = tipoDeDisparo;
	}

	public boolean isFinJuego() {
		return finJuego;
	}

	public void setFinJuego(boolean finJuego) {
		this.finJuego = finJuego;
	}
	
	

}
