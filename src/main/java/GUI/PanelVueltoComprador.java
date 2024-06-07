package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Panel que maneja la visualizacion del vuelto recibido
 */
public class PanelVueltoComprador extends JPanel {
    Font fuente;
    private static int valorVuelto;
    private static JLabel vuelto;
    private JLabel indicador;

    /**
     * Crea el panel y agrega sus componentes
     */
    public PanelVueltoComprador(){
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(13f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        setBounds(112, 212, 70, 30);
        setLayout(null);

        valorVuelto = 0;
        indicador = new JLabel("Vuelto");
        vuelto = new JLabel("$" + String.valueOf(valorVuelto));


        indicador.setBounds(5, 0, 70, 15);
        vuelto.setBounds(5, 15, 70, 15);

        indicador.setFont(fuente);
        vuelto.setFont(fuente);

        indicador.setHorizontalAlignment(JTextField.CENTER);
        vuelto.setHorizontalAlignment(JTextField.CENTER);

        indicador.setForeground(Color.black);
        vuelto.setForeground(Color.black);

        setOpaque(false);
        add(vuelto);
        add(indicador);
    }

    /**
     * Metodo que asigna el vuelto
     * @param v valor total del vuelto
     */
    public static void setVuelto(int v){
        valorVuelto += v;
        vuelto.setText("$" + String.valueOf(valorVuelto));
    }

}
