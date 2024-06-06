package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectorMonedas extends JPanel implements ActionListener{
    private JRadioButton moneda100;
    private JRadioButton moneda500;
    private JRadioButton moneda1000;
    private JRadioButton moneda1500;
    private ImageIcon transparent;
    private ButtonGroup selector;

    public SelectorMonedas(){
        setBounds(52,51,128,100);
        setOpaque(false);
        selector = new ButtonGroup();
        transparent = new ImageIcon("src/main/resources/Transparent.png");

        moneda100 = createRadioButton(100);
        moneda500 = createRadioButton(500);
        moneda1000 = createRadioButton(1000);
        moneda1500 = createRadioButton(1500);

        setLayout(new GridLayout(2, 2, 0, 0));
        add(moneda100);
        add(moneda500);
        add(moneda1000);
        add(moneda1500);
    }

    private JRadioButton createRadioButton(int value) {
        JRadioButton button = new JRadioButton();
        button.setBorder(null);
        button.setContentAreaFilled(false);
        button.setIcon(transparent);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        selector.add(button);
        button.addActionListener(this);
        return button;
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
