
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conn = null;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";//Paquete del driver
    private static final String URL = "jdbc:mysql://localhost:3306/atencion_del_resto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//Direccion de la base de datos

    public Conexion() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);//Cargamos las clases
        conn = DriverManager.getConnection(URL, "root", "");//Obtenemos la conexion
        System.out.println("Conectado a la base de datos");//Confirmamos que todo salio bien
    }
    
    public Connection getConexion() {
        return conn;//Devolvemos la conexion
    }
    
    public void cerrarConexion() throws SQLException {
        conn.close();//Cerramos la conexion
        System.out.println("Se cerro la conexión");//Confirmamos que todo salio bien
    }

}