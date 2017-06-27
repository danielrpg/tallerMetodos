package uinterface;

import controller.CronogramaController;
import model.ObservacionModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
    private CronogramaController cronogramaController;
    JTable table;


    public InformationCronograma(CronogramaController cronogramaController){
        super();
        this.cronogramaController = cronogramaController;
        this.setLayout(new BorderLayout());
      //  this.setBorder(BorderFactory.createTitledBorder("CRONOGRAMA DE OBSERVACION"));
        ObservacionModel observacionModel = new ObservacionModel();
        /*java.util.List<ObservacionModel> list = new ArrayList<ObservacionModel>();
        list.add(observacionModel);*/
        observacionTable = new ObservacionTable();

        this.cronogramaController.setObservacionTabla(observacionTable);
        table = new JTable(observacionTable);
        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);

        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(new CronogramaFormulario(cronogramaController), BorderLayout.NORTH);
    }

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D)g;
        //Punto donde empezará a imprimir dentro la pagina (100, 50)
        g2d.translate(  pageFormat.getImageableX()+10,
                pageFormat.getImageableY()+10);
        g2d.scale(0.80,0.90); //Reducción de la impresión al 50%
        this.printAll(g);
        return PAGE_EXISTS;
      /*  Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        int fontHeight = g2.getFontMetrics().getHeight();
        int fontDescent = g2.getFontMetrics().getDescent();

        // reserve spaces for page number
        double pageHeight = pageFormat.getImageableHeight() - fontHeight;
        double pageWidth = pageFormat.getImageableWidth();
        double tableWidth = (double)table.getColumnModel().getTotalColumnWidth();
        double scale = 1;
        if (tableWidth >= pageWidth)
        {
            scale = pageWidth / tableWidth;
        }
        double headerHeightOnPage = table.getTableHeader().getHeight()*scale;
        double tableWidthOnPage = tableWidth * scale;
        double oneRowHeight = (table.getRowHeight() + table.getRowMargin())*scale;
        int numRowsOnAPage = (int)((pageHeight-headerHeightOnPage) / oneRowHeight);
        double pageHeightForTable = oneRowHeight * numRowsOnAPage;
        int totalNumPages = (int)Math.ceil(((double)table.getRowCount()) / numRowsOnAPage);
        if (pageIndex >= totalNumPages)
            return NO_SUCH_PAGE;

        g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        g2.drawString("Page: " + (pageIndex +1),(int)pageWidth/2 - 35, (int)(pageHeight + fontHeight - fontDescent));
        g2.translate(0f, headerHeightOnPage);
        g2.translate(0f, -pageIndex*pageHeightForTable);
        if (pageIndex + 1 == totalNumPages)
        {
            int lastRowPrinted = numRowsOnAPage * pageIndex;
            int numRowsLeft = table.getRowCount() - lastRowPrinted;
            g2.setClip(0, (int)(pageHeightForTable * pageIndex),(int)Math.ceil(tableWidthOnPage),(int)Math.ceil(oneRowHeight * numRowsLeft));
        }
        else
        {
            g2.setClip(0, (int)(pageHeightForTable * pageIndex),(int)Math.ceil(tableWidthOnPage),(int)Math.ceil(pageHeightForTable));
        }
        g2.scale(scale, scale);
        table.paint(g2);
        g2.scale(1/scale, 1/scale);
        g2.translate(0f, pageIndex*pageHeightForTable);
        g2.translate(0f, -headerHeightOnPage);
        g2.setClip(0, 0,(int)Math.ceil(tableWidthOnPage),(int)Math.ceil(headerHeightOnPage));
        g2.scale(scale, scale);
        table.getTableHeader().paint(g2);
        return Printable.PAGE_EXISTS;*/
    }

    public ObservacionTable getObservacionTable() {
        return observacionTable;
    }

    public void setObservacionTable(ObservacionTable observacionTable) {
        this.observacionTable = observacionTable;
    }
}
