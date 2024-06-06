package org.example.gui2;

import org.example.logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelDepositoMonedas extends JPanel {
    private IngresarMoneda ingresarMoneda;
    private MonedasIngresadas monedasIngresadas;


    public PanelDepositoMonedas(Expendedor expendedor){
        setBounds(370,384,117,101);
        setLayout(null);
        setOpaque(false);
        ingresarMoneda = new IngresarMoneda(expendedor);
        monedasIngresadas = new MonedasIngresadas(expendedor);
        add(ingresarMoneda);
        add(monedasIngresadas);
        ingresarMoneda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                switch (PanelComprador.eleccion){
                    case 100 -> expendedor.insertarMoneda(new Moneda100());
                    case 500 -> expendedor.insertarMoneda(new Moneda500());
                    case 1000 -> expendedor.insertarMoneda(new Moneda1000());
                    case 1500 -> expendedor.insertarMoneda(new Moneda1500());
                }
                monedasIngresadas.repaint();
                ingresarMoneda.repaint();
            }
        });
    }
}