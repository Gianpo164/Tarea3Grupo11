package GUI;

import logica.Deposito;

import javax.swing.*;
import java.awt.*;

public class CocaCola extends JPanel {

    private Image imgCocaCola;
    private Deposito deposito;
    public CocaCola(Deposito dep){
        super();
        deposito = dep;
        imgCocaCola = new ImageIcon(getClass().getClassLoader().getResource("CocaCola.png")).getImage();
        Dimension size = new Dimension(imgCocaCola.getWidth(null), imgCocaCola.getHeight(null));
        setBounds(0,0,141,81);
        setBackground(new Color(0,200,0,0));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < deposito.getSizeDeposito() && i < 10; i++){//<10 cambiar
            g.drawImage(imgCocaCola, i*12, 10, null);
        }
    }
}
