package GUI;

import logica.Deposito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel que se encarga de dibujar las images de Snickers y rellenar el Deposito de Snickers
 */
public class Snickers extends JPanel {
    private Image imgSnickers;
    private Deposito deposito;
    private int vecesRellenado;

    /**
     * Genera las imagenes de Snickers y rellena el deposito cuando es necesario
     * @param dep Deposito de Snickers
     */
    public Snickers(Deposito dep){
        super();
        deposito = dep;
        imgSnickers = new ImageIcon(getClass().getClassLoader().getResource("Snickers.png")).getImage();
        setBounds(0,0,141,81);
        setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                if (deposito.getSizeDeposito() == 0) {
                    for (int i = 410 + vecesRellenado * 10; i < 420 + vecesRellenado * 10; i++) {
                        deposito.addObject(new logica.Snickers(i));
                    }
                    vecesRellenado++;
                }
                repaint();
            }
        });
    }

    /**
     * Dibuja los productos Snickers
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < deposito.getSizeDeposito() && i < 10; i++){//<10 cambiar
            g.drawImage(imgSnickers, i*9, 10, null);
        }
    }
}