package HundirLaFlota;

public enum TipoDisparo {
	BOMBA(0, 0), MISIL(1, 70), ESCUDO(2, 100), RADAR(3, 200);
	
	private final int ordenArma;
	private final int precio;
	
	
	private TipoDisparo(int pOrden, int pPrecio) {
		this.ordenArma = pOrden;
		this.precio = pPrecio;
	}
	
	public int getOrden() {
		return this.ordenArma;
	}
	
	public int getPrecio() {
		return this.precio;
	}
}
