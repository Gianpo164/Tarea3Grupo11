package GUI;

import logica.*;

import javax.swing.*;

/**
 * Marco inicial del programa
 */
public class Ventana extends JFrame {
    /**
     * Crea la ventana que será la base del programa
     */
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
