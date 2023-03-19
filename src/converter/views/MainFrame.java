package src.converter.views;
import javax.swing.*;
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
