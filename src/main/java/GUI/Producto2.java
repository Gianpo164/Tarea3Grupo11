package GUI;

import logica.Deposito;
import logica.EnumProductos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Producto2 extends JPanel{
    private JLabel precio;
    private JLabel codigo;
    private Sprite sprite;
    Font f;
    public Producto2(Deposito deposito){
        super();

        try {
            f = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(17f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        precio = new JLabel("$"+ EnumProductos.SPRITE.getPrecio(), SwingConstants.LEFT);
        precio.setVisible(true);
        precio.setOpaque(true);
        precio.setBackground(new Color(9, 92, 9));
        precio.setForeground(new Color(91,199,91));
        precio.setBounds(245, 23, 68, 34);
        precio.setFont(f);

        codigo = new JLabel(String.valueOf(EnumProductos.SPRITE.codigo), SwingConstants.CENTER);
        codigo.setVisible(true);
        codigo.setBounds(150, 20, 77, 41);
        codigo.setFont(f);

        setLayout(null);
        setBounds(39,135,313,81);
        setOpaque(false);
        sprite = new Sprite(deposito);

        add(sprite);
        add(precio);
        add(codigo);
    }
}