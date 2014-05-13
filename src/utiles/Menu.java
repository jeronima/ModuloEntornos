package utiles;

/**
 * 1. Crea la clase “Menu”. Permitirá la creación y gestión de distintos menús.
 * Cuando manejamos un menú: a. Mostramos el menú b. Elegimos una opción válida
 * del menú c. Realizamos una acción en función de la opción elegida.
 * 
 * En la clase que diseñes deben aparecer al menos los siguientes métodos:
 * 
 * d. mostrarInstrucciones. Por ejemplo, “Elige una de las opciones (1-3)” e.
 * mostrarOpciones. Mostrará las distintas opciones del menú correctamente
 * identificadas del 1 en adelante. f. recogerOpcion. Leerá desde el teclado una
 * opción válida del menú
 * 
 * @author Muñoz Godenir Christopher
 * @version 1.0
 * 
 */
public class Menu {

	/**
	 * El número de opciones que ofrece el menú
	 */
	private int numeroDeOpciones;

	/**
	 * El índice de la opción que permite salir
	 */
	private int salida;

	/**
	 * Las opciones del menú
	 */
	private String[] opciones;

	/**
	 * Constructor con parámetros
	 * 
	 * @param opciones
	 *            Las opciones del menú
	 */
	public Menu(String[] opciones) {
		this(opciones, ")");
	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param opciones
	 *            Opciones del menú
	 * @param salida
	 *            Índice de la opción de salida
	 */
	public Menu(String[] opciones, int salida) {
		this(opciones, ")", salida);
	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param opciones
	 *            Opciones del menú
	 * @param simbolo
	 *            Un símbolo o cadena que se colocará justo después del número,
	 *            por ej: ".", ")", "]"
	 */
	public Menu(String[] opciones, String simbolo) {
		this(opciones, simbolo, opciones.length);
	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param opciones
	 *            Opciones del menú
	 * @param simbolo
	 *            Un símbolo o cadena que se colocará justo después del número,
	 *            por ej: ".", ")", "]"
	 * @param salida
	 *            Índice de la opción de salida
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
	 * Devuelve el número de opciones
	 * 
	 * @return El número de opciones
	 */
	public int getNumeroDeOpciones() {
		return numeroDeOpciones;
	}

	/**
	 * Cambia el número de opciones
	 * 
	 * @param numeroDeOpciones
	 *            El nuevo número de opciones
	 */
	public void setNumeroDeOpciones(int numeroDeOpciones) {
		this.numeroDeOpciones = numeroDeOpciones;
	}

	/**
	 * Devuelve las opciones del menú
	 * 
	 * @return Las opciones del menú
	 */
	public String[] getOpciones() {
		return opciones;
	}

	/**
	 * Cambia las opciones del menú
	 * 
	 * @param opciones
	 *            Las nuevas opciones del menú
	 */
	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	/**
	 * Devuelve el índice de la opción que permite salir
	 * 
	 * @return El índice de la opción que permite salir
	 */
	public int getSalida() {
		return salida;
	}

	/**
	 * Cambia el índice de salida por otro
	 * 
	 * @param salida
	 *            El índice de salida
	 */
	private void setSalida(int salida) {
		this.salida = salida;
	}

	/**
	 * Muestra las instrucciones en pantalla
	 */
	public void mostrarInstrucciones() {
		System.out.println("Elige una opción (1-" + getNumeroDeOpciones() + ")");
	}

	/**
	 * Muestra las opciones en pantalla
	 */
	public void mostrar() {
		for (String opcion : opciones)
			System.out.println(opcion);
	}

	/**
	 * Muestra un mensaje de error en pantalla por introducir una opción
	 * inválida en el menú de opciones
	 */
	private void mensajeOpcionIncorrecta() {
		System.out.println("Opción incorrecta.");
	}

	/**
	 * Recoge la opción del usuario
	 * 
	 * @return La opción del usuario
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
