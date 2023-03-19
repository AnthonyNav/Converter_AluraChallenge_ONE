package src.converter.views;

// Importaciones
import javax.swing.*;
import java.awt.*;

public class GeneralJFrame extends JFrame{
    private JPanel mainPanel;

    public GeneralJFrame(){
        // Configuración del JFrame
        setTitle("Titulo general");
        setIconImage(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        // Configuración del panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        setContentPane(mainPanel);
        setResizable(false);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}