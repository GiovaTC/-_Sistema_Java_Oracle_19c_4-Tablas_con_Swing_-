package model;

public class EmpresaVenta {

    private int id;
    private String nombre;
    private String ciudad;

    public EmpresaVenta(int id, String nombre, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }
}   
