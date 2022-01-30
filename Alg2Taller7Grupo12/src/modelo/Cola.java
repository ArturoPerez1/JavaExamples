package modelo;

import java.lang.Math;

public class Cola {
	private Nodo inicioCola, finalCola;
	private String colaTexto = " ";

	public Nodo getInicioCola() {
		return inicioCola;
	}

	public Nodo getFinalCola() {
		return finalCola;
	}

	public String getColaTexto() {
		return colaTexto;
	}

	public Cola() {
		inicioCola = null;
		finalCola = null;
	}

	public boolean colaVacia() {
		if (inicioCola == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insertar(int informacion) {
		Nodo nuevo_nodo = new Nodo();
		nuevo_nodo.informacion = informacion;
		nuevo_nodo.siguiente = null;

		if (colaVacia()) {
			inicioCola = nuevo_nodo;
			finalCola = nuevo_nodo;
		} else {
			finalCola.siguiente = nuevo_nodo;
			finalCola = nuevo_nodo;
		}
	}

	public int mxtraer() {
		if (!colaVacia()) {
			int informacion = inicioCola.informacion;

			if (inicioCola == finalCola) {
				inicioCola = null;
				finalCola = null;
			} else {
				inicioCola = inicioCola.siguiente;
			}
			return informacion;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public void mostrarContenido() {
		Nodo recorrido = inicioCola;

		while (recorrido != null) {
			colaTexto += recorrido.informacion + " ->";
			recorrido = recorrido.siguiente;
		}
		colaTexto += " null";
	}

}
