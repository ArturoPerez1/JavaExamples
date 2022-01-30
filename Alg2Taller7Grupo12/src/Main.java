import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class Main {

	public static void main(String[] args) {
		Vista vistaTallerEnteros = new Vista();
		Modelo modeloTallerEnteros = new Modelo();
		
		Controlador controladorTallerEnteros = new Controlador(vistaTallerEnteros, modeloTallerEnteros);
		vistaTallerEnteros.setVisible(true);
	}

}
