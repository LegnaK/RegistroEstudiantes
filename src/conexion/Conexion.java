package conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 * @author Rodolfo
 * @version 1.0.a
 */

public class Conexion {

	private Connection conexion = null;
	private Statement consulta = null;
	private String rutaBaseDatos = null;

	/**
	 * Constructor
	 */
	public Conexion() {
	}

	/**
	 * 
	 * @param rutaBaseDatos
	 */
	public void setRutaBaseDatos(String rutaBaseDatos){
		this.rutaBaseDatos = rutaBaseDatos;
	}
	
	
	/**
	 * Carga la conexion
	 * 
	 * @return Conecction
	 * @throws ClassNotFoundException
	 */
	public void cargarConexion() {
		// Carga el driver sqlite-JBDC
		try {
			Class.forName("org.sqlite.JDBC");

		} catch (ClassNotFoundException px) {
			System.err.print(px.getMessage());
			System.out.println("Error al cargar el driver");
		}

		try {
			// DriverManager.registerDriver(new org.sqlite.JDBC());

			conexion = DriverManager.getConnection("jdbc:sqlite:"
					+ rutaBaseDatos);
			consulta = conexion.createStatement();
			// consulta.setQueryTimeout(30);
		} catch (SQLException xp) {
			System.out.println("Error al crear la conexion");
		}
		
	}

	/**
	 * Cierra la conexion a l base de datos
	 * 
	 * @param resultado
	 */
	public void cerrarConexion() {

		try {
			consulta.close();
			conexion.close();
		} catch (Exception xl) {
			System.out.println(xl.getMessage());
			System.out.println(xl.getStackTrace());

		}
	}

	/**
	 * Retorna los datos de la consulta
	 * 
	 * @param sql
	 *            Datos a consultar
	 * @return ResulSet
	 */
	public ResultSet consultar(String sql) {

		cargarConexion();
		ResultSet resultado = null;

		try {
			resultado = consulta.executeQuery(sql);

		} catch (SQLException xp) {
			System.out.println("Mensaje:" + xp.getMessage());
			System.out.println("Estado:" + xp.getSQLState());
			System.out.println("Codigo del error:" + xp.getErrorCode());
			JOptionPane.showMessageDialog(null, "" + xp.getMessage());
		}

		return resultado;

	}

	public boolean insertar(String datosInsertar) {

		cargarConexion();
		try {
			consulta.executeUpdate(datosInsertar);
			
			cerrarConexion();
			return true;
			
		} catch (SQLException xp) {
			JOptionPane.showMessageDialog(null, "Error\n" + xp.getMessage(),
					"Error!", JOptionPane.ERROR_MESSAGE);
			System.out.println("Error ingresar");
			return false;
			
		}


	}

	public void modificar(String datosModificar) {

		cargarConexion();
		try {
			consulta.executeUpdate(datosModificar);

		} catch (SQLException xp) {
			JOptionPane.showMessageDialog(null, "Error\n" + xp.getMessage(),
					"Error!", JOptionPane.ERROR_MESSAGE);
			System.out.println("Error ingresar");

		}

		cerrarConexion();

	}

	public boolean borrar(String datosBorrar) {
		cargarConexion();
		try {
			consulta.executeUpdate(datosBorrar);
			cerrarConexion();
			return true;

		} catch (SQLException xp) {
			JOptionPane.showMessageDialog(null, "Error\n" + xp.getMessage(),
					"Error!", JOptionPane.ERROR_MESSAGE);
			System.out.println("Error al borrar tabla");
			return false;
			
		}

		
	}

	public boolean crearTabla(String nombreTabla, String campos) {
		cargarConexion();

		try {
			consulta.executeUpdate("CREATE TABLE "+nombreTabla+"("+campos+");");
			cerrarConexion();
			return true;
			
		} catch (SQLException xp) {
			xp.printStackTrace();
			return false;
		}

	}
	
	public boolean tablaExiste(String nombreTabla){
		cargarConexion();
		
		try {
			consulta.executeQuery("SELECT * FROM "+nombreTabla);
			
			cerrarConexion();
			return true;
					
		} catch (SQLException xp) {
			xp.printStackTrace();	
			return false;
		}
		
	}
	
	public ArrayList<String> nombresTablas(){
		
		cargarConexion();
		
		try {
			DatabaseMetaData metaDatos = conexion.getMetaData();
			
			ResultSet resultado = metaDatos.getTables(null, null, "%", null);
			
			ArrayList <String> nombres = new ArrayList<String>();
			while (resultado.next()){
				nombres.add(resultado.getString(3));
	
			}
			return nombres;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
