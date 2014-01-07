package objetos;

import java.math.BigInteger;

/**
 * 
 * @author Rodolfo
 */
public class Estudiante {

	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;

	private BigInteger primerExaPrimerTri;
	private BigInteger segundoExaPrimerTri;
	
	private BigInteger primerExaSegundoTri;
	private BigInteger segundoExaSegundoTri;

	private BigInteger primerExaTercerTri;
	private BigInteger segundoExaTercerTri;
	
	private BigInteger primerTri;
	private BigInteger segundoTri;
	private BigInteger tercerTri;
	
	private BigInteger notaFinal;

	/**
	 * Constrcutor
	 */
	public Estudiante(
			String primerN, String segundoN,
			String primerA, String segundoA, 
			String nota1Ex1Tri, String nota2Ex1Tri,  String nota1Tri, 
			String nota1Ex2Tri, String nota2Ex2Tri, String nota2Tri, 
			String nota1Ex3Tri, String nota2Ex3Tri, String nota3Tri, 
			String notaFinal
			) {
		
		setPrimerNombre(primerN);
		setSegundoNombre(segundoN);
		setPrimerApellido(primerA);
		setSegundoApellido(segundoA);
		
		 setPrimerExaPrimerTri(nota1Ex1Tri);
		setSegundoExaPrimerTri(nota2Ex1Tri);
		setPrimerTri(nota1Tri);
		setPrimerExaSegundoTri(nota1Ex2Tri);
		setSegundoExaSegundoTri(nota2Ex2Tri);
		setSegundoTri(nota2Tri);
		setPrimerExaTercerTri(nota1Ex3Tri);
		setSegundoExaTercerTri(nota2Ex3Tri);
		setTercerTri(nota3Tri);
		setNotaFinal(notaFinal);
			}
	

	// *****************************************************

	// *****************************************************

	public void setPrimerNombre(String primerN) {
		this.primerNombre = primerN;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setSegundoNombre(String segundoN) {
		this.segundoNombre = segundoN;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setPrimerApellido(String primerA) {
		this.primerApellido = primerA;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setSegundoApellido(String segundoA) {
		this.segundoApellido = segundoA;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public BigInteger getPrimerExaPrimerTri() {
		return primerExaPrimerTri;
	}

	public void setPrimerExaPrimerTri(String primerExamen) {
		this.primerExaPrimerTri = new BigInteger(primerExamen);
	}

	public BigInteger getSegundoExaPrimerTri() {
		return segundoExaPrimerTri;
	}

	public void setSegundoExaPrimerTri(String segundoExamen) {
		this.segundoExaPrimerTri = new BigInteger(segundoExamen);
	}

	public BigInteger getPrimerExaSegundoTri() {
		return primerExaSegundoTri;
	}

	public void setPrimerExaSegundoTri(String tercerExamen) {
		this.primerExaSegundoTri = new BigInteger(tercerExamen);
	}

	public BigInteger getSegundoExaSegundoTri() {
		return segundoExaSegundoTri;
	}

	public void setSegundoExaSegundoTri(String segundoExaSegundoTri) {
		this.segundoExaSegundoTri = new BigInteger(segundoExaSegundoTri);
	}

	public BigInteger getSegundoExaTercerTri() {
		return segundoExaTercerTri;
	}

	public void setSegundoExaTercerTri(String segundoExaTercerTri) {
		this.segundoExaTercerTri = new BigInteger(segundoExaTercerTri);
	}

	public BigInteger getPrimerExaTercerTri() {
		return primerExaTercerTri;
	}

	public void setPrimerExaTercerTri(String primerExaTercerTri) {
		this.primerExaTercerTri = new BigInteger(primerExaTercerTri);
	}

	public BigInteger getPrimerTri() {
		return primerTri;
	}

	public void setPrimerTri(String primerTri) {
		this.primerTri = new BigInteger(primerTri);
	}

	public BigInteger getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(String notaFinal) {
		this.notaFinal = new BigInteger(notaFinal);
	}

	public BigInteger getTercerTri() {
		return tercerTri;
	}

	public void setTercerTri(String tercerTri) {
		this.tercerTri = new BigInteger(tercerTri);
	}

	public BigInteger getSegundoTri() {
		return segundoTri;
	}

	public void setSegundoTri(String segundoTri) {
		this.segundoTri = new BigInteger(segundoTri);
	}

}
