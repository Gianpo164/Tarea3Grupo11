package GUI;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel que se encarga de detectar y dibujar las monedas cuando se ingresan a el expendedor
 */
public class PanelDepositoMonedas extends JPanel {
    private IngresarMoneda ingresarMoneda;
    private MonedasIngresadas monedasIngresadas;


    /**
     * Genera el panel y los componentes necesarios para detectar y dibujar cuando se ingresa una moneda a el expendedor
     * @param expendedor Clase logica que representa un expendedor
     */
    public PanelDepositoMonedas(Expendedor expendedor){
        setBounds(370,384,117,101);
        setLayout(null);
        setOpaque(false);
        ingresarMoneda = new IngresarMoneda();
        monedasIngresadas = new MonedasIngresadas(expendedor);
        add(ingresarMoneda);
        add(monedasIngresadas);
        ingresarMoneda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                switch (PanelComprador.eleccion){
                    case 100 -> expendedor.insertarMoneda(new Moneda100());
                    case 500 -> expendedor.insertarMoneda(new Moneda500());
                    case 1000 -> expendedor.insertarMoneda(new Moneda1000());
                    case 1500 -> expendedor.insertarMoneda(new Moneda1500());
                }
                ingresarMoneda.animacion();
                Timer timer = new Timer(500, actionEvent -> monedasIngresadas.repaint());
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    /**
     * Dibuja las monedas ingresadas a el expendedor
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        monedasIngresadas.repaint();
    }
}
