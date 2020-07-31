package died.ejemplos.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private static final String url ="jdbc:postgresql://localhost:5432/postgres?searchpath=public";
	private static final String user= "postgres";
	private static final String pass= "postgres";
	
	private static boolean _TABLAS_CREADAS = false;
	
	private static final String TABLA_CREATE_CAMION = 
			"CREATE TABLE IF NOT EXISTS camion ( "+
		             "id integer PRIMARY KEY, "+
		             "patente varchar(15), "+
		             "marca varchar(45), "+
		             "modelo varchar(45), "+
		             "km varchar(45), "+
		             "costo_km numeric(12,2), "+
		             "costo_hora numeric(12,2), "+
		             "fecha_compra date )";
			
//			"CREATE TABLE  IF NOT EXISTS 'died'.'camion' ( "+
//			"		  'ID` INT NOT NULL AUTO_INCREMENT, "+
//			"		  'PATENTE' VARCHAR(14) NULL, "+
//			"		  'MARCA' VARCHAR(45) NULL, "+
//			"		  'MODELO' VARCHAR(45) NULL, "+
//			"		  'KM' VARCHAR(45) NULL, "+
//			"		  'COSTO_KM' DECIMAL(12,2) NULL, "+
//			"		  'COSTO_HORA' DECIMAL(12,2) NULL, "+
//			"		  'FECHA_COMPRA' DATETIME NULL, "+
//			"		  PRIMARY KEY (`ID`)) ";


	private DB(){
			// no se pueden crear instancias de esta clase
	}
	
	private static void verificarCrearTablas() {
		if(!_TABLAS_CREADAS) {
			Connection conn = DB.crearConexion();
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				boolean tablaCamionCreada = stmt.execute(TABLA_CREATE_CAMION);
				_TABLAS_CREADAS = tablaCamionCreada;
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
					try {
						if(stmt!=null) stmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}
	
	private static Connection crearConexion(){
	Connection conn=null;
	try {
		Class.forName("org.postgresql.Driver");
		conn= DriverManager.getConnection(url,user,pass);
	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	return conn;
	}

	public static Connection getConexion() {
		verificarCrearTablas();
		return crearConexion();
	}

//	private static Connection crearConexion(){
//		Connection conn=null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn= DriverManager.getConnection(url,user,pass);
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public static Connection getConexion() {
//		verificarCrearTablas();
//		return crearConexion();
//	}
	
}
