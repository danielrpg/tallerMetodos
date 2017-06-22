package uinterface;

import javax.swing.*;
import java.awt.*;

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

        add(imprimir);
        add(salir);
    }

}
