
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MeseroData {
    
    private Connection conn;

    public MeseroData(Conexion conn) {
        this.conn = conn.getConexion();
    }
    
    public void nuevoMesero(Mesero mesero) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO mesero (nombre) VALUES(?)");
            ps.setString(1, mesero.getNombre());
            ps.execute();
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
    
    public void actualizarMesero(int idMesero, String nombre) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE mesero SET nombre = ? WHERE id = ?");
            ps.setString(1, nombre);
            ps.setInt(2, idMesero);
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
