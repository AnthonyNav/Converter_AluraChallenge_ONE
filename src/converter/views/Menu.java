package src.converter.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends GeneralJFrame implements ActionListener{
    private String option;
    private JButton buttonAccept;
    private JButton buttonCancel;
    private JComboBox<String> menu;
    private String[] options = {"Conversor de divisas", "Conversor de temperatura"};
    JPanel panelButtons;

    public Menu(){
        // Definiendo el Jframe
        super();
        setTitle("Menu");
        // Definiendo el menu desplegable

        menu = new JComboBox<>(options);
        menu.setBounds(0, 0, 250, 50);

        // Definiendo un panel

        panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Definiendo botones

        // Boton Ok
        buttonAccept = new JButton("Aceptar");
        buttonAccept.setActionCommand("buttonAccept");
        buttonAccept.addActionListener(this);
        panelButtons.add(buttonAccept);

        // Boton Cancel
        buttonCancel = new JButton("Cancelar");
        buttonCancel.setActionCommand("buttonCancel");
        buttonCancel.addActionListener(this);
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
        // Modificando BoxLayouts
        getMainPanel().setLayout(new BoxLayout(getMainPanel(), BoxLayout.Y_AXIS));
        // Añadiendo elementos

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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    // public static void main(String[] args) {
    //     Menu menu = new Menu();
    //     menu.setVisible(true);
    // }
}
