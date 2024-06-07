package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel que implementa la eleccion de monedas para comprar
 */
public class SelectorMonedas extends JPanel implements ActionListener{
    private JRadioButton moneda100;
    private JRadioButton moneda500;
    private JRadioButton moneda1000;
    private JRadioButton moneda1500;
    private JRadioButton botonSeleccionado;
    private ImageIcon transparent;
    private ButtonGroup selector;

    /**
     * Crea el panel y agrega los componentes necesarios para su funcionamiento
     */
    public SelectorMonedas(){
        setBounds(52,50,128,103);
        setOpaque(false);
        selector = new ButtonGroup();
        transparent = new ImageIcon("src/main/resources/Transparent.png");
        moneda100 = createRadioButton(100);
        moneda500 = createRadioButton(500);
        moneda1000 = createRadioButton(1000);
        moneda1500 = createRadioButton(1500);

        setLayout(new GridLayout(2, 2, 0, 0));
        add(moneda100);
        add(moneda500);
        add(moneda1000);
        add(moneda1500);
    }

    /**
     * Crea un boton con caracteristicas personalizadas
     * @param value valor de la moneda
     * @return boton personalizado
     */
    private JRadioButton createRadioButton(int value) {
        JRadioButton button = new JRadioButton();
        button.setOpaque(false);
        button.setBorder(null);
        button.setIcon(transparent);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        selector.add(button);
        button.addActionListener(this);
        return button;
    }


    /**
     * Comprueba que moneda fue elegida
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e){
        botonSeleccionado = (JRadioButton) e.getSource();
        if(botonSeleccionado == moneda100){
            PanelComprador.eleccion = 100;
        }
        else if(botonSeleccionado == moneda500){
            PanelComprador.eleccion = 500;
        }
        else if(botonSeleccionado == moneda1000){
            PanelComprador.eleccion = 1000;
        }
        else if(botonSeleccionado == moneda1500){
            PanelComprador.eleccion = 1500;
        }
        repaint();
    }

    /**
     * Metodo que dibuja el tipo de moneda seleccionada
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (botonSeleccionado != null && botonSeleccionado.isSelected()) {
            Color semiTransparentBlack = new Color(0, 0, 0, 64);
            g.setColor(semiTransparentBlack);
            g.fillRect(botonSeleccionado.getX(), botonSeleccionado.getY(), botonSeleccionado.getWidth(), botonSeleccionado.getHeight());
        }
    }
}
