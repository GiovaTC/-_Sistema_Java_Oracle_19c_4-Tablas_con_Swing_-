package service;

import dao.InfoClienteDAO;
import model.InfoCliente;

import java.util.List;

public class InfoClienteService {

    private InfoClienteDAO dao = new InfoClienteDAO();

    public List<InfoCliente> obtenerInfoClientes() {
        return dao.listar();
    }
}   
