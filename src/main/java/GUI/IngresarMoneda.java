package GUI;

import logica.*;

import javax.swing.*;
import java.awt.*;


public class IngresarMoneda extends JPanel {
    private JPanel monedaingresando;
    private Image moneda100 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda100(1).png")).getImage();
    private Image moneda500 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda500(1).png")).getImage();
    private Image moneda1000 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda1000(1).png")).getImage();
    private Image moneda1500 = new ImageIcon(getClass().getClassLoader().getResource("RMoneda1500(1).png")).getImage();


    public IngresarMoneda (Expendedor expendedor){
        setBounds(16,1,53,58);
        setLayout(null);
        setOpaque(false);
        monedaingresando = new JPanel();
        monedaingresando.setBounds(27,13,32,32);
        add(monedaingresando);
    }

}
