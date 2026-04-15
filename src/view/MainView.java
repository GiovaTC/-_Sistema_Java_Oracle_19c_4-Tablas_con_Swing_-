package view;

import model.Cliente;
import model.EmpresaVenta;
import model.InfoCliente;
import model.Producto;
import service.ClienteService;
import service.EmpresaVentaService;
import service.InfoClienteService;
import service.ProductoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainView extends JFrame {

    private JTable tablaCliente = new JTable();
    private JTable tablaProducto = new JTable();
    private JTable tablaInfoCliente = new JTable();
    private JTable tablaEmpresa = new JTable();

    public MainView() {
        setTitle("Sistema Oracle 19C - 4 Tablas");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2,2));

        add(new JScrollPane(tablaCliente));
        add(new JScrollPane(tablaProducto));
        add(new JScrollPane(tablaInfoCliente));
        add(new JScrollPane(tablaEmpresa));

        cargarDatos();
    }

    private void cargarDatos() {
        cargarClientes();
        cargarProductos();
        cargarInfoCliente();
        cargarEmpresa();
    }

    private void cargarClientes() {
        ClienteService service = new ClienteService();
        List<Cliente> lista = service.obtenerClientes();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Email");

        for (Cliente c : lista) {
            model.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getEmail()
            });
        }

        tablaCliente.setModel(model);
    }

    private void cargarProductos() {
        // Implementar igual que clientes
        ProductoService service = new ProductoService();
        List<Producto> lista = service.obtenerProductos();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Precio");

        for (Producto c : lista) {
            model.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getPrecio()
            });
        }

        tablaProducto.setModel(model);
    }

    private void cargarInfoCliente() {
        // Implementar igual que clientes
        InfoClienteService service = new InfoClienteService();
        List<InfoCliente> lista = service.obtenerInfoClientes();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("CLIENTE_ID");
        model.addColumn("DIRECCION");
        model.addColumn("TELEFONO");

        for (InfoCliente c : lista) {
            model.addRow(new Object[]{
                    c.getId(),
                    c.getClienteId(),
                    c.getDireccion(),
                    c.getTelefono()
            });
        }

        tablaInfoCliente.setModel(model);
    }

    private void cargarEmpresa() {
        // Implementar igual que clientes
        EmpresaVentaService service = new EmpresaVentaService();
        List<EmpresaVenta> lista = service.obtenerEmpresaVentas();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addColumn("CIUDAD");

        for (EmpresaVenta c : lista) {
            model.addRow(new Object[]{
                    c.getId(),
                    c.getNombre(),
                    c.getCiudad()
            });

            tablaEmpresa.setModel(model);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView().setVisible(true));
    }
}