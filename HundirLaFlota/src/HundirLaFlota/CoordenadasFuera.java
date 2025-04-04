package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class CoordenadasFuera extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CoordenadasFuera dialog = new CoordenadasFuera();
			dialog.setTitle("ERROR");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CoordenadasFuera() {
		setBounds(100, 100, 674, 129);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new FlowLayout());
			{
				lblNewLabel = new JLabel("Aguna casilla del barco está fuera del terreno, \n elija otro lugar.");
				contentPanel.add(lblNewLabel);
			}
		}
	}
	
	public void setText(String pString) {
		lblNewLabel.setText(pString);
	}

}
