package ventana;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import objetos.Estudiante;

public class Eventos {

	private final Object elemento;
	private Conexion conexion;

	public Eventos(Object elemento) {
		this.elemento = elemento;

		conexion = new Conexion();
		conexion.setRutaBaseDatos(System.getProperty("user.dir") + "/base_datos/grupos.db");
	}

	public void insertarEstudiante(String nombreGrupo, Estudiante estudiante) {


		System.out.println(estudiante.getPrimerNombre());
			try {
				String sql = "INSERT INTO "+nombreGrupo+" VALUES('"
						+ estudiante.getPrimerNombre() + "','"
						+ estudiante.getSegundoNombre() + "','"
						+ estudiante.getPrimerApellido() + "','"
						+ estudiante.getSegundoApellido() + "','"
						+ estudiante.getPrimerExaPrimerTri().toString() + "','"
						+ estudiante.getSegundoExaPrimerTri().toString()+ "','"
						+ estudiante.getPrimerTri().toString() + "','"
						+ estudiante.getPrimerExaSegundoTri().toString() + "','"
						+ estudiante.getSegundoExaSegundoTri().toString() + "','"
						+ estudiante.getSegundoTri().toString() + "','"
						+ estudiante.getPrimerExaTercerTri().toString() + "','"
						+ estudiante.getSegundoExaTercerTri().toString() + "','"
						+ estudiante.getTercerTri().toString() + "','"
						+ estudiante.getNotaFinal().toString() +"')";
				
				if(conexion.insertar(sql)){
					JOptionPane.showMessageDialog(null, "Estudiante agregado con exito");
				
				} else {
					JOptionPane.showMessageDialog(null, "Error al insertar", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			} catch (Exception xp) {
				System.out.println("Error insertando en la tabla");
			}
		
	}

	/**
	 * Insertar grupo (tabla)
	 */
	public void insertarGrupo() {
		String nombre = JOptionPane
				.showInputDialog("Ingrese el nombre del grupo (secion):");
		if (!nombre.isEmpty()) {

			if (!conexion.tablaExiste(nombre)) {
				if (conexion
						.crearTabla(
								nombre,
								"primer_nombrse TEXT, segundo_nombre TEXT, primer_apellido TEXT, segundo_apellido TEXT, nota_primer_examen_primer_trimestre TEXT, nota_segundo_examen_primer_trimestre TEXT, nota_primer_trimestre TEXT, nota_primer_examen_segundo_trimestre TEXT, nota_segundo_examen_segundo_trimestre TEXT, nota_segundo_trimestre TEXT, nota_primer_examen_tercer_trimestre TEXT, nota_segundo_examen_tercer_trimestre TEXT, nota_tercer_trimestre TEXT, nota_final TEXT")) {
					JOptionPane.showMessageDialog(null,
							"Grupo creado con exito");

				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Imposible crear el grupo (error creating the table)",
									"Error!", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null,
						"Ya existe un grupo con este nombre!", "Error!",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	/**
	 * Borrar todas las tablas
	 */
	public void borrarGrupos(String nombreGrupo) {
		
		if(conexion.borrarTabla(nombreGrupo)){
			JOptionPane.showMessageDialog(null, "Grupo eliminado correctamente");
		
		} else {
			JOptionPane.showMessageDialog(null, "Error al eliminar el grupo", "Error!", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	public void borrarEstudiante(){
		if(conexion.borrarTabla("DROP TABLE personales")){
			JOptionPane.showMessageDialog(null, "Grupo eliminado correctamente");
		
		} else {
			JOptionPane.showMessageDialog(null, "Error al eliminar el grupo", "Error!", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	public void mostrarEstudiantes(DefaultTableModel modeloTabla, String nombreGrupo) {

		ResultSet resultado = null;

		modeloTabla.setRowCount(0);
		modeloTabla.setColumnCount(0);

		String sql = "SELECT * FROM "+nombreGrupo;

		try {

			resultado = conexion.consultar(sql);

			if (resultado != null) {
				
				int numeroColumna = resultado.getMetaData().getColumnCount(); 

				for (int x = 1; x <= numeroColumna; x++) {
					modeloTabla.addColumn(resultado.getMetaData() 
							.getColumnName(x));
				}

				while (resultado.next()) {
					Object[] objetos = new Object[numeroColumna];

					for (int x = 1; x <= numeroColumna; x++) {
						objetos[x - 1] = resultado.getObject(x);
					}
					modeloTabla.addRow(objetos);
				}

			}

		} catch (SQLException xp) {
		}

		conexion.cerrarConexion();
		if (resultado != null) {
			try {
				resultado.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * JMenuItem acerca
	 */
	public void acerca() {
		JOptionPane
				.showMessageDialog(
						null,
						"Aplicacion para el registro de alumnos.\nProgramador y Diseñador: Rodolfo Sequeira Rodriguez\n"
								+ "Propiedad intelectual reservada.");
	}

	public void salir() {
		System.exit(0);
	}

	/**
	 * Agregar estudiante
	 */
	public ArrayList<String> nombres() {
		return conexion.nombresTablas();
	}

}
