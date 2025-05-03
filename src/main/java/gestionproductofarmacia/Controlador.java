package gestionproductosfarmacia;

import java.util.ArrayList;

/**
 * Clase que guarda y maneja la lista de productos.
 */
public class Controlador {

    private ArrayList<Producto> productos = new ArrayList<>();

    // Agregar un nuevo producto a la lista
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Buscar un producto por su código
    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    // Cambiar el precio de un producto
    public boolean cambiarPrecio(String codigo, double nuevoPrecio) {
        Producto p = buscarProducto(codigo);
        if (p != null) {
            p.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }

    // Vender un producto (restar stock)
    public boolean venderProducto(String codigo, int cantidad) {
        Producto p = buscarProducto(codigo);
        if (p != null && p.getStock() >= cantidad) {
            p.vender(cantidad);
            return true;
        }
        return false;
    }

    // Obtener toda la lista de productos
    public ArrayList<Producto> obtenerProductos() {
        return productos;
    }
}
