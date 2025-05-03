package gestionproductosfarmacia;

public class Principal {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        VentanaMenu menu = new VentanaMenu(controlador);
        menu.mostrar();
    }
}
