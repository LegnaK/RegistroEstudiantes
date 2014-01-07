package ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import objetos.Estudiante;

/**
 * @author Rodolfo
 */
public class TabsPaneles implements ActionListener {

	private Eventos eventos;
	private final Ventana ventana;

	private JTabbedPane jtbp_tabs;

	private JPanel jpnl_manejoDatos;
	private JPanel jpnl_configuracion;

	private JButton jbtn_agregarGrupo;
	private JLabel jlbl_agregarGrupo;

	private JButton jbtn_eliminarVer;
	private JLabel jlbl_eliminarVer;
	private JDialog jdig_eliminarVer;
	private JButton jbtn_mostrar;
	private JButton jbtn_eliminaEstudiante;
	private JButton jbtn_eliminarGrupo;
	private JButton jbtn_eliminarTodo;
	private JLabel jlbl_eligeGrupoVerEliminar;

	private JButton jbtn_agregarEstudiante;
	private JLabel jlbl_agregarEstudiante;
	private JDialog jdig_agregarEstudiante;
	private JTable jtbl_estudiantes;
	private JScrollPane jscr_tablaEstudiantes;

	private JComboBox<String> jcbx_listaGruposAgregar;
	private JComboBox<String> jcbx_listaGruposMostrarEliminar;

	private JLabel jlbl_eligeGrupo;
	private JLabel jlbl_primerNombre;
	private JLabel jlbl_segundoNombre;
	private JLabel jlbl_primerApellido;
	private JLabel jlbl_segundoApellido;
	private JLabel jlbl_notaPrimerExamenPrimerTrimestre;
	private JLabel jlbl_notaSegundoExamenPrimerTrimestre;
	private JLabel jlbl_notaPrimerExamenSegundoTrimestre;
	private JLabel jlbl_notaSegundoExamenSegundoTrimestre;
	private JLabel jlbl_notaPrimerExamenTercerTrimestre;
	private JLabel jlbl_notaSegundoExamenTercerTrimestre;
	private JLabel jlbl_notaPrimerTrimestre;
	private JLabel jlbl_notaSegundoTrimestre;
	private JLabel jlbl_notaTercerTrimestre;
	private JLabel jlbl_notaFinal;

	private JTextField jtxt_primerNombre;
	private JTextField jtxt_segundoNombre;
	private JTextField jtxt_primerApellido;
	private JTextField jtxt_segundoApellido;
	private JTextField jtxt_notaPrimerExamenPrimerTrimestre;
	private JTextField jtxt_notaSegundoExamenPrimerTrimestre;
	private JTextField jtxt_notaPrimerExamenSegundoTrimestre;
	private JTextField jtxt_notaSegundoExamenSegundoTrimestre;
	private JTextField jtxt_notaPrimerExamenTercerTrimestre;
	private JTextField jtxt_notaSegundoExamenTercerTrimestre;
	private JTextField jtxt_notaPrimerTrimestre;
	private JTextField jtxt_notaSegundoTrimestre;
	private JTextField jtxt_notaTercerTrimestre;
	private JTextField jtxt_notaFinal;

	private JSeparator jsep_separador1;
	private JSeparator jsep_separador2;
	private JSeparator jsep_separador3;
	private JSeparator jsep_separador4;
	
	private JButton jbtn_limpiarTodo;
	private JButton jbtn_agregar;


	public TabsPaneles(Ventana ventana) {
		this.ventana = ventana;

		eventos = new Eventos(this);
	}

