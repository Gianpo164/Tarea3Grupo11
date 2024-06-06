package GUI;

import logica.Deposito;

import javax.swing.*;
import java.awt.*;

public class Fanta extends JPanel {

    private Image imgFanta;
    private Deposito deposito;

    public Fanta(Deposito dep){
        super();
        deposito = dep;
        imgFanta = new ImageIcon(getClass().getClassLoader().getResource("Fanta.png")).getImage();
        setBounds(0,0,141,81);
        setBackground(new Color(0,200,0,0));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < deposito.getSizeDeposito() && i < 10; i++){//<10 cambiar
            g.drawImage(imgFanta, i*12, 10, null);
        }
    }
}