package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
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

	private JPanel contentPane;
	private final ButtonGroup botonesTableroDisparo = new ButtonGroup();
	private final ButtonGroup botonesTableroBarcos = new ButtonGroup();
	private final ButtonGroup botonesCompra = new ButtonGroup();
	private final ButtonGroup botonesAccion = new ButtonGroup();

	private HashMap<ButtonModel, Coordenada> botonesModeloACoordenada;
	private HashMap<Coordenada, JCheckBox> botonesCoordenadaABotonPanelIzq;
	private HashMap<Coordenada, JCheckBox> botonesCoordenadaABotonPanelDch;
	private HashMap<ButtonModel, JCheckBox> botonesModeloABoton;
	private Humano jHumano = Humano.getHumano();
	private Ordenador jOrdenador = Ordenador.getOrdenador();

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
		panel_7.setLayout(new GridLayout(4, 0, 0, 0));

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Misil (40\u20AC)");
		botonesCompra.add(rdbtnNewRadioButton);
		panel_7.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Escudo (80\u20AC)");
		botonesCompra.add(rdbtnNewRadioButton_1);
		panel_7.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Radar (100\u20AC)");
		botonesCompra.add(rdbtnNewRadioButton_2);
		panel_7.add(rdbtnNewRadioButton_2);

		JButton btnNewButton_3 = new JButton("COMPRAR");
		panel_7.add(btnNewButton_3);

		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);

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

		JRadioButton botonBomba = new JRadioButton("Bomba (100)");
		botonesAccion.add(botonBomba);
		panel_10.add(botonBomba);

		JRadioButton botonMisil = new JRadioButton("Misiles (10)");
		botonesAccion.add(botonMisil);
		panel_10.add(botonMisil);

		JRadioButton botonRadar = new JRadioButton("Radar");
		botonesAccion.add(botonRadar);
		panel_10.add(botonRadar);

		JRadioButton botonEscudo = new JRadioButton("Escudo");
		botonesAccion.add(botonEscudo);
		panel_10.add(botonEscudo);

		JButton btnNewButton_4 = new JButton("Acción");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jHumano.prepararDisparo(botonesModeloACoordenada.get(botonesTableroDisparo.getSelection()),
						TipoDisparo.BOMBA);	
				jOrdenador.disparar();
			}
		});
		panel_10.add(btnNewButton_4);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		panel_3.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		panel_3.add(btnNewButton_2);

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
					botonBarco.setBackground(Color.BLACK);
				else
					botonBarco.setBackground(Color.WHITE);

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
					botonBarco.setBackground(Color.BLACK);
				else
					botonBarco.setBackground(Color.WHITE);

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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		RegistroDisparo rDisp;
		rDisp = (RegistroDisparo) evt.getNewValue();
		if(evt.getPropertyName().equals("tableroBarco")) {
			if (rDisp.isFinJuego()) {
				FinJuego vFin = new FinJuego();
				setVisible(false);
				vFin.setVisible(true);
			} else if (rDisp.isTocaBarco()) {
				if(rDisp.getBarcoAtacado().getHundido()) {
					pintarCasillasBarcoHundidoPropio(rDisp.getBarcoAtacado().getTamano(), rDisp.getBarcoAtacado().getOrientacion(), rDisp.getBarcoAtacado().getCoordenadaIncial());
				}else 
					botonesModeloABoton.get(botonesTableroDisparo.getSelection()).setBackground(Color.red);
				
			}
				else {
				botonesModeloABoton.get(botonesTableroDisparo.getSelection()).setBackground(Color.blue);
			}
		} else if(evt.getPropertyName().equals("tableroDisparo")){
			if (rDisp.isFinJuego()) {
				FinJuego vFin = new FinJuego();
				setVisible(false);
				vFin.setVisible(true);
			} else if (rDisp.isTocaBarco()) {
				if(rDisp.getBarcoAtacado().getHundido()) {
					pintarCasillasBarcoHundidoEnemigo(rDisp.getBarcoAtacado().getTamano(), rDisp.getBarcoAtacado().getOrientacion(), rDisp.getBarcoAtacado().getCoordenadaIncial());
				}else
					botonesCoordenadaABotonPanelIzq.get(rDisp.getCoorDisparo()).setBackground(Color.red);
			}
	
			else {
				botonesCoordenadaABotonPanelIzq.get(rDisp.getCoorDisparo()).setBackground(Color.blue);
			}
		}
	}
	
	private void pintarCasillasBarcoHundidoEnemigo(int pNumeroCasillas, boolean pDireccion, Coordenada pPrimeraCoordenada) {
		if(pDireccion) {
			for(int i=0; i< pNumeroCasillas; i++) {
				Coordenada nCoord = new Coordenada(pPrimeraCoordenada.getX()+i, pPrimeraCoordenada.getY());
				botonesCoordenadaABotonPanelIzq.get(nCoord).setBackground(Color.DARK_GRAY);
				
			}
		}
		else {
			for(int i=0; i< pNumeroCasillas; i++) {
				Coordenada nCoord = new Coordenada(pPrimeraCoordenada.getX(), pPrimeraCoordenada.getY()+i);
				botonesCoordenadaABotonPanelIzq.get(nCoord).setBackground(Color.DARK_GRAY);
			}
		}
	}
	
	private void pintarCasillasBarcoHundidoPropio(int pNumeroCasillas, boolean pDireccion, Coordenada pPrimeraCoordenada) {
		if(pDireccion) {
			for(int i=0; i< pNumeroCasillas; i++) {
				Coordenada nCoord = new Coordenada(pPrimeraCoordenada.getX()+i, pPrimeraCoordenada.getY());
				botonesCoordenadaABotonPanelDch.get(nCoord).setBackground(Color.DARK_GRAY);
				
			}
		}
		else {
			for(int i=0; i< pNumeroCasillas; i++) {
				Coordenada nCoord = new Coordenada(pPrimeraCoordenada.getX(), pPrimeraCoordenada.getY()+i);
				botonesCoordenadaABotonPanelDch.get(nCoord).setBackground(Color.DARK_GRAY);
			}
		}
	}
	//TODO mirar bien que casillas se están pintando
}
