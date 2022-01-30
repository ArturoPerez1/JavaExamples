package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Vista extends JFrame {
	private JPanel panel = new JPanel();
	private JButton boton = new JButton();
	private JButton boton1 = new JButton();	
	private JButton boton2 = new JButton();
	private JButton boton3 = new JButton();
	private JTextField cajaText = new JTextField();
	private JLabel title = new JLabel();
	private JLabel etiqueta = new JLabel();
	private JLabel etiqueta2  = new JLabel();
	private int dimension;
	private int numeroN;
	
	public Vista() {
		setSize(800,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.GRAY);
		setTitle("Ventana");
		implemetarComponetes();
	}
	
	private void implemetarComponetes(){
		panel();
		title();
		botonesMenu();
	}
	
	private void panel() {
		this.getContentPane().add(panel);
		panel.setBackground(new Color(166, 247, 215));
		panel.setLayout(null);
	}
		
	private void title() {
		title.setBounds(220,220,400,40);
		title.setText("MENÚ PRINCIPAL");
		title.setFont(new Font("Arial Black", Font.PLAIN, 25));	
		panel.add(title);
	}
		
	private void botonesMenu(){		
		boton1.setText("1.- INTRODUCIR DATOS");
		boton1.setBounds(220,280,300,20);
		boton1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		boton1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(boton1);
		
		boton3.setText("2.- SALIR");
		boton3.setBounds(220,340,300,20);
		boton3.setFont(new Font("Arial Black", Font.PLAIN, 13));
		boton3.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(boton3);
		
		
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
		});
		
	}
	
	public JButton getBoton1() {
		return boton1;
	}
	
	public JButton getBoton2() {
		return boton2;
	}
	

	public int getDimension() {
		return dimension;
	}

	public void setDimensionJOptionPane() {
		String inputDimension = JOptionPane.showInputDialog("INGRESE LA DIMENSIÓN");
		if ((inputDimension != null) && (inputDimension.length() > 0)) {
			this.dimension = Integer.parseInt(inputDimension);
		}
	}
	
	public int getNumeroN() {
		return numeroN;
	}

	public void setNumeroNJOptionPane() {
		String inputNumeroN = JOptionPane.showInputDialog("INGRESE EL NUMERO N");
		if ((inputNumeroN != null) && (inputNumeroN.length() > 0)) {
			this.numeroN = Integer.parseInt(inputNumeroN);
		}
	}

	public void mensajeError(String error) {
		JOptionPane.showMessageDialog(this, error);
	}
	
	public void mensajeGeneral(String mensajes) {
		JOptionPane.showMessageDialog(this, mensajes);
	}
	
	public void listenerAction(ActionListener action) {
		boton1.addActionListener(action);
	}
}
