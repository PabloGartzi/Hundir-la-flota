package HundirLaFlota;

public class RegistroDisparo {
	private Coordenada coorDisparo;
	private Barco barcoAtacado;
	private boolean tocaBarco;
	private TipoDisparo tipoDeDisparo;
	private boolean finJuego;
	private boolean ganador;
	private boolean hayEscudo;
	private boolean esEscudo;
	private Radar radar;
	
	//Constructor completo
	public RegistroDisparo(Coordenada pCoordenada, Barco pBarco,
			boolean pTocaBarco, TipoDisparo pTipoDeDisparo, boolean pFinJuego,
			boolean pGanador, boolean pHayEscudo, boolean pEsEscudo, Radar pRadar) {
		
		setCoorDisparo(pCoordenada);
		setBarcoAtacado(pBarco);
		setTocaBarco(pTocaBarco);
		setTipoDeDisparo(pTipoDeDisparo);
		setFinJuego(pFinJuego);
		setGanador(pGanador);
		setHayEscudo(pHayEscudo);
		setEsEscudo(pEsEscudo);
		setRadar(pRadar);
	}
	
	//Constructor cuando dispara
	public RegistroDisparo(Coordenada pCoordenada, Barco pBarco,
			boolean pTocaBarco, TipoDisparo pTipoDeDisparo, boolean pFinJuego,
			boolean pGanador, boolean pHayEscudo) {
		setCoorDisparo(pCoordenada);
		setBarcoAtacado(pBarco);
		setTocaBarco(pTocaBarco);
		setTipoDeDisparo(pTipoDeDisparo);
		setFinJuego(pFinJuego);
		setGanador(pGanador);
		setHayEscudo(pHayEscudo);
		setEsEscudo(false);
		setRadar(null);
	}
	
	//Constructor cuando coloca escudo
	public RegistroDisparo(Coordenada pCoordenada, Barco pBarco) {
		setCoorDisparo(pCoordenada);
		setBarcoAtacado(pBarco);
		setTocaBarco(false);
		setTipoDeDisparo(null);
		setFinJuego(false);
		setGanador(false);
		setHayEscudo(false);
		setEsEscudo(true);
		setRadar(null);
	}
	
	//Constructor cuando usa radar
	public RegistroDisparo(Radar pRadar) {
		
		setCoorDisparo(null);
		setBarcoAtacado(null);
		setTocaBarco(false);
		setTipoDeDisparo(null);
		setFinJuego(false);
		setGanador(false);
		setHayEscudo(false);
		setEsEscudo(false);
		setRadar(pRadar);
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

	public boolean isEsEscudo() {
		return esEscudo;
	}

	public void setEsEscudo(boolean esEscudo) {
		this.esEscudo = esEscudo;
	}

	public Radar getRadar() {
		return radar;
	}

	public void setRadar(Radar radar) {
		this.radar = radar;
	}

	public boolean isHayEscudo() {
		return hayEscudo;
	}

	public void setHayEscudo(boolean hayEscudo) {
		this.hayEscudo = hayEscudo;
	}

}
