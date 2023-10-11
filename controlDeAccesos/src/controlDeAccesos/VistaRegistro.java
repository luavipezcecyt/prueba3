package controlDeAccesos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodAcc;
	private JTextField txtNombre;
	private JTextField txtFecha;
	private JTextField txtHora;
	//private JButton btnConsultar;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRegistro frame = new VistaRegistro();
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
	public VistaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCodAcc = new JTextField();
		txtCodAcc.setBounds(175, 31, 86, 20);
		contentPane.add(txtCodAcc);
		txtCodAcc.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(175, 66, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(175, 97, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(185, 130, 86, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		lblId = new JLabel("");
		lblId.setBounds(175, 6, 46, 14);
		contentPane.add(lblId);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarR();
			}
		});
		btnGuardar.setBounds(24, 227, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarR();
			}
		});
		btnConsultar.setBounds(155, 227, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setBounds(100, 34, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(110, 69, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(119, 100, 46, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(129, 136, 46, 14);
		contentPane.add(lblHora);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarR();
			}
		});
		btnActualizar.setBounds(284, 227, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarR();
			}
		});
		btnEliminar.setBounds(155, 193, 89, 23);
		contentPane.add(btnEliminar);
	}
	private void guardarR() {
		Registro reg = new Registro();
		reg.setCodAcc(Integer.parseInt(txtCodAcc.getText()));
		reg.setNombre(txtNombre.getText());
		reg.setFecha(txtFecha.getText());
		reg.setHora(txtHora.getText());
		RegistroDAO rd = new RegistroDAO();
		rd.guardarRegistro(reg);
	}
	private void consultarR() {
		RegistroDAO rd = new RegistroDAO();
		Registro r = rd.consultarReg(Integer.parseInt(txtCodAcc.getText()));
		lblId.setText(String.valueOf( r.getId()));
		txtNombre.setText(r.getNombre());
		txtFecha.setText(r.getFecha());
		txtHora.setText(r.getHora());		
	}
	
	private boolean actualizarR() {
		Registro r = new Registro();
		r.setId(Integer.parseInt(lblId.getText()));
		r.setCodAcc(Integer.parseInt(txtCodAcc.getText()));
		r.setNombre(txtNombre.getText());
		r.setFecha(txtFecha.getText());
		r.setHora(txtHora.getText());
		RegistroDAO rd = new RegistroDAO();
		return rd.actualizarRegistro(r);
	}
	
	private boolean eliminarR() {
		RegistroDAO rd = new RegistroDAO();
		return rd.eliminarRegistro(Integer.parseInt(lblId.getText()));
	}
}











