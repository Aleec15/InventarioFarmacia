package gestionproductosfarmacia;

import javax.swing.*;

/**
 * Ventana para consultar un producto por su codigo.
 */
public class VentanaConsultar {

    private Controlador controlador;

    public VentanaConsultar(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrar() {
        JFrame ventana = new JFrame("Consultar Producto");
        ventana.setSize(400, 200);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblCodigo = new JLabel("Codigo:");
        JTextField campoCodigo = new JTextField();
        JButton btnBuscar = new JButton("Buscar");

        lblCodigo.setBounds(30, 30, 100, 25);
        campoCodigo.setBounds(120, 30, 200, 25);
        btnBuscar.setBounds(120, 70, 100, 30);

        ventana.add(lblCodigo);
        ventana.add(campoCodigo);
        ventana.add(btnBuscar);

        btnBuscar.addActionListener(e -> {
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

        ventana.setVisible(true);
    }
}
