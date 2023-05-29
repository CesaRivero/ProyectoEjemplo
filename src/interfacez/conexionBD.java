package interfacez;
import java.util.LinkedList;

import Datos.Persona;

public interface conexionBD {
	boolean guardar();
	boolean editar(int indice);
	boolean eliminar(int indice);
	
}
