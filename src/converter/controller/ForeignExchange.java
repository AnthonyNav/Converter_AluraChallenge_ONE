package src.converter.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import src.converter.views.GeneralDecision;
import src.converter.views.GeneralMenu;

public class ForeignExchange extends Thread{
    private static String[] foreignExchange = {"MXN a Dolares", "MXN a Euros", "MXN a Libras Esterlinas", "MXN a Yen Japonés", "MXN a Won sur-coreano","Dolares a MXN", "Euros a MXN", "Libras Esterlinas a MXN", "Yen Japonés a MXN", "Won sul-coreano a MXN"};
    private double[] values = {0.053, 0.049, 0.043, 6.99,69.08};
    GeneralDecision gdes;

    public ForeignExchange(GeneralDecision gd){
        this.gdes = gd;
    }

    @Override
    public void run(){
        GeneralMenu foreignExchangeMenu = new GeneralMenu(foreignExchange, "Seleccione la conversión", "Divisas");
        foreignExchangeMenu.setVisible(true);
        Icon icon = new ImageIcon("src/resources/exchange.png");
        foreignExchangeMenu.configButtonAccept(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Input
                foreignExchangeMenu.setVisible(false);
                double valueInput = foreignExchangeMenu.getInput("Dame la cantidad de dinero que deseas convertir", icon);
                
                String optionSelected = (String) foreignExchangeMenu.getMenu().getSelectedItem();
                int posOpt = whereIs(optionSelected);
                // Operaciones
                double result = -1;
                if(posOpt <= 4){
                    result = mxn_other(valueInput, posOpt);
                }
                else{
                    result = other_mxn(valueInput, posOpt);
                }
                // Mostrar resultados
                result = Double.parseDouble(String.format(String.format("%%.%df", 3), result)); 
                JOptionPane.showMessageDialog(null, "La conversion de "+valueInput +" "+ optionSelected + " es "+ result);
                foreignExchangeMenu.nextJFrame(gdes);
            }
        });
    }
    

    // metodos para el conversor de divisas
    private double mxn_other(double input, int position){
        return (input*values[position]);
    }
    private double other_mxn(double input, int position){
        return (input/values[position-5]);
    }
    private int whereIs(String objetive){
        int posicion = Arrays.asList(foreignExchange).indexOf(objetive);
        return posicion;
    }
}
