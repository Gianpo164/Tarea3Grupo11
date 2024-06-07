package GUI;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que incluye todos los aspectos relacionados a comprar productos
 */
public class PanelExpendedor extends JPanel {
    private Image imagenExpendedor;
    private PanelRecogerProducto panelRecogerProducto;
    private PanelSelector panelSelector;
    private PanelDepositoMonedas panelDepositoMonedas;
    private PanelVueltoExpendedor panelVueltoExpendedor;

    /**
     * Crea el panel y agrega sus componentes
     * @param expendedor clase logica que representa un expendedor
     * @param panelComp panel que relaciona los componentes del comprador
     */
    public PanelExpendedor(Expendedor expendedor, PanelComprador panelComp) {
        super();
        imagenExpendedor = new ImageIcon(getClass().getClassLoader().getResource("Expendedor.png")).getImage();
        Dimension size = new Dimension(imagenExpendedor.getWidth(null), imagenExpendedor.getHeight(null));
        this.setPreferredSize(size);
        setLayout(null);
        setPreferredSize(new Dimension(500, 800));

        Producto1 Producto1 = new Producto1(expendedor.getDeposito(0));
        Producto2 Producto2 = new Producto2(expendedor.getDeposito(1));
        Producto3 Producto3 = new Producto3(expendedor.getDeposito(2));
        Producto4 Producto4 = new Producto4(expendedor.getDeposito(3));
        Producto5 Producto5 = new Producto5(expendedor.getDeposito(4));

        add(Producto1);
        add(Producto2);
        add(Producto3);
        add(Producto4);
        add(Producto5);

        panelRecogerProducto = new PanelRecogerProducto(expendedor, panelComp);
        panelDepositoMonedas = new PanelDepositoMonedas(expendedor);
        panelVueltoExpendedor = new PanelVueltoExpendedor(expendedor);
        panelSelector = new PanelSelector(expendedor,this);

        add(panelVueltoExpendedor);
        add(panelRecogerProducto);
        add(panelSelector);
        add(panelDepositoMonedas);

        setOpaque(true);
    }


    /**
     * Metodo que dibuja los componentes del panel
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenExpendedor, 0, 0, null);
        panelVueltoExpendedor.repaint();
        panelDepositoMonedas.repaint();
        panelSelector.repaint();
    }
}