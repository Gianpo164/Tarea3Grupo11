package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorMonedas extends JPanel implements ActionListener{
    JRadioButton moneda100;
    JRadioButton moneda500;
    JRadioButton moneda1000;
    JRadioButton moneda1500;
    ImageIcon transparent;
    ButtonGroup selector;

    public SelectorMonedas(){
        setBounds(52,51,128,100);
        setOpaque(false);
        selector = new ButtonGroup();
        transparent = new ImageIcon("src/main/resources/Transparent.png");
        moneda100 = new JRadioButton();
        moneda100.setBorder(null);
        moneda100.setContentAreaFilled(false);
        moneda100.setIcon(transparent);
        moneda100.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        selector.add(moneda100);
        moneda100.addActionListener(this);
        moneda500 = new JRadioButton();
        moneda500.setBorder(null);
        moneda500.setOpaque(false);
        moneda500.setIcon(transparent);
        moneda500.setContentAreaFilled(false);
        moneda500.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        selector.add(moneda500);
        moneda500.addActionListener(this);
        moneda1000 = new JRadioButton();
        moneda1000.setBorder(null);
        moneda1000.setOpaque(false);
        moneda1000.setIcon(null);
        moneda1000.setContentAreaFilled(false);
        moneda1000.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moneda1000.setIcon(transparent);
        selector.add(moneda1000);
        moneda1000.addActionListener( this);
        moneda1500 = new JRadioButton();
        moneda1500.setBorder(null);
        moneda1500.setOpaque(false);
        moneda1500.setContentAreaFilled(false);
        moneda1500.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moneda1500.setIcon(transparent);
        selector.add(moneda1500);
        moneda1500.addActionListener( this);
        setLayout(new GridLayout(2,2,0,0));
        add(moneda100);
        add(moneda500);
        add(moneda1000);
        add(moneda1500);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == moneda100){
            PanelComprador.eleccion = 100;
        }
        else if(e.getSource() == moneda500){
            PanelComprador.eleccion = 500;
        }
        else if(e.getSource() == moneda1000){
            PanelComprador.eleccion = 1000;
        }
        else if(e.getSource() == moneda1500){
            PanelComprador.eleccion = 1500;
        }
    }
}
