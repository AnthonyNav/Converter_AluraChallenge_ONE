package src.converter.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralMenu extends GeneralJFrame implements ActionListener{
    private JButton buttonAccept;
    private JButton buttonCancel;
    private JComboBox<String> menu;
    private JPanel panelButtons;

    public GeneralMenu(String[] options, String jlabelText, String title){
        // Definiendo el Jframe
        super();
        setTitle(title);
        JLabel hint = new JLabel(jlabelText);
        // hint.setHorizontalAlignment(JLabel.CENTER);
        // Definiendo el menu desplegable

        menu = new JComboBox<>(options);
        getMainPanel().add(hint);

        // Definiendo un panel

        panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Definiendo botones

        // Boton Ok
        buttonAccept = new JButton("Aceptar");
        panelButtons.add(buttonAccept);

        // Boton Cancel
        buttonCancel = new JButton("Cancelar");
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
            
        });
        panelButtons.add(buttonCancel);
        
        actions();
    }


    private void actions(){
        // Añadiendo elementos
        getMainPanel().setPreferredSize(new Dimension(255,85));
        getMainPanel().add(Box.createVerticalStrut(3));
        getMainPanel().add(menu);
        getMainPanel().add(Box.createVerticalStrut(3));
        getMainPanel().add(panelButtons);

        // Acoplando Jframe y Jpanel
        pack();
    }

    public void configButtonAccept(ActionListener listener) {
        buttonAccept.addActionListener(listener);
    }

    // public void configButtonCancel(ActionListener listener) {
    //     buttonCancel.addActionListener(listener);
    // }

    public JComboBox<String> getMenu() {
        return menu;
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
