package gestionproductosfarmacia;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del menu en formato 3 columnas x 2 filas.
 */
public class VentanaMenu {

    private Controlador controlador;

    public VentanaMenu(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrar() {
        JFrame ventana = new JFrame("Menu Principal - Farmacia");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Seleccione una opcion", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        ventana.add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 10, 10)); // 2 filas, 3 columnas, espacio de 10px
        ventana.add(panelBotones, BorderLayout.CENTER);

        // Crear botones
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnInventario = new JButton("Inventario");
        JButton btnVender = new JButton("Vender");
        JButton btnPrecio = new JButton("Actualizar Precio");
        JButton btnSalir = new JButton("Salir");

        // Agregar botones al panel
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnInventario);
        panelBotones.add(btnVender);
        panelBotones.add(btnPrecio);
        panelBotones.add(btnSalir);

        // Acciones
        btnRegistrar.addActionListener(e -> new VentanaRegistrar(controlador).mostrar());
        btnConsultar.addActionListener(e -> new VentanaConsultar(controlador).mostrar());
        btnInventario.addActionListener(e -> new VentanaInventario(controlador).mostrar());
        btnVender.addActionListener(e -> new VentanaVender(controlador).mostrar());
        btnPrecio.addActionListener(e -> new VentanaActualizarPrecio(controlador).mostrar());

        btnSalir.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(ventana, "¿Deseas salir?");
            if (opcion == JOptionPane.YES_OPTION) {
                ventana.dispose();
            }
        });

        ventana.setLocationRelativeTo(null); // Centrar en pantalla
        ventana.setVisible(true);
    }
}
