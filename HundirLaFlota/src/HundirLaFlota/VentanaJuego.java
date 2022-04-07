package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup botonesTableroDisparo = new ButtonGroup();
	private final ButtonGroup botonesCompra = new ButtonGroup();

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
		panel_10.setLayout(new GridLayout(4, 0, 0, 0));
		
		JTextPane txtpnArmas = new JTextPane();
		txtpnArmas.setText("ARMAS");
		panel_10.add(txtpnArmas);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Bomba (100)");
		panel_10.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Misiles (10)");
		panel_10.add(rdbtnNewRadioButton_4);
		
		JButton btnNewButton_4 = new JButton("Atacar");
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
		
		for(int i = 0; i<10; i++) {
			for(int j=0; j<10; j++) {
				JPanel panel_6 = new JPanel();
				if(i%2!=0 && j%2!=0 || i%2==0 && j%2==0)
					panel_6.setBackground(Color.BLACK);
				else
					panel_6.setBackground(Color.WHITE);
				
				panel_4_1.add(panel_6);
			}
		}
		
		for(int i = 0; i<10; i++) {
			for(int j=0; j<10; j++) {
				JCheckBox botonBarco = new JCheckBox();
				if(i%2!=0 && j%2!=0 || i%2==0 && j%2==0)
					botonBarco.setBackground(Color.BLACK);
				else
					botonBarco.setBackground(Color.WHITE);
				botonesTableroDisparo.add(botonBarco);
				panel_5.add(botonBarco);
			}
		}
	}

}
