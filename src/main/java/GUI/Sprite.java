package GUI;

import logica.Deposito;

import javax.swing.*;
import java.awt.*;

public class Sprite extends JPanel {

    private Image imgSprite;
    private Deposito deposito;
    public Sprite(Deposito dep){
        super();
        deposito = dep;
        imgSprite = new ImageIcon(getClass().getClassLoader().getResource("Sprite.png")).getImage();
        Dimension size = new Dimension(imgSprite.getWidth(null), imgSprite.getHeight(null));
        setBounds(0,0,141,81);
        setBackground(new Color(0,200,0,0));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < deposito.getSizeDeposito() && i < 10; i++){//<10 cambiar
            g.drawImage(imgSprite, i*12, 10, null);
        }
    }
}