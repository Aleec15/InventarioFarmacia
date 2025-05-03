package gestionproductosfarmacia;

import javax.swing.*;

/**
 * Ventana para registrar un nuevo producto.
 */
public class VentanaRegistrar {

    private Controlador controlador;

    public VentanaRegistrar(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrar() {
        JFrame ventana = new JFrame("Registrar Producto");
        ventana.setSize(400, 300);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblCodigo = new JLabel("Código:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblPrecio = new JLabel("Precio:");
        JLabel lblStock = new JLabel("Stock:");

        JTextField campoCodigo = new JTextField();
        JTextField campoNombre = new JTextField();
        JTextField campoPrecio = new JTextField();
        JTextField campoStock = new JTextField();

        JButton btnGuardar = new JButton("Guardar");

        // Posiciones
        lblCodigo.setBounds(30, 30, 80, 25);
        campoCodigo.setBounds(120, 30, 200, 25);

        lblNombre.setBounds(30, 70, 80, 25);
        campoNombre.setBounds(120, 70, 200, 25);

        lblPrecio.setBounds(30, 110, 80, 25);
        campoPrecio.setBounds(120, 110, 200, 25);

        lblStock.setBounds(30, 150, 80, 25);
        campoStock.setBounds(120, 150, 200, 25);

        btnGuardar.setBounds(120, 200, 100, 30);

        // Agregar a la ventana
        ventana.add(lblCodigo);
        ventana.add(campoCodigo);
        ventana.add(lblNombre);
        ventana.add(campoNombre);
        ventana.add(lblPrecio);
        ventana.add(campoPrecio);
        ventana.add(lblStock);
        ventana.add(campoStock);
        ventana.add(btnGuardar);

        // Acción del botón
        btnGuardar.addActionListener(e -> {
            try {
                String codigo = campoCodigo.getText();
                String nombre = campoNombre.getText();
                double precio = Double.parseDouble(campoPrecio.getText());
                int stock = Integer.parseInt(campoStock.getText());

                Producto nuevo = new Producto(codigo, nombre, precio, stock);
                controlador.agregarProducto(nuevo);
                JOptionPane.showMessageDialog(ventana, "Producto registrado con éxito.");
                ventana.dispose(); // Cierra la ventana actual
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "Error: precio o stock inválido.");
            }
        });

        ventana.setVisible(true);
    }
}
