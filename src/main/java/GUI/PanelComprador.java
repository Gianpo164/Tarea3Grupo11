package org.example.gui2;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private Image imagenComprador;
    public static int eleccion;
    public PanelComprador(){
        imagenComprador = new ImageIcon(getClass().getClassLoader().getResource("Comprador.png")).getImage();
        Dimension size = new Dimension(imagenComprador.getWidth(null), imagenComprador.getHeight(null));
        this.setPreferredSize(size);
        setLayout(null);
        SelectorMonedas selecmon = new SelectorMonedas();
        add(selecmon);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenComprador, 0, 0, null);
    }
}
