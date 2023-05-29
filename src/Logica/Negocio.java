package Logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Datos.*;
import interfacez.Verificar;
import interfacez.conexionBD;

public class Negocio implements Verificar{
	

	public Negocio() {
		super();
	}


	Persona controlador = new Persona("","","",0);
	
	public LinkedList<Persona> Mostrar() {
		
		return controlador.Mostrar();
	}
	
	public boolean eliminar(int indice) {
		if(indice>0) {
			return controlador.eliminar(indice);
		}else {
			return false;
		}
	
	}

	public boolean editar(int indice, String nombre, String apellido, String dni) {
		if(indice>0) {
			controlador.setNombre(nombre);
			controlador.setApellido(apellido);
			controlador.setDni(dni);
			
			return controlador.editar(indice);
		}else {
			return false;
		}

	}
	
	//ver como es la verificacion de otro metodo
	public boolean verificar(String nombre,String apellido,String dni ) {
		int flag = 0 ;
		do {
		if (nombre.length()>=3 && nombre.length()<=15 ) {
			if (apellido.length()>=3 && apellido.length()<=15 ) {
				if (dni.length()==8) {
					controlador.setNombre(nombre);
					controlador.setApellido(apellido);
					controlador.setDni(dni);
					return controlador.guardar();
				}else{
					dni = JOptionPane.showInputDialog("Error el dni debe tener 8 caracteres \n Ingrese dni de alumno"); 
				}
			}else {
				apellido = JOptionPane.showInputDialog("Error apellido  debe tener entre 3 y 15 letras   \n Ingrese apellido de alumno");
			}
			
		}else {
			nombre = JOptionPane.showInputDialog("Error el nombre debe tener entre 3 y 15 letras \n Ingrese nombre de alumno");
		}
		}while(flag==0);
			
		return (Boolean) null;
		
		
	}


	@Override
	public boolean verificarAlgo() {
		// TODO Auto-generated method stub
		return false;
	}

	



	
}
