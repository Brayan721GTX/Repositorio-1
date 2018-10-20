/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Pedido {
    private int id;
    private int idMesero;
    private int idMesa;
    private Date fecha;
    private boolean estado;

    public Pedido(int id, int idMesero, int idMesa, Date fecha, boolean estado) {
        this.id = id;
        this.idMesero = idMesero;
        this.idMesa = idMesa;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Pedido(int idMesero, int idMesa, boolean estado) {
        this.idMesero = idMesero;
        this.idMesa = idMesa;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
