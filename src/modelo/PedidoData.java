/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class PedidoData {
    private Connection conn;

    public PedidoData(Conexion conn) {
        try {
            this.conn = conn.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void nuevoPedido(Pedido pedido, List<ProductoPedido> productos) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO pedido (id_mesero, id_mesa, fecha, estado) VALUES (?, ?, datetime('now'), ?);", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getIdMesero());
            ps.setInt(2, pedido.getIdMesa());
            ps.setBoolean(3, pedido.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                pedido.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un pedido");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
