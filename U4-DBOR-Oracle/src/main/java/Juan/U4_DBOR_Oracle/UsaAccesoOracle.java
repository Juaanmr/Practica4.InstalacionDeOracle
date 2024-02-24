package Juan.U4_DBOR_Oracle;

public class UsaAccesoOracle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccesoOracle a = new AccesoOracle();
		a.abrirConexion();
		//a.mostrarContactos();
		//a.crearTable();
		//a.insertarAlumnos();
		//a.borrarAlumno("Pepe");
		//a.buscarTelefonoPorNombre("David");
		//a.mostrarTodosLosAlumnos();
		a.mostrarInfoAdmitidos();
		a.cerrarConexion();
	}
}
