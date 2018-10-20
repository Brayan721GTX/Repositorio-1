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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class ProductoPedidoData {
    private Connection conn;

    public ProductoPedidoData(Conexion conn) {
        try {
            this.conn = conn.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void nuevoProductoPedido(ProductoPedido productoPedido) {
        //Sirve para agregar un producto a un pedido
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO producto_pedido (id_pedido, id_producto, precio, cantidad) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, productoPedido.getId_pedido());
            ps.setInt(2, productoPedido.getId_producto());
            ps.setDouble(3, productoPedido.getPrecio());
            ps.setInt(4, productoPedido.getCantidad());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
