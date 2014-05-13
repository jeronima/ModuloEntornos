package documentacionTrabajo;

import java.util.ListIterator;

import utiles.Menu;
import utiles.Teclado;

/**
 * <pre>Crea una clase TestPila donde se añaden muchos elementos de la clase creada en el mismo
 * fichero (Persona, Paciente, Cartas...) y en la que se invocan a todos los métodos. 
 * Incluye una interfaz de texto para el usuario.
 * Al final, se vacía la pila con un bucle.
 * </pre>
 * 
 * @author Muñoz Godenir Christopher
 * @version 1.0
 */

public class TestPilaConMenu {

	/**
	 * Muestra los pacientes de la pila
	 * @param pila
	 */
	private static void mostrarPacientes(Pila<Paciente> pila) {
		ListIterator<Paciente> iterator = pila.getArrayList().listIterator(
				pila.getArrayList().size());
		while (iterator.hasPrevious())
			System.out.println(iterator.previous().toString());
	}
	/**
	 * Realiza una acción según la entrada introducida por el usuario.
	 * <ol>
	 * <li>Añadir Paciente </li>
	 * <li>Mostrar último paciente, comprobando si hay pacientes </li>
	 * <li>Eliminar el último paciente </li>
	 * <li>Mostrar pacientes </li>
	 * <li>Salir </li>
	 * </ol>
	 * En las opciones 2, 3 y 4 se comprueba si hay pacientes.
	 * @param pila Pila consultada
	 * @param opcion Opcion escogida por el usuario
	 */
	private static void realizarAccion(Pila<Paciente> pila, int opcion) {
		switch (opcion) {
		case 1:
			pila.push(new Paciente(Teclado
					.leerCadena("Introduce el nombre del paciente: "),
					Teclado.leerCadena("Introduce los apellidos: "),
					Teclado.leerCadena("Introduce la fecha de ingreso: "),
					Teclado.leerCadena("Introduce el diagnostico: ")));
			System.out.println(pila.top().toString()
					+ "\nAñadido con éxito\n");

		case 2:
			if (!pila.isEmpty()) {
				System.out.println(pila.top().toString());
			} else
				System.out.println("No hay pacientes");
			break;

		case 3:
			if (!pila.isEmpty()) {
				System.out.println(pila.top().toString()
						+ "\nHa sido eliminado");
				pila.pop();
			} else
				System.out.println("No hay pacientes");
			break;
		case 4:
			if (!pila.isEmpty())
				mostrarPacientes(pila);
			else
				System.out.println("No hay pacientes");
			break;
		case 5:
			System.out.println("¡Adios!");
			break;
		
		default:
			System.out.println("Error inesperado");
		}
	}
	
	/**
	 * Método principal del programa 
	 * @param args
	 */
	public static void main(String[] args) {
		Menu menu = new Menu(new String[] { "Añadir paciente",
				"Mostrar último paciente", "Eliminar el último paciente",
				"Mostrar pacientes", "Salir" });

		Pila<Paciente> pila = new Pila<Paciente>();

		pila.push(new Paciente("Pepito", "Gonzalez López", "11/12/2013",
				"Sin diagnosticar"));
		pila.push(new Paciente("María", "León Trujillo", "14/06/2012",
				"Gastroenteritis"));
		pila.push(new Paciente("Laura", "Muñoz Baena", "01/01/2014",
				"Fractura en la cien"));
		pila.push(new Paciente("Fulanito", "Gómez", "12/07/2011",
				"Tendinitis de hombros"));
		pila.push(new Paciente("Adrián", "Mancheño López", "26/05/2013",
				"Insuficiencia cardíaca"));

		int opcion;

		do {
			menu.mostrarInstrucciones();
			menu.mostrar();
			opcion = menu.getSeleccion();
			realizarAccion(pila, opcion);
		} while (opcion != 5);
	}
}
