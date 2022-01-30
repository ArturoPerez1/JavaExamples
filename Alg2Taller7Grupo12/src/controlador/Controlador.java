package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Modelo;
import vista.Vista;

public class Controlador {
	private Vista vistaTallerEnteros = new Vista();
	private Modelo modeloTallerEnteros = new Modelo();

	public Controlador(Vista vistaTallerEnteros, Modelo modeloTallerEnteros) {
		this.vistaTallerEnteros = vistaTallerEnteros;
		this.modeloTallerEnteros = modeloTallerEnteros;

		vistaTallerEnteros.listenerAction(new listenerVistaTallerEnteros());
	}

	public class listenerVistaTallerEnteros implements ActionListener {
		public void actionPerformed(ActionEvent eventoVista) {
			int dimension = 0;
			int numeroN = 0;

			try {

				if (eventoVista.getSource() == vistaTallerEnteros.getBoton1()) {
					vistaTallerEnteros.setDimensionJOptionPane();
					dimension = vistaTallerEnteros.getDimension();

					vistaTallerEnteros.setNumeroNJOptionPane();
					numeroN = vistaTallerEnteros.getNumeroN();

					if (dimension > 1) {
						if ((dimension != 0) && (numeroN != 0)) {

							if (dimension >= numeroN) {
								modeloTallerEnteros.generarCola(dimension, numeroN);
								vistaTallerEnteros
										.mensajeGeneral("Cola: " + modeloTallerEnteros.getCola().getColaTexto());
								vistaTallerEnteros
										.mensajeGeneral("Nodos Sumados: " + modeloTallerEnteros.getSumadosTexto());
								vistaTallerEnteros.mensajeGeneral(
										"Resultado: " + String.valueOf(modeloTallerEnteros.getResultado()));
							}

							else {
								vistaTallerEnteros.mensajeError("LA DIMENSIÓN DEBE SER > AL NÚMERO N");
							}
						}

						else if (dimension == 0) {
							vistaTallerEnteros.mensajeError("LLENAR LA DIMENSIÓN");
						}

						else if (numeroN == 0) {
							vistaTallerEnteros.mensajeError("LLENAR EL NÚMERON");
						}

					}

					else {
						vistaTallerEnteros.mensajeError("LA DIMENSION TIENE QUE SER > A 1");
					}
				}

			} catch (NumberFormatException e) {
				vistaTallerEnteros.mensajeError("SOLO SE ACEPTAN NÚMEROS");
			}

		}
	}
}
