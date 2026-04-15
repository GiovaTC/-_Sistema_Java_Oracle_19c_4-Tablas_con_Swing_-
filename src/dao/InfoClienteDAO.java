package dao;

import database.Conexion;
import model.InfoCliente;
import model.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InfoClienteDAO {

    public List<InfoCliente> listar() {
        List<InfoCliente> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM INFO_CLIENTE")) {

            while (rs.next()) {
                lista.add(new InfoCliente(
                        rs.getInt("ID"),
                        rs.getInt("CLIENTE_ID"),
                        rs.getString("DIRECCION"),
                        rs.getString("TELEFONO")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
