package service;

import dao.EmpresaVentaDAO;
import model.EmpresaVenta;

import java.util.List;

public class EmpresaVentaService {

    private EmpresaVentaDAO dao = new EmpresaVentaDAO();

    public List<EmpresaVenta> obtenerEmpresaVentas() {
        return dao.listar();
    }
}
