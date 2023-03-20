package src.converter.views;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralDecision extends GeneralJFrame implements ActionListener {
    private JButton buttonYes;
    private JButton buttonNo;

    public GeneralDecision(String questionText, String title){
        super();
        setTitle(title);
        JLabel question = new JLabel(questionText);
        
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        buttonYes = new JButton("Si");
        panelButtons.add(buttonYes);

        // Boton Cancel
        buttonNo = new JButton("No");
        buttonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
            
        });
        panelButtons.add(buttonNo);
        super.getMainPanel().setPreferredSize(new Dimension(250,60));
        // super.getMainPanel().setLayout(new BoxLayout(super.getMainPanel(), BoxLayout.Y_AXIS));

        super.getMainPanel().add(question);
        super.getMainPanel().add(panelButtons);
        pack();
    }

    public void configButtonYes(ActionListener listener) {
        buttonYes.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    // public static void main(String[] args) {
    //     GeneralDecision continueApp = new GeneralDecision("¿Desea continuar?", "Choose");
    //     continueApp.setVisible(true);
    // }


}
