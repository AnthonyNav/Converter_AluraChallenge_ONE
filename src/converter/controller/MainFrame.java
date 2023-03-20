package src.converter.controller;
import javax.swing.*;

import src.converter.views.GeneralDecision;
import src.converter.views.GeneralJFrame;
import src.converter.views.GeneralMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainFrame extends GeneralJFrame implements ActionListener{
    private static String[] convertionOptions = {"Conversor de monedas", "Conversor de temperatura"};
    private static String[] foreignExchange = {"MXN a Dolares", "MXN a Euros", "MXN a Libras Esterlinas", "MXN a Yen Japonés", "MXN a Won sur-coreano","Dolares a MXN", "Euros a MXN", "Libras Esterlinas a MXN", "Yen Japonés a MXN", "Won sul-coreano a MXN"};
    private double[] values = {0.053, 0.049, 0.043, 6.99,69.08};
    private double valueInput;

    MainFrame(){
        //Inicializamos clases
        super();
        GeneralMenu mainMenu = new GeneralMenu(convertionOptions,"Escoja un conversor","Menu");
        GeneralDecision warning = new GeneralDecision("¿Desea continuar con el programa?", "Salida");
        GeneralMenu foreignExchangeMenu = new GeneralMenu(foreignExchange, "Seleccione la conversión", "Divisas");
        String formato = String.format("%%.%df", 3);

        mainMenu.setVisible(true);
        mainMenu.configButtonAccept(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.setVisible(false);
                valueInput = optionSelected();
                foreignExchangeMenu.setVisible(true);
            }
        });

        foreignExchangeMenu.configButtonAccept(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foreignExchangeMenu.setVisible(false);
                String optionSelected = (String) foreignExchangeMenu.getMenu().getSelectedItem();
                System.out.println("La opción seleccionada es :"+optionSelected);
                int posOpt = whereIs(optionSelected);
                if(posOpt <= 4){
                    double result = mxn_other(valueInput, posOpt);
                    String formatedNum = String.format(formato, result);
                    JOptionPane.showMessageDialog(null, "La conversión de "+ valueInput +" "+ optionSelected +" es " + formatedNum);
                }
                else{
                    double result = other_mxn(valueInput, posOpt);
                    String formatedNum = String.format(formato, result);
                    JOptionPane.showMessageDialog(null, "La conversión de "+ valueInput +" "+ optionSelected +" es " + formatedNum);
                }
                warning.setVisible(true);
            }
        });
        warning.configButtonYes(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warning.setVisible(false);
                mainMenu.setVisible(true);
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
    private double optionSelected(){
        String numStr = JOptionPane.showInputDialog(null, "Dame un número");
        try {
            double number = Double.parseDouble(numStr);
            return number;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El input no es un número válido.");
            return optionSelected();
        }
    }
    private int whereIs(String objetive){
        int posicion = Arrays.asList(foreignExchange).indexOf(objetive);
        System.out.println("La posición es :"+posicion);
        return posicion;
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
