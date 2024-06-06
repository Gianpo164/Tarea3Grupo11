package GUI;

import logica.Deposito;
import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class Super8 extends JPanel {
    private Image imgSuper8;
    private Deposito deposito;
    public Super8(Deposito dep){
        super();
        deposito = dep;
        imgSuper8 = new ImageIcon(getClass().getClassLoader().getResource("Super8.png")).getImage();
        Dimension size = new Dimension(imgSuper8.getWidth(null), imgSuper8.getHeight(null));
        setBounds(0,0,141,81);
        setBackground(new Color(0,200,0,0));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < deposito.getSizeDeposito() && i < 10; i++){//<10 cambiar
            g.drawImage(imgSuper8, i*9, 10, null);
        }
    }
}