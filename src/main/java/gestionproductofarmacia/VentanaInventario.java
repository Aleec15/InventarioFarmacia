package gestionproductosfarmacia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana para mostrar todos los productos registrados.
 */
public class VentanaInventario {

    private Controlador controlador;

    public VentanaInventario(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrar() {
        JFrame ventana = new JFrame("Inventario de Productos");
        ventana.setSize(600, 400);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"Codigo", "Nombre", "Precio", "Stock"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 20, 540, 300);
        ventana.add(scroll);

        // Llenar la tabla con los productos
        for (Producto p : controlador.obtenerProductos()) {
            modeloTabla.addRow(p.toRow());
        }

        ventana.setVisible(true);
    }
}
