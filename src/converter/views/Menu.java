package src.converter.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends GeneralJFrame{
    private String option;
    private JButton buttonAccept;
    private JButton buttonCancel;
    private JComboBox<String> menu;
    private String[] options = {"Conversor de divisas", "Conversor de temperatura"};
    private JPanel panelButtons;
    private JLabel hint;

    public Menu(){
        // Definiendo el Jframe
        super();
        setTitle("Menu");

        // Definiendo el texto indicaciones
        hint = new JLabel("Selecciona un tipo de conversor");
        // hint.setHorizontalAlignment(JLabel.CENTER);
        // Definiendo el menu desplegable

        menu = new JComboBox<>(options);
        menu.setBounds(0, 0, 250, 50);

        // Definiendo un panel

        panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Definiendo botones

        // Boton Ok
        buttonAccept = new JButton("Aceptar");
        panelButtons.add(buttonAccept);

        // Boton Cancel
        buttonCancel = new JButton("Cancelar");
        panelButtons.add(buttonCancel);
        
        actions();
    }

    public JButton getButtonAccept() {
        return buttonAccept;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    private void actions(){
        // Añadiendo elementos
        getMainPanel().setPreferredSize(new Dimension(255,85));
        getMainPanel().add(hint);
        getMainPanel().add(Box.createVerticalStrut(3));
        getMainPanel().add(menu);
        getMainPanel().add(Box.createVerticalStrut(3));
        getMainPanel().add(panelButtons);

        // Acoplando Jframe y Jpanel
        pack();
    }

    public String getOptionSelected(){
        return option;
    }

    public void configButtonAccept(ActionListener listener) {
        buttonAccept.addActionListener(listener);
    }

    public void configButtonCancel(ActionListener listener) {
        buttonCancel.addActionListener(listener);
    }


    // public static void main(String[] args) {
    //     Menu menu = new Menu();
    //     menu.setVisible(true);
    // }
}
