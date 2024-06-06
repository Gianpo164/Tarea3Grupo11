package GUI;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Image imagenExpendedor;

    //private Expendedor Expendedor = new Expendedor(10);

    public PanelExpendedor(Expendedor expendedor) {
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

        RecogerBebida RecogerBebida = new RecogerBebida();
        PanelSelector panelSelector = new PanelSelector(expendedor);
        IngresarMoneda ingresarMoneda = new IngresarMoneda(expendedor);

        add(RecogerBebida);
        add(panelSelector);
        add(ingresarMoneda);

        setOpaque(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenExpendedor, 0, 0, null);
    }
}

//productos
//x 46 y 38 x 284 y 122   "84" "23"
//x 46 y 145 x 284 y 229
//x 46 y 252 x 284 y 336
//x 46 y 359 x 284 y 443
//x 46 y 466 x 284 y 550
//panel derecha
//superior izquierda x 368 y 24
//inferior derecha x 506 y 799