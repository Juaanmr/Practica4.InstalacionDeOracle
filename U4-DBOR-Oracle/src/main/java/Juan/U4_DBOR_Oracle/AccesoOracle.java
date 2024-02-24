package Juan.U4_DBOR_Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccesoOracle {
	private Connection con;
	void abrirConexion() {		
		try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:49685:XE",
						"SYS as SYSDBA","1234");
	System.out.println("Conexion OK");
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	void cerrarConexion() {
		try{
			System.out.println("Conexion cerrada");
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	void mostrarContactos() {
		try {
		// Create a statement
		Statement st = con.createStatement();
		ResultSet resul = st.executeQuery("SELECT c.nombre, c.telefono FROM contactos c");
		System.out.println("INFORMACION DE CONTACTOS--------------");
				
		while(resul.next()){
			//aquí tambien podriamos poner resul.getInt("nif");
			System.out.printf("\nNOMBRE: %s\nTELEFONO: %s", resul.getString(1), resul.getString(2));
	}
		System.out.println("\n--------------");
		resul.close();
		st.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void crearTable() {
		try {
		// Create a statement
		Statement st = con.createStatement();
		ResultSet resul = st.executeQuery("CREATE TABLE misAlumnos of estudiante");
		System.out.println("TABLA misAlumnos Creada--------------");
				
		
		System.out.println("\n--------------");
		resul.close();
		st.close();
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Tabla no creada");
		}
	}
	
	void insertarAlumnos() {
		try {
		// Create a statement
		Statement st = con.createStatement();
		ResultSet resul = st.executeQuery("INSERT INTO misAlumnos VALUES(estudiante('02A', persona('Pepe','987653214')))");
		System.out.println("ALUMNO insertado--------------");
				
		
		System.out.println("\n--------------");
		resul.close();
		st.close();
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Alumno no creado");
		}
	}
	
	void borrarAlumno(String nombre) {
		try {
		// Create a statement
		Statement st = con.createStatement();
		ResultSet resul = st.executeQuery("DELETE FROM misAlumnos a WHERE a.datos_personales.nombre='" + nombre + "'");
		System.out.println("ALUMNO borrado--------------");
				
		
		System.out.println("\n--------------");
		resul.close();
		st.close();
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Alumno no borrado con exito");
		}
	}
	
	public void buscarTelefonoPorNombre(String nombre) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT a.datos_personales.telefono FROM misAlumnos a WHERE a.datos_personales.nombre='" + nombre + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.printf("Teléfono: " + rs.getString(1));
            } else {
                System.out.println("No se encontró el alumno");
            }
            System.out.println("\n--------------");
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void mostrarTodosLosAlumnos() {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT a.id_estudiante, a.datos_personales.nombre, a.datos_personales.telefono FROM misAlumnos a";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	System.out.printf("ID: %s, Nombre: %s, Teléfono: %s%n", rs.getString(1), rs.getString(2), rs.getString(3));
            }
            System.out.println("\n--------------");
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void mostrarInfoAdmitidos() {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT ad.dia, ad.matriculado.id_estudiante, ad.matriculado.datos_personales.nombre, ad.matriculados.datos_personales.telefono FROM admitidos ad";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	System.out.printf("Día: %s, ID: %s, Nombre: %s, Teléfono: %s%n", rs.getDate(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            System.out.println("\n--------------");
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}