package HundirLaFlota;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JFormattedTextField;

public class NoMunicion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextComponent frmtdtxtfldNoQuedaMunicin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NoMunicion dialog = new NoMunicion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NoMunicion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		frmtdtxtfldNoQuedaMunicin = new JFormattedTextField();
		frmtdtxtfldNoQuedaMunicin.setEditable(false);
		frmtdtxtfldNoQuedaMunicin.setText("No queda munición en  el arma elegida, turno perdido.");
		contentPanel.add(frmtdtxtfldNoQuedaMunicin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
		}
	}
	
	public void setTexto(String pTexto) {
		frmtdtxtfldNoQuedaMunicin.setText(pTexto);
	}

}
