package uinterface;

import common.UIUtility;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author dany
 */
public class DatosHorarioContentPanel extends JPanel {

    private JLabel labelUno1;
    private JLabel labelUno2;
    private Date date;
    private SpinnerDateModel spinnerDateModel;
    private JSpinner spinner;
    private JTextField textUbo;

    private JLabel labelDos1;
    private JLabel labelDos2;
    private JTextField textDos;

    private JLabel labelTres1;
    private JLabel labelTres2;
    private JTextField textTres;
    private JButton btnNumObs;

    public DatosHorarioContentPanel(){
        super();
        this.setLayout(null);
        date = new Date();
        spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        spinner = new JSpinner(spinnerDateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
        spinner.setEditor(dateEditor);

        labelUno1 = new JLabel("1.- Hora de inicio de la jornada :");
        labelUno1.setBounds(10, 30, 185, 20);
        //textUbo = new JTextField();
        spinner.setBounds(190, 30, 60, 20);
        labelUno2 = new JLabel("am.");
        labelUno2.setBounds(250, 30, 50, 20);

      //  this.setLayout(new FlowLayout());
        createFormData();
        this.setBorder(BorderFactory.createTitledBorder("Datos del sistemas"));
       // this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(300, 100));
    }

    private void createFormData(){

        labelDos1 = new JLabel("2.- Hora de fin de la jornada :");
        labelDos1.setBounds(10, 50, 185, 20);
        textDos = new JTextField();
        textDos.setBounds(190, 50, 60, 20);
        labelDos2 = new JLabel("pm.");
        labelDos2.setBounds(250, 50, 50, 20);

        labelTres1 = new JLabel("3.- Numero de periodos en que se puede realizar observaciones :");
        textTres = new JTextField();
        btnNumObs = new JButton("Calcular Periodo");
        btnNumObs.setIcon(UIUtility.getImageSizeIcon("./src/assets/clock2.png", 30, 30));

        this.add(labelUno1);
        this.add(spinner);
        this.add(labelUno2);

        this.add(labelDos1);
        this.add(textDos);
        this.add(labelDos2);

        this.add(labelTres1);
        this.add(textTres);
        this.add(btnNumObs);
    }
}
