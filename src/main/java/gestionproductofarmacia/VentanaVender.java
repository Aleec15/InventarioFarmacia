package gestionproductosfarmacia;

import javax.swing.*;

/**
 * Ventana para vender productos usando codigo y cantidad.
 */
public class VentanaVender {

    private Controlador controlador;

    public VentanaVender(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrar() {
        JFrame ventana = new JFrame("Vender Producto");
        ventana.setSize(400, 200);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblCodigo = new JLabel("Codigo:");
        JLabel lblCantidad = new JLabel("Cantidad:");

        JTextField campoCodigo = new JTextField();
        JTextField campoCantidad = new JTextField();

        JButton btnVender = new JButton("Vender");

        lblCodigo.setBounds(30, 30, 100, 25);
        campoCodigo.setBounds(120, 30, 200, 25);

        lblCantidad.setBounds(30, 70, 100, 25);
        campoCantidad.setBounds(120, 70, 200, 25);

        btnVender.setBounds(120, 110, 100, 30);

        ventana.add(lblCodigo);
        ventana.add(campoCodigo);
        ventana.add(lblCantidad);
        ventana.add(campoCantidad);
        ventana.add(btnVender);

        btnVender.addActionListener(e -> {
            try {
                String codigo = campoCodigo.getText();
                int cantidad = Integer.parseInt(campoCantidad.getText());

                boolean vendido = controlador.venderProducto(codigo, cantidad);
                if (vendido) {
                    JOptionPane.showMessageDialog(ventana, "Venta realizada con exito.");
                    ventana.dispose();
                } else {
                    JOptionPane.showMessageDialog(ventana, "No se pudo vender. Verifica codigo o stock disponible.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Cantidad invalida.");
            }
        });

        ventana.setVisible(true);
    }
}
