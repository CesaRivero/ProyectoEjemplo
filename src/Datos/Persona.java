package Datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.LinkedList;

import interfacez.conexionBD;


public class Persona implements conexionBD{
	
	private String dni;
	private String nombre;
	private String apellido;

	private  int id;
	
	Conexion con =  new Conexion();;
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public Persona(String dni, String nombre, String apellido, int id) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.id= id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "\nPersona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", id= "+id;
	}
	
	public boolean guardar() {
		
		String sql ="INSERT INTO `persona`(`dni`, `nombre`, `apellido`) VALUES (?,?,?) ";
		
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1, this.getDni());
			stmt.setString(2, this.getNombre());
			stmt.setString(3, this.getApellido());
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Hubo un error"+e.getMessage());
			return false;
		}
	}
public LinkedList<Persona> Mostrar() {
	LinkedList<Persona> Personas = new LinkedList<Persona>();
		String sql ="SELECT * FROM `persona`";
		
		String[] datos= new String[4];
		try {
			stmt = conexion.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				datos[0]= result.getString(1);
				datos[1]= result.getString(2);
				datos[2]= result.getString(3);
				datos[3]= result.getString(4);

				Personas.add(new Persona(datos[0],datos[1],datos[2],Integer.parseInt(datos[3])));
			}
			return Personas;
			
		} catch (Exception e) {
			System.out.println("Hubo un error"+e.getMessage());
			return null;
		}
	}

public boolean eliminar(int indice) {
	
	String sql ="DELETE FROM `persona` WHERE id = ?";
	System.out.println(indice);
	try {
		stmt = conexion.prepareStatement(sql);
		stmt.setLong(1, indice);

		stmt.executeUpdate();
		return true;
		
	} catch (Exception e) {
		System.out.println("Hubo un error"+e.getMessage());
		return false;
	}
}

public boolean editar (int indice){

	String sql ="UPDATE `persona` SET `dni`=?,`nombre`=?,`apellido`=? WHERE id = ?";
	System.out.println(indice);
	try {
		stmt = conexion.prepareStatement(sql);
		stmt.setString(1,this.getDni());
		stmt.setString(2,this.getNombre());
		stmt.setString(3,this.getApellido());
		stmt.setLong(4, indice);

		stmt.executeUpdate();
		return true;

	} catch (Exception e) {
		System.out.println("Hubo un error"+e.getMessage());
		return false;
	}


}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
