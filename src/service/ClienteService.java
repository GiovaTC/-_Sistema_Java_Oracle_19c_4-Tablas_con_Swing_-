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