	public void initTabsPaneles() {
		jtbp_tabs = new JTabbedPane();

		jpnl_manejoDatos = new JPanel();
		jpnl_manejoDatos.setLayout(null);
		jtbp_tabs.addTab("Ingreso/Eliminacion/Visualizacion de datos", jpnl_manejoDatos);

		jlbl_agregarGrupo = new JLabel(new ImageIcon(getClass().getResource(
				"/img/agregarGrupo.png")));
		jlbl_agregarGrupo.setBounds(20, 10, 150, 90);
		jpnl_manejoDatos.add(jlbl_agregarGrupo);

		jbtn_agregarGrupo = new JButton("Agregar grupo");
		jbtn_agregarGrupo.setBounds(20, 100, 150, 20);
		jbtn_agregarGrupo.addActionListener(this);
		jpnl_manejoDatos.add(jbtn_agregarGrupo);

		jlbl_agregarEstudiante = new JLabel(new ImageIcon(getClass()
				.getResource("/img/agregarEstudiante.png")));
		jlbl_agregarEstudiante.setBounds(180, 10, 150, 90);
		jpnl_manejoDatos.add(jlbl_agregarEstudiante);

		jbtn_agregarEstudiante = new JButton("Agregar estudiante");
		jbtn_agregarEstudiante.setBounds(180, 100, 150, 20);
		jbtn_agregarEstudiante.addActionListener(this);
		jpnl_manejoDatos.add(jbtn_agregarEstudiante);

		jlbl_eliminarVer = new JLabel(new ImageIcon(getClass().getResource(
				"/img/eliminar.png")));
		jlbl_eliminarVer.setBounds(340, 10, 150, 90);
		jpnl_manejoDatos.add(jlbl_eliminarVer);

		jbtn_eliminarVer = new JButton("Ver datos o Eliminar");
		jbtn_eliminarVer.setBounds(340, 100, 150, 20);
		jbtn_eliminarVer.addActionListener(this);
		jpnl_manejoDatos.add(jbtn_eliminarVer);

		jpnl_configuracion = new JPanel();
		jtbp_tabs.addTab("Configuracion", jpnl_configuracion);

		// ******************************************************
		jdig_agregarEstudiante = new JDialog(ventana, "Agregar estudiante");
		jdig_agregarEstudiante.setLayout(null);
		jdig_agregarEstudiante.setSize(550, 370);
		jdig_agregarEstudiante.setResizable(false);
		jdig_agregarEstudiante.setLocationRelativeTo(null);

		jlbl_eligeGrupo = new JLabel("Elige un grupo:");
		jlbl_eligeGrupo.setBounds(10, 10, 120, 20);
		jdig_agregarEstudiante.add(jlbl_eligeGrupo);

		jcbx_listaGruposAgregar = new JComboBox<String>();
		jcbx_listaGruposAgregar.setBounds(150, 10, 120, 20);
		jdig_agregarEstudiante.add(jcbx_listaGruposAgregar);

		jlbl_primerNombre = new JLabel("Primer nombre:");
		jlbl_primerNombre.setBounds(10, 40, 120, 20);
		jdig_agregarEstudiante.add(jlbl_primerNombre);

		jtxt_primerNombre = new JTextField();
		jtxt_primerNombre.setBounds(10, 60, 120, 20);
		jdig_agregarEstudiante.add(jtxt_primerNombre);

		jlbl_segundoNombre = new JLabel("Segundo nombre:");
		jlbl_segundoNombre.setBounds(140, 40, 120, 20);
		jdig_agregarEstudiante.add(jlbl_segundoNombre);

		jtxt_segundoNombre = new JTextField();
		jtxt_segundoNombre.setBounds(140, 60, 120, 20);
		jdig_agregarEstudiante.add(jtxt_segundoNombre);

		jlbl_primerApellido = new JLabel("Primer apellido:");
		jlbl_primerApellido.setBounds(270, 40, 120, 20);
		jdig_agregarEstudiante.add(jlbl_primerApellido);

		jtxt_primerApellido = new JTextField();
		jtxt_primerApellido.setBounds(270, 60, 120, 20);
		jdig_agregarEstudiante.add(jtxt_primerApellido);

		jlbl_segundoApellido = new JLabel("Segundo apellido:");
		jlbl_segundoApellido.setBounds(400, 40, 120, 20);
		jdig_agregarEstudiante.add(jlbl_segundoApellido);

		jtxt_segundoApellido = new JTextField();
		jtxt_segundoApellido.setBounds(400, 60, 120, 20);
		jdig_agregarEstudiante.add(jtxt_segundoApellido);

		jsep_separador1 = new JSeparator(JSeparator.HORIZONTAL);
		jsep_separador1.setBounds(10, 90, 400, 2);
		jdig_agregarEstudiante.add(jsep_separador1);

		jlbl_notaPrimerExamenPrimerTrimestre = new JLabel("1re exa - 1re Tri");
		jlbl_notaPrimerExamenPrimerTrimestre.setBounds(10, 100, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaPrimerExamenPrimerTrimestre);

		jtxt_notaPrimerExamenPrimerTrimestre = new JTextField("0");
		jtxt_notaPrimerExamenPrimerTrimestre.setBounds(10, 120, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaPrimerExamenPrimerTrimestre);

		jlbl_notaSegundoExamenPrimerTrimestre = new JLabel("2do exa - 1re Tri");
		jlbl_notaSegundoExamenPrimerTrimestre.setBounds(140, 100, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaSegundoExamenPrimerTrimestre);

		jtxt_notaSegundoExamenPrimerTrimestre = new JTextField("0");
		jtxt_notaSegundoExamenPrimerTrimestre.setBounds(140, 120, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaSegundoExamenPrimerTrimestre);

		jlbl_notaPrimerTrimestre = new JLabel("Nota 1re tri");
		jlbl_notaPrimerTrimestre.setBounds(270, 100, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaPrimerTrimestre);

		jtxt_notaPrimerTrimestre = new JTextField("0");
		jtxt_notaPrimerTrimestre.setBounds(270, 120, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaPrimerTrimestre);

		jsep_separador2 = new JSeparator(JSeparator.HORIZONTAL);
		jsep_separador2.setBounds(10, 150, 400, 2);
		jdig_agregarEstudiante.add(jsep_separador2);

		jlbl_notaPrimerExamenSegundoTrimestre = new JLabel("1re exa - 2do Tri");
		jlbl_notaPrimerExamenSegundoTrimestre.setBounds(10, 160, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaPrimerExamenSegundoTrimestre);

		jtxt_notaPrimerExamenSegundoTrimestre = new JTextField("0");
		jtxt_notaPrimerExamenSegundoTrimestre.setBounds(10, 180, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaPrimerExamenSegundoTrimestre);

		jlbl_notaSegundoExamenSegundoTrimestre = new JLabel("2do exa - 2do Tri");
		jlbl_notaSegundoExamenSegundoTrimestre.setBounds(140, 160, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaSegundoExamenSegundoTrimestre);

		jtxt_notaSegundoExamenSegundoTrimestre = new JTextField("0");
		jtxt_notaSegundoExamenSegundoTrimestre.setBounds(140, 180, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaSegundoExamenSegundoTrimestre);

		jlbl_notaSegundoTrimestre = new JLabel("Nota 2do tri");
		jlbl_notaSegundoTrimestre.setBounds(270, 160, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaSegundoTrimestre);

		jtxt_notaSegundoTrimestre = new JTextField("0");
		jtxt_notaSegundoTrimestre.setBounds(270, 180, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaSegundoTrimestre);

		jsep_separador3 = new JSeparator(JSeparator.HORIZONTAL);
		jsep_separador3.setBounds(10, 210, 400, 2);
		jdig_agregarEstudiante.add(jsep_separador3);

		jlbl_notaPrimerExamenTercerTrimestre = new JLabel("1re exa - 3cer Tri");
		jlbl_notaPrimerExamenTercerTrimestre.setBounds(10, 220, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaPrimerExamenTercerTrimestre);

		jtxt_notaPrimerExamenTercerTrimestre = new JTextField("0");
		jtxt_notaPrimerExamenTercerTrimestre.setBounds(10, 240, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaPrimerExamenTercerTrimestre);

		jlbl_notaSegundoExamenTercerTrimestre = new JLabel("2do exa - 3cer Tri");
		jlbl_notaSegundoExamenTercerTrimestre.setBounds(140, 220, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaSegundoExamenTercerTrimestre);

		jtxt_notaSegundoExamenTercerTrimestre = new JTextField("0");
		jtxt_notaSegundoExamenTercerTrimestre.setBounds(140, 240, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaSegundoExamenTercerTrimestre);

		jlbl_notaTercerTrimestre = new JLabel("Nota 3cer tri");
		jlbl_notaTercerTrimestre.setBounds(270, 220, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaTercerTrimestre);

		jtxt_notaTercerTrimestre = new JTextField("0");
		jtxt_notaTercerTrimestre.setBounds(270, 240, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaTercerTrimestre);

		jsep_separador4 = new JSeparator(JSeparator.HORIZONTAL);
		jsep_separador4.setBounds(10, 270, 400, 2);
		jdig_agregarEstudiante.add(jsep_separador4);

		jlbl_notaFinal = new JLabel("Nota final");
		jlbl_notaFinal.setBounds(10, 280, 120, 20);
		jdig_agregarEstudiante.add(jlbl_notaFinal);

		jtxt_notaFinal = new JTextField("0");
		jtxt_notaFinal.setBounds(10, 300, 120, 20);
		jdig_agregarEstudiante.add(jtxt_notaFinal);

		jbtn_limpiarTodo = new JButton("Limpiar");
		jbtn_limpiarTodo.setBounds(270, 300, 120, 20);
		jbtn_limpiarTodo.addActionListener(this);
		jdig_agregarEstudiante.add(jbtn_limpiarTodo);

		jbtn_agregar = new JButton("Agregar");
		jbtn_agregar.setBounds(400, 300, 120, 20);
		jbtn_agregar.addActionListener(this);
		jdig_agregarEstudiante.add(jbtn_agregar);

		// ******************************************************

		jdig_eliminarVer = new JDialog(ventana, "Ver datos y Eliminar");
		jdig_eliminarVer.setLayout(null);
		jdig_eliminarVer.setResizable(false);
		jdig_eliminarVer.setSize(700, 500);
		jdig_eliminarVer.setLocationRelativeTo(null);

		jlbl_eligeGrupoVerEliminar = new JLabel("Elige un grupo");
		jlbl_eligeGrupoVerEliminar.setBounds(10, 10, 120, 20);
		jdig_eliminarVer.add(jlbl_eligeGrupoVerEliminar);

		jcbx_listaGruposMostrarEliminar = new JComboBox<String>();
		jcbx_listaGruposMostrarEliminar.setBounds(140, 10, 120, 20);
		jdig_eliminarVer.add(jcbx_listaGruposMostrarEliminar);

		jbtn_mostrar = new JButton("Mostrar estudiantes");
		jbtn_mostrar.setBounds(270, 10, 150, 20);
		jbtn_mostrar.addActionListener(this);
		jdig_eliminarVer.add(jbtn_mostrar);

		jbtn_eliminarGrupo = new JButton("Eliminar grupo");
		jbtn_eliminarGrupo.setBounds(430, 10, 120, 20);
		jbtn_eliminarGrupo.addActionListener(this);
		jdig_eliminarVer.add(jbtn_eliminarGrupo);

		jbtn_eliminarTodo = new JButton("Eliminar todo");
		jbtn_eliminarTodo.setBounds(560, 10, 120, 20);
		jdig_eliminarVer.add(jbtn_eliminarTodo);

		jtbl_estudiantes = new JTable();
		jtbl_estudiantes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtbl_estudiantes.setModel(new DefaultTableModel(new Object[][] { {},
				{}, {}, {}, {} , {}, {}, {}, {}, {}, {}, {}, {}, {} }, new String[] {}));

		jscr_tablaEstudiantes = new JScrollPane(jtbl_estudiantes);
		jscr_tablaEstudiantes.setBounds(10, 40, 670, 400);
		jscr_tablaEstudiantes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jscr_tablaEstudiantes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jdig_eliminarVer.add(jscr_tablaEstudiantes);

		// ******************************************************
		
		ventana.add(jtbp_tabs);
	}

