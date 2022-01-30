package modelo;

import java.util.Random;

public class Modelo {
	private int dato;
	private Cola cola;
	private Nodo nodoCentral;
	private int numeroCentral;
	private String sumadosTexto;
	private int preCentral;
	private int resultado;

	public String getSumadosTexto() {
		return sumadosTexto;
	}

	public int getResultado() {
		return resultado;
	}

	public Cola getCola() {
		return cola;
	}

	public void cola(int informacion) {
		cola.insertar(informacion);
	}

	public int Random(int dimension) {
		Random random = new Random();
		int value = random.nextInt(10) + 1;

		return value;
	}

	public void generarCola(int dimension, int numeroN) {
		int cont = 0;
		this.cola = new Cola();

		while (cont < dimension) {
			dato = Random(dimension);
			cola(dato);
			cont++;
		}

		cola.mostrarContenido();
		obtenerNodoCentral(dimension);
		contarExtremos(dimension);
		sumaExtremosDelCentral(numeroN, dimension);
	}

	public void obtenerNodoCentral(int dimension) {
		numeroCentral = 0;
		int contador = 1;
		Nodo recorrido = cola.getInicioCola();

		if ((dimension % 2) != 0) {
			numeroCentral = (int) (Math.ceil(dimension / 2));
		}

		else {
			numeroCentral = (int) (dimension / 2);
		}

		while ((recorrido != null) && (contador <= numeroCentral)) {
			recorrido = recorrido.siguiente;
			contador++;
		}

		nodoCentral = recorrido;
	}

	public void contarExtremos(int dimension) {
		Nodo recorrido = cola.getInicioCola();
		preCentral = 1;

		while ((recorrido != null) && (preCentral < numeroCentral)) {
			recorrido = recorrido.siguiente;
			preCentral++;
		}

	}

	public void sumaExtremosDelCentral(int numeroN, int dimension) {
		Nodo recorrido = cola.getInicioCola();
		Nodo recorrido1 = nodoCentral;
		sumadosTexto = "";
		int preCentralAux = preCentral;
		resultado = 0;
		int contador = 2;

		if (numeroN == 1) {
			sumadosTexto = " ";
			sumadosTexto += nodoCentral.informacion;
			resultado = nodoCentral.informacion;
		}

		else if (numeroN == 2) {
			sumadosTexto = "";
			while (recorrido != nodoCentral && (preCentralAux > 1)) {
				recorrido = recorrido.siguiente;
				preCentralAux--;
			}
			sumadosTexto += recorrido.informacion + " ->";
			sumadosTexto += nodoCentral.informacion;
			resultado = recorrido.informacion + nodoCentral.informacion;

		}

		else if ((numeroN - contador < preCentral)) {
			resultado = nodoCentral.informacion + nodoCentral.siguiente.informacion;
			while (recorrido != nodoCentral && (contador <= numeroN)) {

				if (preCentralAux <= numeroN - contador) {
					sumadosTexto += recorrido.informacion + " ->";
					resultado += recorrido.informacion;
					contador++;
				}

				preCentralAux--;
				recorrido = recorrido.siguiente;

			}

			sumadosTexto += nodoCentral.informacion + " ->";
			sumadosTexto += nodoCentral.siguiente.informacion;
		}

		else if (numeroN - contador == preCentral) {
			resultado = nodoCentral.informacion + nodoCentral.siguiente.informacion;
			contador = 2;
			while (recorrido != nodoCentral) {
				sumadosTexto += recorrido.informacion + " ->";
				resultado += recorrido.informacion;
				recorrido = recorrido.siguiente;
				contador++;
			}

			sumadosTexto += nodoCentral.informacion + " ->";
			sumadosTexto += nodoCentral.siguiente.informacion;

		}

		else if (numeroN - contador > preCentral) {

			resultado = nodoCentral.informacion + nodoCentral.siguiente.informacion;
			while (recorrido != nodoCentral) {
				sumadosTexto += recorrido.informacion + " ->";
				resultado += recorrido.informacion;
				recorrido = recorrido.siguiente;

				contador++;
			}

			sumadosTexto += nodoCentral.informacion + " ->";
			sumadosTexto += nodoCentral.siguiente.informacion + " ->";

			recorrido1 = nodoCentral.siguiente;
			while (recorrido1 != null && (contador < numeroN)) {
				recorrido1 = recorrido1.siguiente;
				sumadosTexto += recorrido1.informacion + " ->";
				resultado += recorrido1.informacion;
				contador++;
			}

		}

		else if (numeroN == dimension) {
			resultado = nodoCentral.informacion + nodoCentral.siguiente.informacion;
			contador = 2;
			while (recorrido != null) {
				sumadosTexto += recorrido.informacion + " ->";
				resultado += recorrido.informacion;
				recorrido = recorrido.siguiente;
				contador++;
			}
		}
	}

}
