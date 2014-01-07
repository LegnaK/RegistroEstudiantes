package ventana;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class BarraMenu implements ActionListener{

	private Ventana ventana;

	private JMenuBar jmbr_menu;
	private JMenu jmnu_archivo;
	private JMenu jmnu_informacion;
	private JMenuItem jmit_salir;
	private JMenuItem jmit_acerca;
	
	private JDialog jdig_acerca;
	private JTextArea jtxt_acerca;
	private JButton jbtn_acercaSalir;
	
	private Eventos eventos;
	
	public BarraMenu(Ventana ventana){
		this.ventana = ventana;
		eventos = new Eventos(this);
	}
		
	public void initMenuBarra(){
		jmbr_menu = new JMenuBar();
	
		jmnu_archivo = new JMenu("Archivo");
		jmbr_menu.add(jmnu_archivo);
		
		jmit_salir = new JMenuItem("Salir");
		jmit_salir.addActionListener(this);
		jmnu_archivo.add(jmit_salir);
		
		jmnu_informacion = new JMenu("Informacion");
		jmbr_menu.add(jmnu_informacion);
		
		jmit_acerca = new JMenuItem("Acerca");
		jmit_acerca.addActionListener(this);
		jmnu_informacion.add(jmit_acerca);
		
		jdig_acerca = new JDialog();
		jdig_acerca.setSize(320, 210);
		jdig_acerca.setLayout(new FlowLayout());
		jdig_acerca.setBackground(Color.black);
		jdig_acerca.setResizable(false);
		jdig_acerca.setLocationRelativeTo(ventana);
		
		jtxt_acerca = new JTextArea();
		jtxt_acerca.setEditable(false);
		jtxt_acerca.setForeground(Color.white);
		jtxt_acerca.setBackground(Color.black);
		jdig_acerca.add(jtxt_acerca);
		
		jbtn_acercaSalir = new JButton("Salir");
		jbtn_acercaSalir.addActionListener(this);
		jdig_acerca.add(jbtn_acercaSalir);
		
		ventana.setJMenuBar(jmbr_menu);
	}

	public void actionPerformed(ActionEvent xp) {
		if (xp.getSource() == jmit_acerca){
			jtxt_acerca.setText("  Aplicacion para la gestion de estudiantes."
					+ "\n\n  Uiliza tecnologia SQLite para gestionar los usuarios\n  y los estudiantes."
					+ "\n\n  Programacion y Diseño: Rodolfo Sequeira Rodriguez."
					+ "\n\n  Version 0.1.1a (Alpha)");
			jdig_acerca.setVisible(true);
			
		}
		
		else if (xp.getSource() == jbtn_acercaSalir){
			jdig_acerca.setVisible(false);
			
		}
		
		// *****************
		
		if (xp.getSource() == jmit_salir){
			eventos.salir();
			
		}
		
	}
	
}
