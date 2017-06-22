package uinterface;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 * @author dany
 */
public class CronogramaFormulario extends JPanel {

    private JLabel mainTitle;

    private JLabel titleAnalista;
    private JLabel valueAnalista;

    private JLabel titleFecha;
    private JLabel valueFecha;

    private JLabel titlePuesto;
    private JLabel valuePuesto;

    public CronogramaFormulario(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(330, 150));

        mainTitle = new JLabel("CRONOGRAMA DE OBSERVACIONES");
        mainTitle.setBounds(150, 10, 400, 25);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 18));

        titleAnalista = new JLabel("ANALISTA:");
        titleAnalista.setBounds(10, 40, 100, 25);
        valueAnalista = new JLabel("Juan Perez");
        valueAnalista.setBounds(150, 40, 100, 25);

        titleFecha = new JLabel("FECHA:");
        titleFecha.setBounds(10, 75, 100, 25);
        valueFecha = new JLabel(Calendar.getInstance().getTime().toString());
        valueFecha.setBounds(150, 75, 300, 25);

        titlePuesto = new JLabel("PUESTO:");
        titlePuesto.setBounds(10, 105, 100, 25);
        valuePuesto = new JLabel("Torno Automatico");
        valuePuesto.setBounds(150, 105, 300, 25);

        add(mainTitle);

        add(titleAnalista);
        add(valueAnalista);

        add(titleFecha);
        add(valueFecha);

        add(titlePuesto);
        add(valuePuesto);

    }

}
