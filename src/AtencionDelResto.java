
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
            Mesero mesero2 = new Mesero("Ramon");
            Mesero mesero3 = new Mesero("Agustina");
            Mesero mesero4 = new Mesero("Araceli");
            
            meseroData.nuevoMesero(mesero1);
            meseroData.nuevoMesero(mesero2);
            meseroData.nuevoMesero(mesero3);
            meseroData.nuevoMesero(mesero4);
            
            meseroData.eliminarMesero("Juan");
            meseroData.actualizarMesero(2, "Ramonsito");
            
            Mesero mesero = meseroData.buscarMesero("Agustina");
            System.out.println("Mesero: "+mesero.getNombre());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AtencionDelResto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
