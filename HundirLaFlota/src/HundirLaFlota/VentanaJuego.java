package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;

public class VentanaJuego extends JFrame implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup botonesTableroDisparo = new ButtonGroup();
	private final ButtonGroup botonesTableroBarcos = new ButtonGroup();
	private final ButtonGroup botonesCompra = new ButtonGroup();
	private final ButtonGroup botonesAccion = new ButtonGroup();

	private HashMap<ButtonModel, Coordenada> botonesModeloACoordenada;
	private HashMap<Coordenada, JCheckBox> botonesCoordenadaABotonPanelIzq;
	private HashMap<Coordenada, JCheckBox> botonesCoordenadaABotonPanelDch;
	private HashMap<ButtonModel, JCheckBox> botonesModeloABoton;
	private HashMap<ButtonModel, TipoDisparo> botonesModeloABotonAccion;
	private HashMap<TipoDisparo, JRadioButton> botonesTipoDisparoABotonAccion;
	private HashMap<ButtonModel, TipoDisparo> botonesModeloACompra;
	private Humano jHumano = Humano.getHumano();
	private Ordenador jOrdenador = Ordenador.getOrdenador();
	
	private JTextPane txtpnDinero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaJuego() {
		botonesModeloACoordenada = new HashMap<>();
		botonesCoordenadaABotonPanelIzq = new HashMap<>();
		botonesCoordenadaABotonPanelDch = new HashMap<>();
		botonesModeloABoton = new HashMap<>();
		botonesModeloABotonAccion = new HashMap<>();
		botonesModeloACompra = new HashMap<>();
		botonesTipoDisparoABotonAccion = new HashMap<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(5, 0, 0, 0));
		
		JRadioButton rdbtnBomba = new JRadioButton("BOMBA (0€)");
		botonesCompra.add(rdbtnBomba);
		botonesModeloACompra.put(rdbtnBomba.getModel(), TipoDisparo.BOMBA);
		panel_7.add(rdbtnBomba);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("MISIL (70€)");
		botonesCompra.add(rdbtnNewRadioButton);
		botonesModeloACompra.put(rdbtnNewRadioButton.getModel(), TipoDisparo.MISIL);
		panel_7.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("RADAR (200€)");
		botonesCompra.add(rdbtnNewRadioButton_2);
		botonesModeloACompra.put(rdbtnNewRadioButton_2.getModel(), TipoDisparo.RADAR);
		
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ESCUDO (100€)");
				botonesCompra.add(rdbtnNewRadioButton_1);
				botonesModeloACompra.put(rdbtnNewRadioButton_1.getModel(), TipoDisparo.ESCUDO);
				panel_7.add(rdbtnNewRadioButton_1);
		panel_7.add(rdbtnNewRadioButton_2);

		JButton btnNewButton_3 = new JButton("COMPRAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprar();
			}
		});
		panel_7.add(btnNewButton_3);

		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		
		txtpnDinero = new JTextPane();
		txtpnDinero.setText("Dinero : 1000€");
		panel_8.add(txtpnDinero);

		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);

		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(new GridLayout(6, 0, 0, 0));

		JTextPane txtpnArmas = new JTextPane();
		txtpnArmas.setEditable(false);
		txtpnArmas.setText("HERRAMIENTAS");
		panel_10.add(txtpnArmas);

		JRadioButton botonBomba = new JRadioButton("BOMBA (1000)");
		botonesAccion.add(botonBomba);
		botonesModeloABotonAccion.put(botonBomba.getModel(), TipoDisparo.BOMBA);
		botonesTipoDisparoABotonAccion.put(TipoDisparo.BOMBA, botonBomba);
		panel_10.add(botonBomba);

		JRadioButton botonMisil = new JRadioButton("MISIL (5)");
		botonesAccion.add(botonMisil);
		botonesModeloABotonAccion.put(botonMisil.getModel(), TipoDisparo.MISIL);
		botonesTipoDisparoABotonAccion.put(TipoDisparo.MISIL, botonMisil);
		panel_10.add(botonMisil);

		JRadioButton botonRadar = new JRadioButton("RADAR (1)");
		botonesAccion.add(botonRadar);
		botonesModeloABotonAccion.put(botonRadar.getModel(), TipoDisparo.RADAR);
		botonesTipoDisparoABotonAccion.put(TipoDisparo.RADAR, botonRadar);
		panel_10.add(botonRadar);
		
		JRadioButton botonEscudo = new JRadioButton("ESCUDO (1)");
		botonesAccion.add(botonEscudo);
		botonesModeloABotonAccion.put(botonEscudo.getModel(), TipoDisparo.ESCUDO);
		botonesTipoDisparoABotonAccion.put(TipoDisparo.ESCUDO, botonEscudo);
		panel_10.add(botonEscudo);
		

		JButton btnNewButton_4 = new JButton("Acción");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accion();
			}
		});
		panel_10.add(btnNewButton_4);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("Reparar 100€");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reparar();
			}
		});
		panel_3.add(btnNewButton_1);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 2, 10, 0));

		JPanel panel_4_1 = new JPanel();
		panel_4.add(panel_4_1);
		panel_4_1.setLayout(new GridLayout(10, 10, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(10, 10, 0, 0));

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JCheckBox botonBarco = new JCheckBox();
				if (i % 2 != 0 && j % 2 != 0 || i % 2 == 0 && j % 2 == 0)
					botonBarco.setBackground(Color.GRAY);
				else
					botonBarco.setBackground(Color.LIGHT_GRAY);

				anadirBotones(botonBarco, i, j);
				panel_4_1.add(botonBarco);
				
				botonesTableroBarcos.add(botonBarco);
				botonesCoordenadaABotonPanelIzq.put(new Coordenada(i, j), botonBarco);
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JCheckBox botonBarco = new JCheckBox();
				if (i % 2 != 0 && j % 2 != 0 || i % 2 == 0 && j % 2 == 0)
					botonBarco.setBackground(Color.GRAY);
				else
					botonBarco.setBackground(Color.LIGHT_GRAY);

				anadirBotones(botonBarco, i, j);
				panel_5.add(botonBarco);
				
				botonesTableroDisparo.add(botonBarco);
				botonesCoordenadaABotonPanelDch.put(new Coordenada(i, j), botonBarco);
				
			}
		}
		
	jHumano.addObserver(this);	
	
	Casilla[][] tableroJugador = jHumano.getTableroBarco().getTabla();
	
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			if(tableroJugador[i][j].getHayBarco()) {
				botonesCoordenadaABotonPanelIzq.get(new Coordenada(i,j)).setBackground(Color.yellow);	
		}
	}
		}
	}

	private void anadirBotones(JCheckBox pBoton, int pX, int pY) {
		Coordenada coord = new Coordenada(pX, pY);
		botonesModeloACoordenada.put(pBoton.getModel(), coord);
		botonesModeloABoton.put(pBoton.getModel(), pBoton);
	}

	private void accion() {
		if(botonesAccion.getSelection() != null) {
			if(botonesModeloABotonAccion.get(botonesAccion.getSelection()).equals(TipoDisparo.ESCUDO) && botonesTableroBarcos.getSelection() != null)
				jHumano.prepararAccion(botonesModeloACoordenada.get(botonesTableroBarcos.getSelection()),
						botonesModeloABotonAccion.get(botonesAccion.getSelection()));	
			else if (botonesTableroDisparo.getSelection() != null)
				jHumano.prepararAccion(botonesModeloACoordenada.get(botonesTableroDisparo.getSelection()),
						botonesModeloABotonAccion.get(botonesAccion.getSelection()));	
			else
				mostrarError("No has elegido una casilla, pierdes el turno");
			jOrdenador.actuar();
			limpiarSelecciones();
		}
		else 
			mostrarError("Selecciona un arma o herramienta");
	}
	
	private void reparar() {
		if(botonesTableroBarcos.getSelection() != null)
			jHumano.reparar(botonesModeloACoordenada.get(botonesTableroBarcos.getSelection()));
		else
			mostrarError("Selecciona una casilla de tu tablero");
		limpiarSelecciones();
	}
	
	private void comprar() {
		if(botonesCompra.getSelection() != null)
			jHumano.comprar(botonesModeloACompra.get(botonesCompra.getSelection()));
		else
			mostrarError("Selecciona el objeto a comprar");
		limpiarSelecciones();
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		if(evt.getPropertyName().equals("tableroBarco")) {
			cambioTablero((RegistroDisparo) evt.getNewValue(), botonesCoordenadaABotonPanelDch, (int) evt.getOldValue());
		} 
		else if(evt.getPropertyName().equals("tableroDisparo")){
			cambioTablero((RegistroDisparo) evt.getNewValue(), botonesCoordenadaABotonPanelIzq, (int) evt.getOldValue());
		} 
		else if(evt.getPropertyName().equals("barcoReparado")) {
			cambioBarcoReparado(evt);
		}
		else if(evt.getPropertyName().equals("noQuedaMunicion")) {
			avisoMunicion();
		}
		else if(evt.getPropertyName().equals("escudo")) {
			escudoUsado((RegistroDisparo) evt.getNewValue(), (int) evt.getOldValue());
		}
		else if(evt.getPropertyName().equals("radar")) {
			radarUsado((RegistroDisparo) evt.getNewValue(), (int) evt.getOldValue());
		}
		else if(evt.getPropertyName().equals("compra")) {
			compraHecha(botonesModeloACompra.get(botonesCompra.getSelection()), (Integer) evt.getOldValue(), (Integer) evt.getNewValue());
		}
		
	}	
	
	private void cambioTablero(RegistroDisparo rDisp, HashMap<Coordenada, JCheckBox> pMapaBotones, int pCantidadArma) {
		if (rDisp.isFinJuego()) {
			finalizarJuego(rDisp);
		} else if (rDisp.isTocaBarco()) {
			if(rDisp.getBarcoAtacado().getHundido()) {
				pintarCasillas(rDisp.getBarcoAtacado().getTamano(), rDisp.getBarcoAtacado().getOrientacion(), rDisp.getBarcoAtacado().getCoordenadaIncial(), pMapaBotones, Color.DARK_GRAY);
			}else if(rDisp.isHayEscudo()) {
				pintarCasillas(rDisp.getBarcoAtacado().getTamano(), rDisp.getBarcoAtacado().getOrientacion(), rDisp.getBarcoAtacado().getCoordenadaIncial(), pMapaBotones, Color.YELLOW);
			}else 
				pMapaBotones.get(rDisp.getCoorDisparo()).setBackground(Color.red);
			
		}
			else {
				pMapaBotones.get(rDisp.getCoorDisparo()).setBackground(Color.blue);
		}
		botonesTipoDisparoABotonAccion.get(rDisp.getTipoDeDisparo()).setText(rDisp.getTipoDeDisparo().toString() + "("+pCantidadArma+")");
	}

	private void cambioBarcoReparado(PropertyChangeEvent evt) {
		pintarCasillas(((Barco) evt.getNewValue()).getTamano(), ((Barco) evt.getNewValue()).getOrientacion(), ((Barco) evt.getNewValue()).getCoordenadaIncial(), botonesCoordenadaABotonPanelIzq, Color.GREEN);
		txtpnDinero.setText("Dinero: "+(Integer)evt.getOldValue()+"€");
	}
	
	private void avisoMunicion() {
		NoMunicion vNoMunicion = new NoMunicion();
		vNoMunicion.setVisible(true);
	}
	
	private void escudoUsado(RegistroDisparo rDisp, int pCantidadArma) {
		if(rDisp.getBarcoAtacado() != null)
			pintarCasillas(rDisp.getBarcoAtacado().getTamano(), rDisp.getBarcoAtacado().getOrientacion(), rDisp.getBarcoAtacado().getCoordenadaIncial(), botonesCoordenadaABotonPanelIzq, Color.ORANGE);
		botonesTipoDisparoABotonAccion.get(rDisp.getTipoDeDisparo()).setText(rDisp.getTipoDeDisparo().toString() + "("+pCantidadArma+")");
	}
	
	private void radarUsado(RegistroDisparo rDisp, int pCantidadArma) {
		Radar radar = rDisp.getRadar();
		if(radar.getBarcoDetectado() != null) {
			Barco barco = radar.getBarcoDetectado();
			pintarCasillas(barco.getTamano(), barco.getOrientacion(), barco.getCoordenadaIncial(), botonesCoordenadaABotonPanelDch, Color.MAGENTA);
		}else {
			NoMunicion vNoMunicion = new NoMunicion();
			vNoMunicion.setTexto("El radar no ha detectado ningún barco cerca");
			vNoMunicion.setVisible(true);
		}
		botonesTipoDisparoABotonAccion.get(rDisp.getTipoDeDisparo()).setText(rDisp.getTipoDeDisparo().toString() + "("+pCantidadArma+")");
	}
	
	private void pintarCasillas(int pNumeroCasillas, boolean pDireccion, Coordenada pPrimeraCoordenada, HashMap<Coordenada, JCheckBox> pMapaBotones, Color pColor) {
		if(pDireccion) {
			for(int i=0; i< pNumeroCasillas; i++) {
				Coordenada nCoord = new Coordenada(pPrimeraCoordenada.getX()+i, pPrimeraCoordenada.getY());
				pMapaBotones.get(nCoord).setBackground(pColor);
				
			}
		}
		else {
			for(int i=0; i< pNumeroCasillas; i++) {
				Coordenada nCoord = new Coordenada(pPrimeraCoordenada.getX(), pPrimeraCoordenada.getY()+i);
				pMapaBotones.get(nCoord).setBackground(pColor);
			}
		}
	}
	
	private void finalizarJuego(RegistroDisparo rDisp) {
		FinJuego vFin = new FinJuego();
		if(rDisp.getGanador()) {
			vFin.setGanador("Has ganado");
			System.out.println("Has ganado");
		}
		else {
			vFin.setGanador("Has perdido");
			System.out.println("Has Perdido");
		}
		setVisible(false);
		vFin.setVisible(true);
	}
	
	private void compraHecha(TipoDisparo pDisparo, int pDinero, int pCantidad) {
		botonesTipoDisparoABotonAccion.get(pDisparo).setText(pDisparo.toString() + "("+pCantidad+")");
		txtpnDinero.setText("Dinero: "+pDinero+"€");
	}
	
	private void mostrarError(String pString) {
		CoordenadasFuera vCoorFue = new CoordenadasFuera();
		vCoorFue.setVisible(true);
		vCoorFue.setText(pString);
		limpiarSelecciones();				
	}
	
	private void limpiarSelecciones() {
		botonesTableroBarcos.clearSelection();
		botonesTableroDisparo.clearSelection();
		botonesAccion.clearSelection();
		botonesCompra.clearSelection();
	}
	
}
