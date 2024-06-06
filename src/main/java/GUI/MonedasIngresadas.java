package org.example.gui2;

import org.example.logica.*;

import javax.swing.*;
import java.awt.*;

public class MonedasIngresadas extends JPanel {
    private final Image moneda100 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda100(1).png")).getImage();
    private final Image moneda500 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda500(1).png")).getImage();
    private final Image moneda1000 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda1000(1).png")).getImage();
    private final Image moneda1500 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda1500(1).png")).getImage();
    Expendedor expendedor;

    public MonedasIngresadas(Expendedor expendedor){
        setBounds(3,82,111,16);
        setOpaque(false);
        this.expendedor = expendedor;

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < expendedor.getMonCo().getSizeDeposito(); i++){
            if(expendedor.getMonCo().getDepositoMonedas().get(i).getClass() == Moneda100.class){
                g.drawImage(moneda100, 0+i*7, 0, null);
            }else if(expendedor.getMonCo().getDepositoMonedas().get(i).getClass() == Moneda500.class){
                g.drawImage(moneda500, 0+i*7, 0, null);
            }else if(expendedor.getMonCo().getDepositoMonedas().get(i).getClass() == Moneda1000.class){
                g.drawImage(moneda1000, 0+i*7, 0, null);
            }else if(expendedor.getMonCo().getDepositoMonedas().get(i).getClass() == Moneda1500.class){
                g.drawImage(moneda1500, 0+i*7, 0, null);
            }
        }
    }
}
