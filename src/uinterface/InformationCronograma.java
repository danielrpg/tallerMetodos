package uinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 * @author dany
 */
public class InformationCronograma extends JPanel implements Printable{

    private JLabel lbTitle;
    private ObservacionTable observacionTable;

    public InformationCronograma(){
        super();
        this.setLayout(new BorderLayout());
        lbTitle = new JLabel("CRONOGRAMA DE OBSERVACION");
        observacionTable = new ObservacionTable();

        this.add(lbTitle, BorderLayout.NORTH);
        this.add(observacionTable, BorderLayout.CENTER);
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D)graphics;
        //Punto donde empezará a imprimir dentro la pagina (100, 50)
        g2d.translate(  pageFormat.getImageableX()+100,
                pageFormat.getImageableY()+50);
        g2d.scale(0.50,0.50); //Reducción de la impresión al 50%
       //jPanel1.printAll(graphics);
        return PAGE_EXISTS;
    }
}
