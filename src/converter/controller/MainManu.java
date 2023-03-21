package src.converter.controller;
import src.converter.views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainManu{
    private static String[] convertionOptions = {"Conversor de monedas", "Conversor de temperatura"};
    private static String optionSelected;

    public static void main(String[] args) throws InterruptedException {

        GeneralMenu mainMenu = new GeneralMenu(convertionOptions,"Escoja un conversor","Menu");
        GeneralDecision warning = new GeneralDecision("¿Desea continuar con el programa?", "Salida");

        mainMenu.setVisible(true);
        mainMenu.configButtonAccept(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.setVisible(false);
                ForeignExchange moneyConversor = new ForeignExchange(warning);
                TemperatureConverter scaleConversor = new TemperatureConverter(warning);
                optionSelected = (String) mainMenu.getMenu().getSelectedItem();
                switch(optionSelected){
                    case "Conversor de monedas":
                    moneyConversor.start();
                    break;
                    case "Conversor de temperatura":
                    scaleConversor.start();
                    break;
                }
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
}
