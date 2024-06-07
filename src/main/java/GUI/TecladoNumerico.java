package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Panel que genera los botones y elementos necesarios para el funcionamiento del teclado numerico
 */
public class TecladoNumerico extends JPanel {
    JButton comprar;
    JButton cancelarCompra;
    JButton[] numeros;
    Font fuente;

    /**
     * Genera el teclado numerico con los botones utilizados para interactuar con el expendedor
     */
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
        cancelarCompra = new JButton();
        comprar = new JButton();

        ConfigurarButtons(comprar);
        ConfigurarButtons(cancelarCompra);
        for (int i = 0; i < 10; i++) {
            numeros[i] = new JButton(String.valueOf(i));
            numeros[i].setFont(fuente);
            ConfigurarButtons(numeros[i]);
        }

        setLayout(new GridLayout(4, 3, 10, 18));
        for (int i = 1; i < 10; i++) {
            add(numeros[i]);
        }
        add(cancelarCompra);
        add(numeros[0]);
        add(comprar);
    }

    /**
     * Modifica los componentes de los botones necesarios para su funcionamiento
     * @param button Boton utilizado en el teclado
     */
    private void ConfigurarButtons(JButton button){
        button.setFocusable(false);
        button.setBorder(null);
        button.setContentAreaFilled(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
