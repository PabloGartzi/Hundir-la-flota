package HundirLaFlota;

import java.util.ArrayList;

public class Almacen {
	private Almacen mAlmacen;
	private ArrayList<Integer> listaArmamento;
	
	private Almacen() {
		listaArmamento = new ArrayList<Integer>(4);
		listaArmamento.set(0, 100);
		listaArmamento.set(1, 50);
		listaArmamento.set(2, 100);
		listaArmamento.set(3, 100);
		listaArmamento.set(4, 100);
		
		mAlmacen = this;
	}
	
	public Almacen getAlmacen() {
		return mAlmacen;
	}

}
