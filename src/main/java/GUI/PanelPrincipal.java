package GUI;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;


public class PanelPrincipal extends JPanel {
    private Image Fondo;
    private PanelExpendedor panelExpendedor;
    private PanelComprador panelComprador;

    public PanelPrincipal(Expendedor expendedor){
        Fondo = new ImageIcon(getClass().getClassLoader().getResource("Fondo.png")).getImage();
        panelComprador = new PanelComprador(expendedor);
        panelExpendedor = new PanelExpendedor(expendedor,panelComprador);
        setLayout(new BorderLayout());
        add(panelExpendedor,BorderLayout.WEST);
        add(panelComprador,BorderLayout.EAST);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Fondo, 0, -1, null);
    }
}

