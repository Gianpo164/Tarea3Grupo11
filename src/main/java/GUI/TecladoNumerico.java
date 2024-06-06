package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TecladoNumerico extends JPanel {
    JButton Comprar;
    JButton CancelarCompra;
    JButton[] numeros;
    Font fuente;

    public TecladoNumerico() {
        setBounds(5, 116, 115, 159);
        setOpaque(false);
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(22f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        numeros = new JButton[10];
        Comprar = new JButton();
        Comprar.setFocusable(false);
        Comprar.setBorder(null);
        Comprar.setOpaque(false);
        Comprar.setContentAreaFilled(false);
        Comprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        CancelarCompra = new JButton();
        CancelarCompra.setFocusable(false);
        CancelarCompra.setBorder(null);
        CancelarCompra.setOpaque(false);
        CancelarCompra.setContentAreaFilled(false);
        CancelarCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        for (int i = 0; i < 10; i++) {
            numeros[i] = new JButton(String.valueOf(i));
            numeros[i].setFont(fuente);
            numeros[i].setFocusable(false);
            numeros[i].setBorder(null);
            numeros[i].setOpaque(false);
            numeros[i].setContentAreaFilled(false);
            numeros[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        setLayout(new GridLayout(4, 3, 10, 18));
        for (int i = 1; i < 10; i++) {
            add(numeros[i]);
        }
        add(CancelarCompra);
        add(numeros[0]);
        add(Comprar);
    }
}
