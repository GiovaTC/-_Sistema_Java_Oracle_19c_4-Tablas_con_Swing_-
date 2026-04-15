package dao;

import database.Conexion;
import model.EmpresaVenta;
import model.InfoCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpresaVentaDAO {

    public List<EmpresaVenta> listar() {
        List<EmpresaVenta> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM EMPRESA_VENTA")) {

            while (rs.next()) {
                lista.add(new EmpresaVenta(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("CIUDAD")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
