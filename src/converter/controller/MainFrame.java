package src.converter.controller;
import javax.swing.*;

import src.converter.views.GeneralJFrame;
import src.converter.views.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends GeneralJFrame implements ActionListener{
    Menu menu = new Menu();

    MainFrame(){
        super();
        menu.setVisible(true);
        menu.configButtonAccept(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hiciste click en aceptar");
                String numStr = JOptionPane.showInputDialog(null, "Dame un número");
                int num = Integer.parseInt(numStr);
                System.out.println(num);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args) {
        MainFrame main = new MainFrame();
    }
}
