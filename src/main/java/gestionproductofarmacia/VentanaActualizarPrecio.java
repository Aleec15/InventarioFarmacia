package gestionproductosfarmacia;

import javax.swing.*;

/**
 * Ventana para actualizar el precio de un producto.
 */
public class VentanaActualizarPrecio {

    private Controlador controlador;

    public VentanaActualizarPrecio(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrar() {
        JFrame ventana = new JFrame("Actualizar Precio");
        ventana.setSize(400, 200);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblCodigo = new JLabel("Codigo:");
        JLabel lblNuevoPrecio = new JLabel("Nuevo precio:");

        JTextField campoCodigo = new JTextField();
        JTextField campoPrecio = new JTextField();

        JButton btnActualizar = new JButton("Actualizar");

        lblCodigo.setBounds(30, 30, 100, 25);
        campoCodigo.setBounds(150, 30, 200, 25);

        lblNuevoPrecio.setBounds(30, 70, 100, 25);
        campoPrecio.setBounds(150, 70, 200, 25);

        btnActualizar.setBounds(150, 110, 100, 30);

        ventana.add(lblCodigo);
        ventana.add(campoCodigo);
        ventana.add(lblNuevoPrecio);
        ventana.add(campoPrecio);
        ventana.add(btnActualizar);

        btnActualizar.addActionListener(e -> {
            try {
                String codigo = campoCodigo.getText();
                double nuevoPrecio = Double.parseDouble(campoPrecio.getText());

                boolean actualizado = controlador.cambiarPrecio(codigo, nuevoPrecio);
                if (actualizado) {
                    JOptionPane.showMessageDialog(ventana, "Precio actualizado con exito.");
                    ventana.dispose();
                } else {
                    JOptionPane.showMessageDialog(ventana, "Producto no encontrado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Precio invalido.");
            }
        });

        ventana.setVisible(true);
    }
}
