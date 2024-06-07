package GUI;

import javax.swing.*;

/**
 * Panel que se encarga de la animacion de la moneda que se ingresa
 */
public class IngresarMoneda extends JPanel {
    private MonedaIngresando monedaIngresando;

    /**
     * Genera el panel IngresarMoneda y modifica los componentes necesarios
     */
    public IngresarMoneda (){
        setBounds(16,1,53,58);
        setLayout(null);
        setOpaque(false);
        monedaIngresando = new MonedaIngresando();
        add(monedaIngresando);
    }

    /**
     * Dibuja la animacion de cuando la moneda esta ingresando a el expendedor
     */
    public void animacion(){
        Timer animacion = new Timer(100,monedaIngresando);
        animacion.start();

    }
}
