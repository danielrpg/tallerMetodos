package uinterface;

import common.UIUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * @author dany
 */
public class ImprimirPanel extends JPanel {

    private JButton imprimir;
    private JButton salir;
    static InformationCronograma informationCronograma;

    public ImprimirPanel(InformationCronograma informationCronograma){
        this.informationCronograma = informationCronograma;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000, 50));

        imprimir = new JButton("Imprimir");
        imprimir.setBounds(650,5, 150, 35 );
        imprimir.addActionListener(new ImprimirListener());
        imprimir.setIcon(UIUtility.getInstance().getImageSizeIcon("./src/assets/printer.png", 30, 30));

        salir = new JButton("Salir");
        salir.setBounds(850, 5, 150, 35);
        salir.addActionListener(new SalirListener());
        salir.setIcon(UIUtility.getInstance().getImageSizeIcon("./src/assets/cancel.png", 30, 30));

        add(imprimir);
        add(salir);
    }

    static class ImprimirListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(informationCronograma);
                job.printDialog();
                job.print();
            } catch (PrinterException ex) {

            }
        }
    }

    static class SalirListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0); //Salir del sistema
        }
    }

}
