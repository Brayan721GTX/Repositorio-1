
import vistas.Principal;
import modelo.Conexion;

public class AtencionDelResto {
    
    public static void main(String[] args) {
        Conexion conexion;
        //conexion = new Conexion();
        
        /*MeseroData meseroData = new MeseroData(conexion);
        
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
        System.out.println("Mesero: "+mesero.getNombre());*/
        
        Principal p = new Principal();
        p.setVisible(true);
    }
    
}
