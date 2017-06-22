package uinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author dany
 */
public class ImprimirPanel extends JPanel {

    private JButton imprimir;
    private JButton salir;

    public ImprimirPanel(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000, 50));

        imprimir = new JButton("Imprimir");
        imprimir.setBounds(700,5, 100, 30 );

        salir = new JButton("Salir");
        salir.setBounds(850, 5, 100, 30);
        salir.addActionListener(new SalirListener());

        add(imprimir);
        add(salir);
    }

    static class SalirListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0); //Salir del sistema
        }
    }

}
