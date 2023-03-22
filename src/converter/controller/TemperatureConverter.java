package src.converter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import src.converter.views.GeneralDecision;
import src.converter.views.GeneralMenu;

public class TemperatureConverter extends Thread {
    private static String[] temperatureScales = {"De °C a °F", "De °F a °C", "De °K a °C", "De °C a °K", "De °F a °K","De K a ºF"};
    GeneralDecision gdes;
    
    public TemperatureConverter(GeneralDecision gd){
        this.gdes = gd;
    }

    @Override
    public void run(){
        GeneralMenu temperatureScalesMenu = new GeneralMenu(temperatureScales, "Seleccione la conversión", "Temperaturas");
        temperatureScalesMenu.setVisible(true);
        Icon icon = new ImageIcon("src/resources/temperature.png");
        temperatureScalesMenu.configButtonAccept(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temperatureScalesMenu.setVisible(false);
                double valueInput = temperatureScalesMenu.getInput("Dame la cantidad a convertir",icon);
                String optionSelected = (String) temperatureScalesMenu.getMenu().getSelectedItem();
                double result=-1;
                switch (optionSelected) {
                    case "De °C a °F":
                        result = c_f(valueInput);
                        break;
                    case "De °F a °C":
                        result = f_c(valueInput);
                    break;
                    case "De °K a °C":
                        result = k_c(valueInput);
                    break;
                    case "De °C a °K":
                        result = c_k(valueInput);
                    break;
                    case "De °F a °K":
                        result = f_k(valueInput);
                    break;
                    case "De K a ºF":
                        result = k_f(valueInput);
                    break;
                }
                result = Double.parseDouble(String.format(String.format("%%.%df", 3), result));
                JOptionPane.showMessageDialog(null, "La conversion de "+valueInput +" "+ optionSelected + " es "+ result);
                temperatureScalesMenu.nextJFrame(gdes);
            }
        });
    }

    private double c_f(double c){
        return ((c*1.8) + 32);
    }

    private double f_c(double f){
        return ((f-32)/1.8);
    }

    private double k_c(double k){
        return (k - 273.15);
    }

    private double c_k(double c){
        return (c + 273.15);
    }

    private double f_k(double f){
        return (((5)*(f-32))/9 + 273.15);
    }

    private double k_f(double k){
        return (1.8*(k-273.15) + 32);
    }

}
