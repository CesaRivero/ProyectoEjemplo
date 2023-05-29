package UI;
import javax.swing.JOptionPane;

import Logica.*;

public class Main {
	public static void main(String[] args) {
		Negocio controlador = new Negocio();
		
		
		String []opciones = {"Ver clase","Guardar nuevo","Eliminar","Editar","Salir"};
		String opcion;
		String nombre="";
		String apellido ="";
		String dni ="";
		do {
			
	
		 opcion = (String)JOptionPane.showInputDialog(null,"mis opciones","Opcion",JOptionPane.DEFAULT_OPTION,null, opciones,opciones);
		
		switch (opcion) {
		case "Ver clase":
			if(controlador.Mostrar().isEmpty()  ) {
				JOptionPane.showMessageDialog(null, "Lista vacia");
			}else {

				JOptionPane.showMessageDialog(null, controlador.Mostrar());
			}
			
			
			break;
		case "Guardar nuevo":
			 nombre = JOptionPane.showInputDialog("Ingrese nombre de alumno");
			 apellido = JOptionPane.showInputDialog("Ingrese apellido de alumno");
			 dni = JOptionPane.showInputDialog("Ingrese dni de alumno");
		

			if (controlador.verificar(nombre, apellido, dni)) {
				
				JOptionPane.showMessageDialog(null, "Se guardo correctamente");
			}else {
				JOptionPane.showMessageDialog(null, " Hubo un error");

			}
			break;
		
		case "Eliminar":

			if(controlador.Mostrar().isEmpty()  ) {
				JOptionPane.showMessageDialog(null, "Lista vacia");
			}else {

				String [] opcioncitas = new String[controlador.Mostrar().size()];
				for (int i = 0; i <controlador.Mostrar().size() ; i++) {
					opcioncitas[i]=Integer.toString(controlador.Mostrar().get(i).getId());

				}
				int id;
				id= Integer.parseInt ((String)JOptionPane.showInputDialog(null,"Ingrese el id","",JOptionPane.DEFAULT_OPTION,null,opcioncitas,opcioncitas));


				if (controlador.eliminar(id)) {
					JOptionPane.showMessageDialog(null, "Se elimino con exito la persona con id" + id);
				}else {
					JOptionPane.showMessageDialog(null, "No se encontro el id, o no se pudo borrar");
				}
			}

			break;

			case "Editar":if(controlador.Mostrar().isEmpty()  ) {
				JOptionPane.showMessageDialog(null, "No hay personas para editar ");
			}else {

				String [] opcioncitas = new String[controlador.Mostrar().size()];
				for (int i = 0; i <controlador.Mostrar().size() ; i++) {
					opcioncitas[i]=Integer.toString(controlador.Mostrar().get(i).getId());

				}
				int id;
				id= Integer.parseInt ((String)JOptionPane.showInputDialog(null,"Ingrese el id","",JOptionPane.DEFAULT_OPTION,null,opcioncitas,opcioncitas));

				for (int i = 0; i <controlador.Mostrar().size() ; i++) {
					if (controlador.Mostrar().get(i).getId()==id){
						nombre = controlador.Mostrar().get(i).getNombre();
						apellido = controlador.Mostrar().get(i).getApellido();
						dni = controlador.Mostrar().get(i).getDni();


					}

				}

				String []opciones2 = {"Editar Nombre","Editar Apellido","Editar DNI", "Salir"};
				String opcion1;
				do {

				opcion1 = (String) JOptionPane.showInputDialog(null, "mis opciones", "Opcion", JOptionPane.DEFAULT_OPTION, null, opciones2, opciones2);

				switch (opcion1){

					case "Editar Nombre": nombre=JOptionPane.showInputDialog("Ingrese Nombre");

						break;
					case "Editar Apellido": apellido=JOptionPane.showInputDialog("Ingrese Apellido");
						break;

					case "Editar DNI":dni=JOptionPane.showInputDialog("Ingrese DNI");
						break;

					case "Salir":
						break;
				}


				}while (!opcion1.equals("Salir"));
						//funciona falta validar
				
				if (controlador.verificar(nombre, apellido, dni)) {
					
					if (controlador.editar(id, nombre, apellido , dni)) {
						JOptionPane.showMessageDialog(null, "Se edito con exito la persona con id" + id);
					}else {
						JOptionPane.showMessageDialog(null, "No se encontro el id, o no se pudo editar");
					}
				}else {
					JOptionPane.showMessageDialog(null, " Hubo un error");

				}
				
				
				
			
			}


				break;


		case "Salir":
			
			break;
			

		default:
			break;
		}
		
		}while(!opcion.equals("Salir"));
	}
}
