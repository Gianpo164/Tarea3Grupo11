package GUI;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;


/**
 * Panel que reune los principales componentes del programa
 */
public class PanelPrincipal extends JPanel {
    private Image Fondo;
    private PanelExpendedor panelExpendedor;
    private PanelComprador panelComprador;

    /**
     * Crea el panel y agrega sus componentes
     * @param expendedor clase logica que representa un expendedor
     */
    public PanelPrincipal(Expendedor expendedor){
        Fondo = new ImageIcon(getClass().getClassLoader().getResource("Fondo.png")).getImage();
        panelComprador = new PanelComprador(expendedor);
        panelExpendedor = new PanelExpendedor(expendedor,panelComprador);
        setLayout(new BorderLayout());
        add(panelExpendedor,BorderLayout.WEST);
        add(panelComprador,BorderLayout.EAST);
    }

    /**
     * Metodo que dibuja componetes
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Fondo, 0, -1, null);
    }
}

