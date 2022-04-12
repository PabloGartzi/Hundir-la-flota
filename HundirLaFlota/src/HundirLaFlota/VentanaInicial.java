package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class VentanaInicial extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField txtHundirLaFlota;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
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
	public VentanaInicial() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getTxtHundirLaFlota(), BorderLayout.NORTH);
			panel.add(getTextField(), BorderLayout.WEST);
			panel.add(getTextField_1(), BorderLayout.EAST);
			panel.add(getTextField_2(), BorderLayout.SOUTH);
			panel.add(getPanel_1(), BorderLayout.CENTER);
		}
		return panel;
	}

	private JTextField getTxtHundirLaFlota() {
		if (txtHundirLaFlota == null) {
			txtHundirLaFlota = new JTextField();
			txtHundirLaFlota.setEditable(false);
			txtHundirLaFlota.setHorizontalAlignment(SwingConstants.CENTER);
			txtHundirLaFlota.setFont(new Font("Tahoma", Font.BOLD, 18));
			txtHundirLaFlota.setText("HUNDIR LA FLOTA");
			txtHundirLaFlota.setColumns(10);
		}
		return txtHundirLaFlota;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setColumns(10);
		}
		return textField;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
		}
		return textField_1;
	}

	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setColumns(10);
		}
		return textField_2;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(3, 0, 0, 0));
			panel_1.add(getPanel_2());
			panel_1.add(getBtnNewButton());
			panel_1.add(getLblNewLabel());
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
		}
		return panel_2;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("JUGAR");
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel() {
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("fototarde.jpg"));
		return lblNewLabel;
	}
}
