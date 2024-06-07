package GUI;

import logica.Deposito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fanta extends JPanel {

    private Image imgFanta;
    private Deposito deposito;
    private int vecesRellenado;

    public Fanta(Deposito dep){
        super();
        deposito = dep;
        imgFanta = new ImageIcon(getClass().getClassLoader().getResource("Fanta.png")).getImage();
        setBounds(0,0,141,81);
        setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                if (deposito.getSizeDeposito() == 0) {
                    for (int i = 310 + vecesRellenado * 10; i < 320 + vecesRellenado * 10; i++) {
                        deposito.addObject(new logica.Fanta(i));
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
            g.drawImage(imgFanta, i*12, 10, null);
        }
    }
}