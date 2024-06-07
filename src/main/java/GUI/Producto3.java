package GUI;

import logica.Deposito;
import logica.EnumProductos;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Panel que contiene los componentes relacionados con el producto Fanta
 */
public class Producto3 extends JPanel{
    private JLabel precio;
    private JLabel codigo;
    private Fanta fanta;
    Font f;

    /**
     * Genera el panel que contiene los componentes necesarios para dibujar los productos Fanta
     * @param deposito contiene los productos Fanta
     */
    public Producto3(Deposito deposito){
        super();

        try {
            f = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(17f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        precio = new JLabel("$"+ EnumProductos.FANTA.getPrecio(), SwingConstants.LEFT);
        precio.setVisible(true);
        precio.setOpaque(true);
        precio.setBackground(new Color(9, 92, 9));
        precio.setForeground(new Color(91,199,91));
        precio.setBounds(245, 23, 68, 34);
        precio.setFont(f);

        codigo = new JLabel(String.valueOf(EnumProductos.FANTA.codigo), SwingConstants.CENTER);
        codigo.setVisible(true);
        codigo.setBounds(150, 20, 77, 41);
        codigo.setFont(f);

        setLayout(null);
        setBounds(39,242,313,81);
        setOpaque(false);
        fanta = new Fanta(deposito);

        add(fanta);
        add(precio);
        add(codigo);
    }
}