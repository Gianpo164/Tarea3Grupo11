package GUI;

import logica.*;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana(){
        Expendedor expendedor = new Expendedor(10);

        PanelPrincipal panelPrincipal = new PanelPrincipal(expendedor);

        add(panelPrincipal);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
