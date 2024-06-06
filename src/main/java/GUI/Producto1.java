package GUI;

import logica.Deposito;
import logica.EnumProductos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Producto1 extends JPanel{
    public Producto1(Deposito deposito) {
        super();
        Font f = null;

        try {
            f = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(17f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        JLabel precio = new JLabel("$"+ EnumProductos.COCACOLA.getPrecio(), SwingConstants.LEFT);
        precio.setVisible(true);
        precio.setOpaque(true);
        precio.setBackground(new Color(9, 92, 9));
        precio.setForeground(new Color(91,199,91));
        precio.setBounds(245, 23, 68, 34);
        precio.setFont(f);

        JLabel codigo = new JLabel(String.valueOf(EnumProductos.COCACOLA.codigo), SwingConstants.CENTER);
        codigo.setVisible(true);
        codigo.setBounds(150, 20, 77, 41);
        codigo.setFont(f);

        setLayout(null);
        setBounds(39, 28, 313, 81);
        setBackground(new Color(0,200,0,0));
        CocaCola CocaCola = new CocaCola(deposito);

        add(CocaCola);
        add(precio);
        add(codigo);
    }
}