package HundirLaFlota;

public record Casilla(Coordenada pCoordenada, boolean pEstado) {
	public Coordenada getCoordenada() {
		return pCoordenada;
	}
	
	public boolean getEstado() {
		return pEstado;
	}

}
