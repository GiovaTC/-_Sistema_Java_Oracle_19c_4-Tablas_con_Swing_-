package dao;

import database.Conexion;
import model.Cliente;
import model.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM PRODUCTO_D")) {

            while (rs.next()) {
                lista.add(new Producto(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getDouble("PRECIO")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}   
