package GUI;

import logica.Deposito;
import logica.EnumProductos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Panel que contiene los componentes relacionados con el producto CocaCola
 */
public class Producto1 extends JPanel{
    private JLabel precio;
    private JLabel codigo;
    private CocaCola CocaCola;
    private Font f;

    /**
     * Genera el panel que contiene los componentes necesarios para dibujar los productos CocaCola
     * @param deposito contiene los productos CocaCola
     */
    public Producto1(Deposito deposito) {

        super();
        try {
            f = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(17f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        precio = new JLabel("$"+ EnumProductos.COCACOLA.getPrecio(), SwingConstants.LEFT);
        precio.setVisible(true);
        precio.setOpaque(true);
        precio.setBackground(new Color(9, 92, 9));
        precio.setForeground(new Color(91,199,91));
        precio.setBounds(245, 23, 68, 34);
        precio.setFont(f);

        codigo = new JLabel(String.valueOf(EnumProductos.COCACOLA.codigo), SwingConstants.CENTER);
        codigo.setVisible(true);
        codigo.setBounds(150, 20, 77, 41);
        codigo.setFont(f);

        setLayout(null);
        setBounds(39, 28, 313, 81);
        setOpaque(false);
        CocaCola = new CocaCola(deposito);

        add(CocaCola);
        add(precio);
        add(codigo);
    }
}