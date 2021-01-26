// Wesley Oliveira - CB300550X

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import com.google.gson.Gson;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class Interface extends JInternalFrame {

	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtObjetivo;
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	
	Cliente clientes = new Cliente();
	ClienteS clienteS = new ClienteS();

	/**
	 * Create the frame.
	 */
	public Interface() {

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		frame.setSize(400,300);
		setBounds(100, 100, 450, 300);
		
		txtNome = new JTextField();
		txtNome.setBounds(89, 46, 86, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(89, 77, 86, 20);
		frame.getContentPane().add(txtIdade);
		txtIdade.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(89, 108, 86, 20);
		frame.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(89, 139, 86, 20);
		frame.getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		txtObjetivo = new JTextField();
		txtObjetivo.setBounds(89, 170, 86, 20);
		frame.getContentPane().add(txtObjetivo);
		txtObjetivo.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(44, 80, 46, 14);
		frame.getContentPane().add(lblIdade);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(44, 111, 46, 14);
		frame.getContentPane().add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(44, 142, 46, 14);
		frame.getContentPane().add(lblAltura);
		
		JLabel lblObjetivo = new JLabel("Objetivo");
		lblObjetivo.setBounds(44, 173, 46, 14);
		frame.getContentPane().add(lblObjetivo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(44, 49, 46, 14);
		frame.getContentPane().add(lblNome);
	
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				clientes.setNome(txtNome.getText());
				clientes.setIdade(Integer.parseInt(txtIdade.getText()));
				clientes.setPeso(Float.parseFloat(txtPeso.getText()));
				clientes.setAltura(Float.parseFloat(txtAltura.getText()));
				clientes.setObjetivo(txtObjetivo.getText());
				
				clienteS.insert(clientes);
				JOptionPane.showMessageDialog(null, txtNome.getText() + " foi cadastrado(a)!");
			}
		});
		btnIncluir.setBounds(261, 45, 89, 23);
		frame.getContentPane().add(btnIncluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtIdade.setText("");
				txtPeso.setText("");
				txtAltura.setText("");
				txtObjetivo.setText("");
			}
		});
		btnLimpar.setBounds(261, 76, 89, 23);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Gson json=new Gson() ;
				
				clientes.setNome(txtNome.getText());
				clientes.setIdade(Integer.parseInt(txtIdade.getText()));
				clientes.setPeso(Float.parseFloat(txtPeso.getText()));
				clientes.setAltura(Float.parseFloat(txtIdade.getText()));
				clientes.setObjetivo(txtObjetivo.getText());
				
				String response = json.toJson(clientes);
				
				JOptionPane.showMessageDialog(null, response);
			}
		});
		btnMostrar.setBounds(261, 107, 89, 23);
		frame.getContentPane().add(btnMostrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnSair.setBounds(261, 138, 89, 23);
		frame.getContentPane().add(btnSair);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			Interface frame = new Interface();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
