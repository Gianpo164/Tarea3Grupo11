package GUI;

import logica.Deposito;
import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class Snickers extends JPanel {
    private Image imgSnickers;
    private Deposito deposito;
    public Snickers(Deposito d){
        super();
        deposito = d;
        imgSnickers = new ImageIcon(getClass().getClassLoader().getResource("Snickers.png")).getImage();
        Dimension size = new Dimension(imgSnickers.getWidth(null), imgSnickers.getHeight(null));
        setBounds(0,0,141,81);
        setBackground(new Color(0,200,0,0));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < deposito.getSizeDeposito() && i < 10; i++){//<10 cambiar
            g.drawImage(imgSnickers, i*9, 10, null);
        }
    }
}