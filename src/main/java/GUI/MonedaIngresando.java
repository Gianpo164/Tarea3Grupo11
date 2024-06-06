package GUI;

import logica.Moneda100;
import logica.Moneda1000;
import logica.Moneda1500;
import logica.Moneda500;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonedaIngresando extends JPanel implements ActionListener{
    private Image moneda100 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda100(1).png")).getImage();
    private Image moneda500 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda500(1).png")).getImage();
    private Image moneda1000 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda1000(1).png")).getImage();
    private Image moneda1500 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda1500(1).png")).getImage();
    private int x;
    private int y;
    private int contador;

    public MonedaIngresando(){
        setBounds(27,20,32,32);
        setOpaque(false);
        resetPosition();
        contador = 0;
    }

    public void resetPosition(){
        x = 5;
        y = 0;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (PanelComprador.eleccion) {
            case 100 -> g.drawImage(moneda100, x, y, null);
            case 500 -> g.drawImage(moneda500, x, y, null);
            case 1000 -> g.drawImage(moneda1000, x, y, null);
            case 1500 -> g.drawImage(moneda1500, x, y, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        setVisible(true);
        x -=5;
        repaint();
        contador++;
        if (contador == 3){
            ((Timer)e.getSource()).stop();
            resetPosition();
            setVisible(false);
            contador = 0;
        }
    }




}
