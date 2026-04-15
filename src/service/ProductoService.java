package service;

import dao.ProductoDAO;
import model.Producto;

import java.util.List;

public class ProductoService {

    private ProductoDAO dao = new ProductoDAO();

    public List<Producto> obtenerProductos() {
        return dao.listar();
    }   
}
