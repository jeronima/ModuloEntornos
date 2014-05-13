package utiles;

/**
 * 1. Crea la clase �Menu�. Permitir� la creaci�n y gesti�n de distintos men�s.
 * Cuando manejamos un men�: a. Mostramos el men� b. Elegimos una opci�n v�lida
 * del men� c. Realizamos una acci�n en funci�n de la opci�n elegida.
 * 
 * En la clase que dise�es deben aparecer al menos los siguientes m�todos:
 * 
 * d. mostrarInstrucciones. Por ejemplo, �Elige una de las opciones (1-3)� e.
 * mostrarOpciones. Mostrar� las distintas opciones del men� correctamente
 * identificadas del 1 en adelante. f. recogerOpcion. Leer� desde el teclado una
 * opci�n v�lida del men�
 * 
 * @author Mu�oz Godenir Christopher
 * @version 1.0
 * 
 */
public class Menu {

	/**
	 * El n�mero de opciones que ofrece el men�
	 */
	private int numeroDeOpciones;

	/**
	 * El �ndice de la opci�n que permite salir
	 */
	private int salida;

	/**
	 * Las opciones del men�
	 */
	private String[] opciones;

	/**
	 * Constructor con par�metros
	 * 
	 * @param opciones
	 *            Las opciones del men�
	 */
	public Menu(String[] opciones) {
		this(opciones, ")");
	}

	/**
	 * Constructor con par�metros
	 * 
	 * @param opciones
	 *            Opciones del men�
	 * @param salida
	 *            �ndice de la opci�n de salida
	 */
	public Menu(String[] opciones, int salida) {
		this(opciones, ")", salida);
	}

	/**
	 * Constructor con par�metros
	 * 
	 * @param opciones
	 *            Opciones del men�
	 * @param simbolo
	 *            Un s�mbolo o cadena que se colocar� justo despu�s del n�mero,
	 *            por ej: ".", ")", "]"
	 */
	public Menu(String[] opciones, String simbolo) {
		this(opciones, simbolo, opciones.length);
	}

	/**
	 * Constructor con par�metros
	 * 
	 * @param opciones
	 *            Opciones del men�
	 * @param simbolo
	 *            Un s�mbolo o cadena que se colocar� justo despu�s del n�mero,
	 *            por ej: ".", ")", "]"
	 * @param salida
	 *            �ndice de la opci�n de salida
	 */
	public Menu(String[] opciones, String simbolo, int salida) {
		if (salida < 1 || salida > opciones.length)
			salida = opciones.length;

		setOpciones(new String[opciones.length]);

		for (int i = 0; i < opciones.length; i++)
			getOpciones()[i] = (i + 1) + simbolo + " " + opciones[i];

		setNumeroDeOpciones(opciones.length);
		setSalida(salida);
	}

	/**
	 * Devuelve el n�mero de opciones
	 * 
	 * @return El n�mero de opciones
	 */
	public int getNumeroDeOpciones() {
		return numeroDeOpciones;
	}

	/**
	 * Cambia el n�mero de opciones
	 * 
	 * @param numeroDeOpciones
	 *            El nuevo n�mero de opciones
	 */
	public void setNumeroDeOpciones(int numeroDeOpciones) {
		this.numeroDeOpciones = numeroDeOpciones;
	}

	/**
	 * Devuelve las opciones del men�
	 * 
	 * @return Las opciones del men�
	 */
	public String[] getOpciones() {
		return opciones;
	}

	/**
	 * Cambia las opciones del men�
	 * 
	 * @param opciones
	 *            Las nuevas opciones del men�
	 */
	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	/**
	 * Devuelve el �ndice de la opci�n que permite salir
	 * 
	 * @return El �ndice de la opci�n que permite salir
	 */
	public int getSalida() {
		return salida;
	}

	/**
	 * Cambia el �ndice de salida por otro
	 * 
	 * @param salida
	 *            El �ndice de salida
	 */
	private void setSalida(int salida) {
		this.salida = salida;
	}

	/**
	 * Muestra las instrucciones en pantalla
	 */
	public void mostrarInstrucciones() {
		System.out.println("Elige una opci�n (1-" + getNumeroDeOpciones() + ")");
	}

	/**
	 * Muestra las opciones en pantalla
	 */
	public void mostrar() {
		for (String opcion : opciones)
			System.out.println(opcion);
	}

	/**
	 * Muestra un mensaje de error en pantalla por introducir una opci�n
	 * inv�lida en el men� de opciones
	 */
	private void mensajeOpcionIncorrecta() {
		System.out.println("Opci�n incorrecta.");
	}

	/**
	 * Recoge la opci�n del usuario
	 * 
	 * @return La opci�n del usuario
	 */
	public int getSeleccion() {
		int eleccion;

		do {
			eleccion = Teclado.leerEntero();

			if (eleccion < 1 || eleccion > getNumeroDeOpciones())
				mensajeOpcionIncorrecta();

		} while (eleccion < 1 || eleccion > getNumeroDeOpciones());

		return eleccion;
	}
}
