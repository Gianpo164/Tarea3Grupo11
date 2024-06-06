package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Pantalla extends JTextField {
    Font fuente;
    public Pantalla(){
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(35f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        setBounds(0,0,124,65);
        setOpaque(false);
        setForeground(new Color(91,199,91));
        setBorder(null);
        setFont(fuente);
        setHorizontalAlignment(JTextField.CENTER);
        setFocusable(false);
    }
}
