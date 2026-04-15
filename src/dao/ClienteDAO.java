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
             ResultSet rs = st.executeQuery("SELECT * FROM CLIENTE_Q")) {

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
