package GUI;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelVueltoExpendedor extends JPanel implements ActionListener {
    private Expendedor expendedor;
    private JButton Bmoneda100;
    private JButton Bmoneda500;
    private JButton Bmoneda1000;
    private JButton Bmoneda1500;
    private Image moneda100 = new ImageIcon(getClass().getClassLoader().getResource("Moneda100.png")).getImage();
    private Image moneda500 = new ImageIcon(getClass().getClassLoader().getResource("Moneda500.png")).getImage();
    private Image moneda1000 = new ImageIcon(getClass().getClassLoader().getResource("Moneda1000.png")).getImage();
    private Image moneda1500 = new ImageIcon(getClass().getClassLoader().getResource("Moneda1500.png")).getImage();

    public PanelVueltoExpendedor(Expendedor expendedor){
        setBounds(379,524,100,61);

        setOpaque(false);
        this.expendedor = expendedor;
        Bmoneda100 = new JButton();
        Bmoneda500 = new JButton();
        Bmoneda1000 = new JButton();
        Bmoneda1500 = new JButton();
        Bmoneda100.setFocusable(false);
        Bmoneda500.setFocusable(false);
        Bmoneda1000.setFocusable(false);
        Bmoneda1500.setFocusable(false);
        Bmoneda100.setContentAreaFilled(false);
        Bmoneda500.setContentAreaFilled(false);
        Bmoneda1000.setContentAreaFilled(false);
        Bmoneda1500.setContentAreaFilled(false);
        Bmoneda100.addActionListener(this);
        Bmoneda500.addActionListener(this);
        Bmoneda1000.addActionListener(this);
        Bmoneda1500.addActionListener(this);
        Bmoneda100.setBorder(null);
        Bmoneda500.setBorder(null);
        Bmoneda1000.setBorder(null);
        Bmoneda1500.setBorder(null);

        setLayout(new GridLayout(1, 4, 3,0));
        add(Bmoneda100);
        add(Bmoneda500);
        add(Bmoneda1000);
        add(Bmoneda1500);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Bmoneda100){
            for(int i = 0; i < expendedor.getMonVu().getSizeDeposito(); i++){
                if(expendedor.getMonVu().getDepositoMonedas().get(i).getClass() == Moneda100.class){
                    expendedor.getVuelto(i);
                    break;
                }
            }
        }
        else if(e.getSource() == Bmoneda500){
            for(int i = 0; i < expendedor.getMonVu().getSizeDeposito(); i++){
                if(expendedor.getMonVu().getDepositoMonedas().get(i).getClass() == Moneda500.class){
                    expendedor.getVuelto(i);
                    break;
                }
            }
        }
        else if(e.getSource() == Bmoneda1000){
            for(int i = 0; i < expendedor.getMonVu().getSizeDeposito(); i++){
                if(expendedor.getMonVu().getDepositoMonedas().get(i).getClass() == Moneda1000.class){
                    expendedor.getVuelto(i);
                    break;
                }
            }
        }
        else if(e.getSource() == Bmoneda1500){
            for(int i = 0; i < expendedor.getMonVu().getSizeDeposito(); i++){
                if(expendedor.getMonVu().getDepositoMonedas().get(i).getClass() == Moneda1500.class){
                    expendedor.getVuelto(i);
                    break;
                }
            }
        }
        this.repaint();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int stack100 = 0;
        int stack500 = 0;
        int stack1000 = 0;
        int stack1500 = 0;
        for(int i = 0; i < expendedor.getMonVu().getSizeDeposito(); i++){
            if(expendedor.getMonVu().getDepositoMonedas().get(i).getClass() == Moneda100.class){
                g.drawImage(moneda100, 4, 46 - stack100*6, null);
                stack100++;
            }else if(expendedor.getMonVu().getDepositoMonedas().get(i).getClass() == Moneda500.class){
                g.drawImage(moneda500, 29, 46 - stack500*6, null);
                stack500++;
            }else if(expendedor.getMonVu().getDepositoMonedas().get(i).getClass() == Moneda1000.class){
                g.drawImage(moneda1000, 54, 46 - stack1000*6, null);
                stack1000++;
            }else if(expendedor.getMonVu().getDepositoMonedas().get(i).getClass() == Moneda1500.class){
                g.drawImage(moneda1500, 79, 46 - stack1500*6, null);
                stack1500++;
            }
        }
    }
}


