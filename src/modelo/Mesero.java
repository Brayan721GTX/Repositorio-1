
package modelo;

public class Mesero {
    private int id;
    private String nombre;

    public Mesero(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Mesero(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
