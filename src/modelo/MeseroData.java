
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MeseroData {
    
    private Connection conn;

    public MeseroData(Conexion conn) {
        try {
            this.conn = conn.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void nuevoMesero(Mesero mesero) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO mesero (nombre) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mesero.getNombre());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                mesero.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarMesero(String nombre) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM mesero WHERE nombre = ?");
            ps.setString(1, nombre);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarMesero(Mesero mesero) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE mesero SET nombre = ? WHERE id = ?");
            ps.setString(1, mesero.getNombre());
            ps.setInt(2, mesero.getId());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Mesero buscarMesero(String nombreMesero) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM mesero WHERE nombre = ?");
            ps.setString(1, nombreMesero);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return new Mesero(resultSet.getInt("id"), resultSet.getString("nombre"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean existeMesero(String nombreMesero) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT nombre FROM mesero WHERE nombre = ?");
            ps.setString(1, nombreMesero);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
