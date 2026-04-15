package view;

import model.Cliente;
import service.ClienteService;

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
    }

    private void cargarInfoCliente() {
        // Implementar igual que clientes
    }

    private void cargarEmpresa() {
        // Implementar igual que clientes
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView().setVisible(true));
    }
}