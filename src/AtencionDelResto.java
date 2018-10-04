
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;

public class AtencionDelResto {
    
    public static void main(String[] args) {
        Conexion conexion;
        try {
            conexion = new Conexion();
            conexion.cerrarConexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AtencionDelResto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
