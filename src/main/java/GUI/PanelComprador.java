package GUI;

import logica.Expendedor;
import logica.Producto;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Panel que contiene todos los aspectos relacionados a un comprador
 */
public class PanelComprador extends JPanel {
    private Image imagenComprador;
    private Font font;
    private final Image imgCocaCola = new ImageIcon(getClass().getClassLoader().getResource("CocaCola.png")).getImage();
    private final Image imgSprite = new ImageIcon(getClass().getClassLoader().getResource("Sprite.png")).getImage();
    private final Image imgFanta = new ImageIcon(getClass().getClassLoader().getResource("Fanta.png")).getImage();
    private final Image imgSnickers = new ImageIcon(getClass().getClassLoader().getResource("Snickers.png")).getImage();
    private final Image imgSuper8 = new ImageIcon(getClass().getClassLoader().getResource("Super8.png")).getImage();
    private PanelVueltoComprador panelVueltoComprador;
    private JLabel nombreProductoComprado;
    private JLabel serieProductoComprado;
    private SelectorMonedas selecmon;
    private Expendedor expendedor;
    private logica.Producto producto;
    public static int eleccion;

    /**
     * Crea el panel y agrega sus componentes
     * @param exp clase logica que representa un expendedor
     */
    public PanelComprador(Expendedor exp){
        expendedor = exp;
        imagenComprador = new ImageIcon(getClass().getClassLoader().getResource("Comprador.png")).getImage();
        Dimension size = new Dimension(imagenComprador.getWidth(null), imagenComprador.getHeight(null));
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/RetroGaming.ttf")).deriveFont(13f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        this.setPreferredSize(size);
        setLayout(null);
        setOpaque(false);
        panelVueltoComprador = new PanelVueltoComprador();
        selecmon = new SelectorMonedas();

        nombreProductoComprado = new JLabel("", SwingConstants.CENTER);
        nombreProductoComprado.setVisible(true);
        nombreProductoComprado.setBounds(45, 225, 80, 25);
        nombreProductoComprado.setFont(font);
        nombreProductoComprado.setForeground(Color.black);

        serieProductoComprado = new JLabel("", SwingConstants.CENTER);
        serieProductoComprado.setVisible(true);
        serieProductoComprado.setBounds(42, 238, 95, 25);
        serieProductoComprado.setFont(font);
        serieProductoComprado.setForeground(Color.black);

        add(nombreProductoComprado);
        add(serieProductoComprado);
        add(selecmon);
        add(panelVueltoComprador);
    }

    /**
     * Metodo que dibuja los componentes del panel
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenComprador, 0, 0, null);

        producto = expendedor.getProductoRetirado();

        if (expendedor.getProductoRetirado().getSerie() != 0) {
            nombreProductoComprado.setText(expendedor.getNombreProducto());
            serieProductoComprado.setText("Serie: " + String.valueOf(expendedor.getProductoRetirado().getSerie()));
        }

        if(producto == null || expendedor.getProductoRetirado().getSerie() == 0){
        }else if(producto.getClass() == logica.CocaCola.class){
            g.drawImage(imgCocaCola, 70, 168, null);
        }else if(producto.getClass() == logica.Sprite.class){
            g.drawImage(imgSprite, 70 , 168, null);
        }else if(producto.getClass() == logica.Fanta.class){
            g.drawImage(imgFanta, 70, 168, null);
        }else if(producto.getClass() == logica.Snickers.class){
            g.drawImage(imgSnickers, 56, 168, null);
        }else if(producto.getClass() == logica.Super8.class){
            g.drawImage(imgSuper8, 56, 168, null);
        }
    }
}
