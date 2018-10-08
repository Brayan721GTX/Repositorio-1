
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Mesero;
import modelo.MeseroData;

public class AtencionDelResto {
    
    public static void main(String[] args) {
        Conexion conexion;
        try {
            conexion = new Conexion();
            MeseroData meseroData = new MeseroData(conexion);
            Mesero mesero1 = new Mesero("Juan");
            meseroData.nuevoMesero(mesero1);
            conexion.cerrarConexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AtencionDelResto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
