package uinterface;

import model.ObservacionModel;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.*;

/**
 * @author dany
 */
public class InformationCronograma extends JPanel implements Printable{

    private JLabel lbTitle;
    private ObservacionTable observacionTable;
    private CronogramaFormulario cronogramaFormulario;


    public InformationCronograma(){
        super();
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("CRONOGRAMA DE OBSERVACION"));
        ObservacionModel observacionModel = new ObservacionModel();
        java.util.List<ObservacionModel> list = new ArrayList<ObservacionModel>();
        list.add(observacionModel);
        observacionTable = new ObservacionTable(list);
        JTable table = new JTable(observacionTable);

        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(new CronogramaFormulario(), BorderLayout.NORTH);
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

    public ObservacionTable getObservacionTable() {
        return observacionTable;
    }

    public void setObservacionTable(ObservacionTable observacionTable) {
        this.observacionTable = observacionTable;
    }
}
