package model;

public class InfoCliente {

    private int id;
    private int clienteId;
    private String direccion;
    private String telefono;

    public InfoCliente(int id, int clienteId, String direccion, String telefono) {
        this.id = id;
        this.clienteId = clienteId;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId() { return id; }
    public int getClienteId() { return clienteId; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
}
