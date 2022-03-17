package HundirLaFlota;


public class Almacen {
	private Almacen mAlmacen;
	private Integer[] listaArmamento;
	
	private Almacen() {
		listaArmamento = new Integer[4];
		listaArmamento[0]=100;
		listaArmamento[1]=100;
		listaArmamento[2]=100;
		listaArmamento[3]=100;		
		mAlmacen = this;
	}
	
	public Almacen getAlmacen() {
		return mAlmacen;
	}

}
