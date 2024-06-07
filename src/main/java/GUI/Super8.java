package GUI;

import logica.Deposito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Super8 extends JPanel {
    private Image imgSuper8;
    private Deposito deposito;
    private int vecesRellenado;

    public Super8(Deposito dep){
        super();
        deposito = dep;
        imgSuper8 = new ImageIcon(getClass().getClassLoader().getResource("Super8.png")).getImage();
        setBounds(0,0,141,81);
        setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                if (deposito.getSizeDeposito() == 0) {
                    for (int i = 510 + vecesRellenado * 10; i < 520 + vecesRellenado * 10; i++) {
                        deposito.addObject(new logica.Super8(i));
                    }
                    vecesRellenado++;
                }
                repaint();
            }
        });
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < deposito.getSizeDeposito() && i < 10; i++){//<10 cambiar
            g.drawImage(imgSuper8, i*9, 10, null);
        }
    }
}