package GUI;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelRecogerProducto extends JPanel {
    private final Image imgCocaCola = new ImageIcon(getClass().getClassLoader().getResource("CocaCola.png")).getImage();
    private final Image imgSprite = new ImageIcon(getClass().getClassLoader().getResource("Sprite.png")).getImage();
    private final Image imgFanta = new ImageIcon(getClass().getClassLoader().getResource("Fanta.png")).getImage();
    private final Image imgSnickers = new ImageIcon(getClass().getClassLoader().getResource("Snickers.png")).getImage();
    private final Image imgSuper8 = new ImageIcon(getClass().getClassLoader().getResource("Super8.png")).getImage();
    PanelComprador panelComprador;
    Expendedor expendedor;
    Producto producto;
    public PanelRecogerProducto(Expendedor exp, PanelComprador pComprador){
        super();
        panelComprador = pComprador;
        expendedor = exp;
        setOpaque(false);
        setBounds(88,612,242,63);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                expendedor.recogerProducto();
                repaint();
            }
        });

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        producto = expendedor.getProductoComprado();
        if(producto == null){

        }else if(producto.getClass() == logica.CocaCola.class){
            g.drawImage(imgCocaCola, 100, 0, null);
        }else if(producto.getClass() == logica.Sprite.class){
            g.drawImage(imgSprite, 100, 0, null);
        }else if(producto.getClass() == logica.Fanta.class){
            g.drawImage(imgFanta, 100, 0, null);
        }else if(producto.getClass() == logica.Snickers.class){
            g.drawImage(imgSnickers, 100, 0, null);
        }else if(producto.getClass() == logica.Super8.class){
            g.drawImage(imgSuper8, 100, 0, null);
        }
        panelComprador.repaint();
    }
}