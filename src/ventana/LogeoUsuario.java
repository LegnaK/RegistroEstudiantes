package ventana;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conexion.Conexion;

public class LogeoUsuario extends JFrame implements
		java.awt.event.ActionListener, Runnable {

	private JLabel jlbl_usuario;
	private JLabel jlbl_contra;
	private JTextField jtxt_usuario;
	private JPasswordField jpss_contra;
	private JTextField jtxt_contra;

	private JButton jbtn_ingresar;
	private JButton jbtn_limpiar;

	private Conexion conexion;

	public LogeoUsuario() {
		setSize(285, 140);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		conexion = new Conexion();
		// System.out.println(System.getProperty("user.dir") + "\\login.db");
		conexion.setRutaBaseDatos(System.getProperty("user.dir") + "/login.db");

		jlbl_usuario = new JLabel("Usuario:");
		jlbl_usuario.setBounds(5, 5, 120, 20);
		add(jlbl_usuario);

		jtxt_usuario = new JTextField();
		jtxt_usuario.setBounds(135, 5, 120, 20);
		add(jtxt_usuario);

		jlbl_contra = new JLabel("Contraseña");
		jlbl_contra.setBounds(5, 30, 120, 20);
		add(jlbl_contra);

		jpss_contra = new JPasswordField();
		jpss_contra.setBounds(135, 30, 120, 20);
		jpss_contra.setEchoChar('*');
		add(jpss_contra);

		jbtn_ingresar = new JButton("Ingresar");
		jbtn_ingresar.setBounds(10, 70, 120, 20);
		jbtn_ingresar.addActionListener(this);
		add(jbtn_ingresar);

		jbtn_limpiar = new JButton("Limpiar");
		jbtn_limpiar.setBounds(140, 70, 120, 20);
		jbtn_limpiar.addActionListener(this);
		add(jbtn_limpiar);
	}

	// ****************************

	private boolean verificarLogin(String usuario, char[] contra) {

		if (!conexion.tablaExiste("login")) {
			conexion.crearTabla(
					"login",
					"id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, password TEXT, permisos TEXT, primer_nombre TEXT, primer_apellido TEXT, segundo_apellido TEXT, correo_primario TEXT, correo_secundario TEXT");
			conexion.insertar("INSERT INTO login VALUES ('0', 'admin', 'admin', 'admin', 'Admin', '', '', 'admin@Admin.com', '')");
		}

		ResultSet resultado = null;

		String consulta = "SELECT * FROM login";

		resultado = conexion.consultar(consulta);
		try {
			while (resultado.next()) {

				char[] passCorrecto = resultado.getString("password")
						.toCharArray();

				if (contra.length != passCorrecto.length) {
					return false;

				} else {
					if (resultado.getString("usuario").equals(usuario)
							& Arrays.equals(contra, passCorrecto)) {

						resultado.close();

						return true;

					}
				}

			}

			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	// **************************

	// ********************************

	public void actionPerformed(ActionEvent xp) {
		if (xp.getSource() == jbtn_ingresar) {

			if (jtxt_usuario.getText().length() > 0
					& jpss_contra.getPassword().length > 0) {

				if (verificarLogin(jtxt_usuario.getText(),
						jpss_contra.getPassword())) {

					Ventana ventana = new Ventana();
					setVisible(false);
					ventana.setVisible(true);

				} else {
					JOptionPane
							.showMessageDialog(
									this,
									"El nombre de usuario y/o contraseña son incorrectos!",
									"Error!", JOptionPane.ERROR_MESSAGE);
					jpss_contra.setText(null);
				}

			} else
				JOptionPane.showMessageDialog(this,
						"Debe ingresar el nombre de usuario y contraseña");

		} else if (xp.getSource() == jbtn_limpiar) {
			jtxt_usuario.setText(null);
			jtxt_contra.setText(null);

		}
	}

	/* ------------------------------------ */

	public static void main(String[] ahk) {
		LogeoUsuario logeo = new LogeoUsuario();
		logeo.setVisible(true);
	}

	@Override
	public void run() {

	}

}
