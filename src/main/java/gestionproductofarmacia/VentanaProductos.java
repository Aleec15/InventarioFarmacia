package gestionproductosfarmacia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que muestra la ventana principal con botones y tabla.
 */
public class VentanaProductos {

    private Controlador controlador = new Controlador();
    private DefaultTableModel modeloTabla;

    public void mostrarVentana() {
        JFrame ventana = new JFrame("Gestión de Productos - Farmacia");
        ventana.setSize(750, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        // Tabla
        String[] columnas = {"Código", "Nombre", "Precio", "Stock"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 20, 690, 150);
        ventana.add(scroll);

        // Campos de entrada
        JTextField campoCodigo = new JTextField();
        JTextField campoNombre = new JTextField();
        JTextField campoPrecio = new JTextField();
        JTextField campoStock = new JTextField();

        campoCodigo.setBounds(20, 190, 150, 25);
        campoNombre.setBounds(180, 190, 150, 25);
        campoPrecio.setBounds(340, 190, 150, 25);
        campoStock.setBounds(500, 190, 150, 25);

        ventana.add(campoCodigo);
        ventana.add(campoNombre);
        ventana.add(campoPrecio);
        ventana.add(campoStock);

        // Botón: Registrar
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(20, 230, 200, 30);
        ventana.add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            try {
                String codigo = campoCodigo.getText();
                String nombre = campoNombre.getText();
                double precio = Double.parseDouble(campoPrecio.getText());
                int stock = Integer.parseInt(campoStock.getText());

                Producto producto = new Producto(codigo, nombre, precio, stock);
                controlador.agregarProducto(producto);
                JOptionPane.showMessageDialog(ventana, "Producto registrado con éxito.");
                limpiarCampos(campoCodigo, campoNombre, campoPrecio, campoStock);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Error: precio o stock inválido.");
            }
        });

        // Botón: Consultar
        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(240, 230, 200, 30);
        ventana.add(btnConsultar);

        btnConsultar.addActionListener(e -> {
            String codigo = campoCodigo.getText();
            Producto producto = controlador.buscarProducto(codigo);
            if (producto != null) {
                JOptionPane.showMessageDialog(ventana,
                        "Nombre: " + producto.getNombre() +
                        "\nPrecio: Q" + producto.getPrecio() +
                        "\nStock: " + producto.getStock());
            } else {
                JOptionPane.showMessageDialog(ventana, "Producto no encontrado.");
            }
        });

        // Botón: Ver Inventario
        JButton btnInventario = new JButton("Ver Inventario");
        btnInventario.setBounds(460, 230, 200, 30);
        ventana.add(btnInventario);

        btnInventario.addActionListener(e -> {
            modeloTabla.setRowCount(0);
            for (Producto p : controlador.obtenerProductos()) {
                modeloTabla.addRow(p.toRow());
            }
        });

        // Botón: Vender
        JButton btnVender = new JButton("Vender");
        btnVender.setBounds(20, 280, 200, 30);
        ventana.add(btnVender);

        btnVender.addActionListener(e -> {
            try {
                String codigo = campoCodigo.getText();
                int cantidad = Integer.parseInt(campoStock.getText());
                boolean vendido = controlador.venderProducto(codigo, cantidad);
                if (vendido) {
                    JOptionPane.showMessageDialog(ventana, "Venta realizada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(ventana, "No se pudo vender. Verifica el stock o el código.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Cantidad inválida.");
            }
        });

        // Botón: Cambiar Precio
        JButton btnPrecio = new JButton("Actualizar Precio");
        btnPrecio.setBounds(240, 280, 200, 30);
        ventana.add(btnPrecio);

        btnPrecio.addActionListener(e -> {
            try {
                String codigo = campoCodigo.getText();
                double nuevoPrecio = Double.parseDouble(campoPrecio.getText());
                boolean cambiado = controlador.cambiarPrecio(codigo, nuevoPrecio);
                if (cambiado) {
                    JOptionPane.showMessageDialog(ventana, "Precio actualizado.");
                } else {
                    JOptionPane.showMessageDialog(ventana, "Producto no encontrado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Precio inválido.");
            }
        });

        // Botón: Salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(460, 280, 200, 30);
        ventana.add(btnSalir);

        btnSalir.addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(ventana, "¿Seguro que deseas salir?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                ventana.dispose();
            }
        });

        ventana.setVisible(true);
    }

    private void limpiarCampos(JTextField c1, JTextField c2, JTextField c3, JTextField c4) {
        c1.setText("");
        c2.setText("");
        c3.setText("");
        c4.setText("");
    }
}
