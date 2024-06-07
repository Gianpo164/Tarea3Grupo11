package GUI;

import logica.Deposito;
import logica.EnumProductos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Producto5 extends JPanel{
    private JLabel precio;
    private JLabel codigo;
    private Super8 super8;
    Font f;
    public Producto5(Deposito deposito){
        super();
        f = null;

        try {
            f = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(17f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        precio = new JLabel("$"+ EnumProductos.SUPER8.getPrecio(), SwingConstants.LEFT);
        precio.setVisible(true);
        precio.setOpaque(true);
        precio.setBackground(new Color(9, 92, 9));
        precio.setForeground(new Color(91,199,91));
        precio.setBounds(245, 23, 68, 34);
        precio.setFont(f);

        codigo = new JLabel(String.valueOf(EnumProductos.SUPER8.codigo), SwingConstants.CENTER);
        codigo.setVisible(true);
        codigo.setBounds(150, 20, 77, 41);
        codigo.setFont(f);

        setLayout(null);
        setBounds(39,456,313,81);
        setOpaque(false);
        super8 = new Super8(deposito);

        add(super8);
        add(precio);
        add(codigo);
    }
}