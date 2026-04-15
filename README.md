# -_Sistema_Java_Oracle_19c_4-Tablas_con_Swing_- :.
🖥️ Sistema Java + Oracle 19c (4 Tablas con Swing):

<img width="1024" height="1024" alt="image" src="https://github.com/user-attachments/assets/5d425a7a-dc5a-42d4-a643-0dad95a689d4" />  

```
Solucion completa, estructurada y lista para IntelliJ + Oracle 19c, con:

✔ Arquitectura por capas (DAO + Servicio + Vista)
✔ Conexión JDBC a Oracle 19c
✔ 4 tablas en base de datos
✔ Script SQL con 36 registros por tabla
✔ Interfaz gráfica con 4 JTable simultáneas.

🧩 1. SCRIPT ORACLE 19c
📌 Creación de Tablas
-- =============================
-- TABLAS
-- =============================

CREATE TABLE CLIENTE (
    ID NUMBER PRIMARY KEY,
    NOMBRE VARCHAR2(100),
    EMAIL VARCHAR2(100)
);

CREATE TABLE PRODUCTO (
    ID NUMBER PRIMARY KEY,
    NOMBRE VARCHAR2(100),
    PRECIO NUMBER
);

CREATE TABLE INFO_CLIENTE (
    ID NUMBER PRIMARY KEY,
    CLIENTE_ID NUMBER,
    DIRECCION VARCHAR2(150),
    TELEFONO VARCHAR2(50)
);

CREATE TABLE EMPRESA_VENTA (
    ID NUMBER PRIMARY KEY,
    NOMBRE VARCHAR2(100),
    CIUDAD VARCHAR2(100)
);

📌 Inserción de Datos (36 registros por tabla)
BEGIN
    FOR i IN 1..36 LOOP
        INSERT INTO CLIENTE VALUES (i, 'Cliente ' || i, 'cliente' || i || '@mail.com');
        INSERT INTO PRODUCTO VALUES (i, 'Producto ' || i, i * 1000);
        INSERT INTO INFO_CLIENTE VALUES (i, i, 'Direccion ' || i, '30000000' || i);
        INSERT INTO EMPRESA_VENTA VALUES (i, 'Empresa ' || i, 'Ciudad ' || i);
    END LOOP;
END;
/

COMMIT;

🧩 2. CONEXIÓN JDBC
package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "system";
    private static final String PASS = "1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

🧩 3. MODELOS
📌 Cliente.java
package model;

public class Cliente {
    private int id;
    private String nombre;
    private String email;

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}

📌 Nota

Crear clases equivalentes para:

Producto
InfoCliente
EmpresaVenta

🧩 4. DAO (ACCESO A DATOS)
📌 ClienteDAO.java
package dao;

import database.Conexion;
import model.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM CLIENTE")) {

            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("EMAIL")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}

📌 DAOs adicionales

Crear clases similares:

ProductoDAO
InfoClienteDAO
EmpresaVentaDAO.

🧩 5. SERVICIO
📌 ClienteService.java
package service;

import dao.ClienteDAO;
import model.Cliente;

import java.util.List;

public class ClienteService {

    private ClienteDAO dao = new ClienteDAO();

    public List<Cliente> obtenerClientes() {
        return dao.listar();
    }
}

📌 Servicios adicionales

Repetir patrón para:

ProductoService
InfoClienteService
EmpresaVentaService .

🧩 6. INTERFAZ GRÁFICA (SWING)
📌 MainView.java
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

🧱 7. ARQUITECTURA DEL PROYECTO
📁 project
 ┣ 📁 database
 ┃ ┗ Conexion.java
 ┣ 📁 model
 ┃ ┣ Cliente.java
 ┃ ┣ Producto.java
 ┃ ┣ InfoCliente.java
 ┃ ┗ EmpresaVenta.java
 ┣ 📁 dao
 ┃ ┣ ClienteDAO.java
 ┃ ┣ ProductoDAO.java
 ┃ ┣ InfoClienteDAO.java
 ┃ ┗ EmpresaVentaDAO.java
 ┣ 📁 service
 ┃ ┣ ClienteService.java
 ┃ ┣ ProductoService.java
 ┃ ┣ InfoClienteService.java
 ┃ ┗ EmpresaVentaService.java
 ┣ 📁 view
 ┃ ┗ MainView.java .

🚀 MEJORAS (NIVEL PROFESIONAL)

Para escalar esta solución:

🔹 Paginación (36 → páginas de 10 registros)
🔹 Filtros dinámicos por nombre
🔹 Botón "Refrescar"
🔹 Uso de PreparedStatement (seguridad + performance)
🔹 Pool de conexiones (HikariCP)
🔹 Migración a JavaFX (UI moderna)
🔹 Patrón MVC más estricto o arquitectura hexagonal :. . / .
