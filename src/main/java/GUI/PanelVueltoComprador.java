package GUI;

import logica.Comprador;
import logica.EnumProductos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanelVueltoComprador extends JPanel {
    Font fuente;
    private JLabel indicador;
    private JLabel vuelto;

    public PanelVueltoComprador(){
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(14f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        setBounds(112, 212, 70, 30);
        setLayout(null);
        indicador = new JLabel("Vuelto");
        vuelto = new JLabel("");
        vuelto.setText("$" + String.valueOf(Comprador.cuantoVuelto()));
        indicador.setBounds(5, 0, 70, 15);
        vuelto.setBounds(5, 15, 70, 15);
        indicador.setFont(fuente);
        vuelto.setFont(fuente);
        vuelto.setBackground(Color.white);
        indicador.setHorizontalAlignment(JTextField.CENTER);
        vuelto.setHorizontalAlignment(JTextField.CENTER);
        indicador.setForeground(Color.black);
        vuelto.setForeground(Color.black);
        setOpaque(false);
        add(vuelto);
        add(indicador);
        setBounds(112, 212, 70, 30);
    }
}
