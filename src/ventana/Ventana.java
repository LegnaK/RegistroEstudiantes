package ventana;

/**
 * 
 * @author Rodolfo
 */
public class Ventana extends javax.swing.JFrame  {

	private BarraMenu barraMenu;
	private TabsPaneles tabsPaneles;

	/**
	 * Constructor
	 */
	public Ventana() {
		setTitle("Registro de estudiantes");
		setSize(530, 220);
		setResizable(false);
		initComponentes();
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	/**
	 * Inicializa los elementos de la GUI
	 */
	public void initComponentes() {

		barraMenu = new BarraMenu(this);
		barraMenu.initMenuBarra();
		tabsPaneles = new TabsPaneles(this);
		tabsPaneles.initTabsPaneles();


	}
}
