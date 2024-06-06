package GUI;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;


public class PanelPrincipal extends JPanel {
    public static PanelExpendedor panelExpendedor;
    PanelComprador panelComprador;

    public PanelPrincipal(Expendedor expendedor){
        panelExpendedor = new PanelExpendedor(expendedor);
        panelComprador = new PanelComprador();
        //setPreferredSize(new Dimension(1000,1000));
        setLayout(new BorderLayout());
        add(panelExpendedor,BorderLayout.WEST);
        add(panelComprador,BorderLayout.EAST);
        //add(panelMonedas);
    }
    public static PanelExpendedor getPanel(){
        return panelExpendedor;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}

