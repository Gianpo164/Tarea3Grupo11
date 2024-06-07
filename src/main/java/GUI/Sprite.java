package GUI;

import logica.Deposito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel que se encarga de dibujar las images de Sprite y rellenar el Deposito de Sprite
 */
public class Sprite extends JPanel {

    private Image imgSprite;
    private Deposito deposito;
    private int vecesRellenado;

    /**
     * Genera las imagenes de Sprite y rellena el deposito cuando es necesario
     * @param dep Deposito de Sprite
     */
    public Sprite(Deposito dep){
        super();
        deposito = dep;
        imgSprite = new ImageIcon(getClass().getClassLoader().getResource("Sprite.png")).getImage();
        setBounds(0,0,141,81);
        setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                if (deposito.getSizeDeposito() == 0) {
                    for (int i = 210 + vecesRellenado * 10; i < 220 + vecesRellenado * 10; i++) {
                        deposito.addObject(new logica.Sprite(i));
                    }
                    vecesRellenado++;
                }
                repaint();
            }
        });
    }

    /**
     * Dibuja los productos Sprite
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < deposito.getSizeDeposito() && i < 10; i++){//<10 cambiar
            g.drawImage(imgSprite, i*12, 10, null);
        }
    }
}