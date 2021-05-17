import java.util.Scanner;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	// Dado para elegir turno
	private static int dado;
	// Construimos el tablero
	private static boolean turno; // si es true jugador 1 si es false jugador2
	private static boolean salir = true;

	private static String tablero[] = { "_", "_", "_", "_", "_", "_", "_", "_", "_", "A", "B", "C", "1", "2", "3" };

	private static String nombreJugador1;
	private static String nombreJugador2;
	private static String nombreJugador;

	private static int tirada = 0;
	private static boolean gano = false;

	private static String posicion;

	private static int casilla;

	private static boolean correcto;

	public static void main(String[] args) {
		turno();
		do {
			String ficha = tirada % 2 == 0 ? "X" : "O";
			imprimirTablero(tablero);
			jugada(ficha, tablero);
			gano = victoria(tablero);
			if (gano) {
				imprimirTablero(tablero);
				System.out.println("Ganaste" + "! " + nombreJugador + " que mongolico");
			}
			if (tirada == 8 && !gano) {
				imprimirTablero(tablero);
				System.out.println("Empate!");
				gano = true;
			}

			tirada++;
		} while (!gano);

	}

	public static void imprimirTablero(String[] tablero) {
		System.out.println("    " + tablero[12] + "   " + tablero[13] + "   " + tablero[14]);
		System.out.println(tablero[9] + " | " + tablero[0] + " | " + tablero[1] + " | " + tablero[2] + " | ");
		System.out.println(tablero[10] + " | " + tablero[3] + " | " + tablero[4] + " | " + tablero[5] + " | ");
		System.out.println(tablero[11] + " | " + tablero[6] + " | " + tablero[7] + " | " + tablero[8] + " | ");
	}

	public static void jugada(String fichaJugador, String[] tablero) {
		boolean repetida = true;
		correcto = true;
		Scanner coordenada = new Scanner(System.in);
		nombreJugador = tirada % 2 == 0 ? nombreJugador1 : nombreJugador2;
		System.out.println("Selecciona donde quieres poner la ficha " + nombreJugador + ": ");
		posicion = coordenada.nextLine().toUpperCase();
		switch (posicion) {
		case "A1":
			casilla = 0;
			break;
		case "A2":
			casilla = 1;
			break;
		case "A3":
			casilla = 2;
			break;
		case "B1":
			casilla = 3;
			break;
		case "B2":
			casilla = 4;
			break;
		case "B3":
			casilla = 5;
			break;
		case "C1":
			casilla = 6;
			break;
		case "C2":
			casilla = 7;
			break;
		case "C3":
			casilla = 8;
			break;
		}
		//Coprobamos que la casilla esta ocupada, y si lo est� volvemos a poner ficha.
		if (tablero[casilla] == "X" || tablero[casilla] == "O") {
			System.out.println("No puedes poner una ficha ahi, vuelve a tirar.");
			tirada = tirada - 1;
		}
		//Si no ponemos la ficha de manera normal
		else {
			tablero[casilla] = fichaJugador;
		}
	}
	
	//Comprobamos que coincide 
	public static boolean victoria(String tablero[]) {
		if (tablero[0].equals(tablero[1]) && tablero[0].equals(tablero[2]) && !tablero[0].equals("_")) {
			return true;
		} else if (tablero[3].equals(tablero[4]) && tablero[3].equals(tablero[5]) && !tablero[3].equals("_")) {
			return true;
		} else if (tablero[6].equals(tablero[7]) && tablero[6].equals(tablero[8]) && !tablero[6].equals("_")) {
			return true;
		} else if (tablero[0].equals(tablero[3]) && tablero[0].equals(tablero[6]) && !tablero[0].equals("_")) {
			return true;
		} else if (tablero[1].equals(tablero[4]) && tablero[1].equals(tablero[7]) && !tablero[1].equals("_")) {
			return true;
		} else if (tablero[2].equals(tablero[5]) && tablero[2].equals(tablero[8]) && !tablero[2].equals("_")) {
			return true;
		} else if (tablero[0].equals(tablero[4]) && tablero[0].equals(tablero[8]) && !tablero[0].equals("_")) {
			return true;
		} else if (tablero[2].equals(tablero[4]) && tablero[2].equals(tablero[6]) && !tablero[2].equals("_")) {
			return true;
		}
		return false;

	}

	public static void turno() {
		boolean eleccion = true;
		System.out.println("Introduce el nombre del primer jugador: ");
		nombreJugador1 = sc.nextLine();
		System.out.println("El primer jugador es : " + nombreJugador1 + " y juega con X");
		System.out.println("Introduce el nombre del segundo jugador: ");
		nombreJugador2 = sc.nextLine();
		System.out.println("El segundo jugador es : " + nombreJugador2 + " y juega con O");

		while (eleccion) {
			int dado1 = (int) (Math.random() * (6 - 1 + 1) + 1);
			System.out.println(nombreJugador1 + " ha sacado un:" + dado1);
			int dado2 = (int) (Math.random() * (6 - 1 + 1) + 1);
			System.out.println(nombreJugador2 + " ha sacado un:" + dado2);

			if (dado1 > dado2) {
				System.out.println("Ha ganado: " + nombreJugador1 + " es tu turno!");
				eleccion = false;
			} else if (dado1 == dado2) {
				System.out.println("Empate! tirad otra vez!");
			} else {
				System.out.println("Ha ganado: " + nombreJugador2 + " es tu turno!");
				eleccion = false;
			}
		}

	}

}