	// ***********************************************************************

	public void setItemCombo_listaGrupos(ArrayList<String> item,
			JComboBox<String> combo) {
		combo.removeAllItems();

		for (int x = 0; x < item.size(); x++) {
			combo.addItem(item.get(x).toString());
		}

	}

	// ************************************************************************

	public void limpiar() {
		jtxt_primerNombre.setText("");
		jtxt_segundoNombre.setText("");
		jtxt_primerApellido.setText("");
		jtxt_segundoApellido.setText("");
		jtxt_notaPrimerExamenPrimerTrimestre.setText("0");
		jtxt_notaSegundoExamenPrimerTrimestre.setText("0");
		jtxt_notaPrimerExamenSegundoTrimestre.setText("0");
		jtxt_notaSegundoExamenSegundoTrimestre.setText("0");
		jtxt_notaPrimerExamenTercerTrimestre.setText("0");
		jtxt_notaSegundoExamenTercerTrimestre.setText("0");
		jtxt_notaPrimerTrimestre.setText("0");
		jtxt_notaSegundoTrimestre.setText("0");
		jtxt_notaTercerTrimestre.setText("0");
		jtxt_notaFinal.setText("0");
	}

	// ************************************************************************
	/**
	 * Action Listener
	 * 
	 * @param xp
	 */
	public void actionPerformed(ActionEvent xp) {
		if (xp.getSource() == jbtn_agregarEstudiante) {
			setItemCombo_listaGrupos(eventos.nombres(), jcbx_listaGruposAgregar);
			if (jcbx_listaGruposAgregar.getItemCount() > 0) {
				jdig_agregarEstudiante.setVisible(true);
				
			} else {
				JOptionPane.showMessageDialog(null, "No hay grupos", "Error!",
						JOptionPane.ERROR_MESSAGE);
				
			}

		} else if (xp.getSource() == jbtn_agregarGrupo) {
			eventos.insertarGrupo();

		} else if (xp.getSource() == jbtn_limpiarTodo) {
			limpiar();

		} else if (xp.getSource() == jbtn_agregar) {
			if (!jtxt_primerNombre.getText().isEmpty()
					& !jtxt_primerApellido.getText().isEmpty()) {

				Estudiante estudiante = new Estudiante(
						jtxt_primerNombre.getText(),
						jtxt_segundoNombre.getText(),
						jtxt_primerApellido.getText(),
						jtxt_segundoApellido.getText(),
						jtxt_notaPrimerExamenPrimerTrimestre.getText(),
						jtxt_notaSegundoExamenPrimerTrimestre.getText(),
						jtxt_notaPrimerTrimestre.getText(),
						jtxt_notaPrimerExamenSegundoTrimestre.getText(),
						jtxt_notaSegundoExamenSegundoTrimestre.getText(),
						jtxt_notaSegundoTrimestre.getText(),
						jtxt_notaPrimerExamenTercerTrimestre.getText(),
						jtxt_notaSegundoExamenTercerTrimestre.getText(),
						jtxt_notaTercerTrimestre.getText(),
						jtxt_notaFinal.getText());

				String tabla = (String) jcbx_listaGruposAgregar
						.getSelectedItem();
				eventos.insertarEstudiante(tabla, estudiante);
				limpiar();

			} else {
				JOptionPane.showMessageDialog(null,
						"Debe ingresar por lo menos un nombre y un apellido",
						"Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (xp.getSource() == jbtn_eliminarVer) {
			setItemCombo_listaGrupos(eventos.nombres(),
					jcbx_listaGruposMostrarEliminar);
			jdig_eliminarVer.setVisible(true);

		} else if (xp.getSource() == jbtn_eliminarGrupo) {
			
			setItemCombo_listaGrupos(eventos.nombres(),
					jcbx_listaGruposMostrarEliminar);
			
			if (jcbx_listaGruposMostrarEliminar.getItemCount()>0){
			
				String nombreGrupo = jcbx_listaGruposMostrarEliminar.getSelectedItem().toString();
				eventos.borrarGrupos(nombreGrupo);
				setItemCombo_listaGrupos(eventos.nombres(),
						jcbx_listaGruposMostrarEliminar);
			
			} else {
				JOptionPane.showMessageDialog(null, "No hay grupos!", "Error!", JOptionPane.ERROR_MESSAGE);
				
			}
			
		} else if (xp.getSource() == jbtn_mostrar){
			String nombreGrupo = jcbx_listaGruposMostrarEliminar.getSelectedItem().toString();
			eventos.mostrarEstudiantes((DefaultTableModel)jtbl_estudiantes.getModel(), nombreGrupo);
			
		}
	}
	
	// ************************************
	

}
