package uinterface;

import common.UIUtility;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

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
    private JSpinner spinnerDos;

    private JLabel labelTres1;
    private JLabel labelTres11;
    private JLabel labelTres2;
    static JTextField textTres;
    private JButton btnNumObs;


    static JPanel panel = new JPanel();
    static List<JLabel> listOfLabels = new ArrayList<JLabel>();
    static List<JSpinner> listOfTextFields = new ArrayList<JSpinner>();
    static List<JSpinner> listOfJSpinner = new ArrayList<JSpinner>();

    private JLabel labelTitle4;
    static JTextField text4;
    private JLabel labelTitle5;
    static JTextField text5;
    private JLabel labelTitle6;
    static JTextField texts;
    private JButton generarTabla;

    public DatosHorarioContentPanel(){
        super();
        this.setLayout(null);


        createFormData();
        this.setBorder(BorderFactory.createTitledBorder("DATOS DEL HORARIO"));
       // this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(300, 100));
    }

    private void createFormData(){
        date = new Date();
        spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);

        spinner = new JSpinner(spinnerDateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
        spinner.setEditor(dateEditor);
        labelUno1 = new JLabel("1.- Hora de inicio de la jornada :");
        labelUno1.setBounds(10, 30, 185, 20);
        //textUbo = new JTextField();
        spinner.setBounds(190, 30, 80, 25);
        labelUno2 = new JLabel("am.");
        labelUno2.setBounds(275, 30, 50, 20);


        spinnerDos = new JSpinner(spinnerDateModel);
        JSpinner.DateEditor dateEditor1 = new JSpinner.DateEditor(spinnerDos, "HH:mm:ss");
        spinnerDos.setEditor(dateEditor1);
        labelDos1 = new JLabel("2.- Hora de fin de la jornada :");
        labelDos1.setBounds(10, 60, 185, 20);
        //textDos = new JTextField();
        spinnerDos.setBounds(190, 60, 80, 25);
        labelDos2 = new JLabel("pm.");
        labelDos2.setBounds(275, 60, 50, 20);

        labelTres1 = new JLabel("3.- Numero de periodos en que se puede realizar ");
        labelTres1.setBounds(10, 90, 300, 20);
        labelTres11 = new JLabel("observaciones : ");
        labelTres11.setBounds(30, 120, 100, 20);
        textTres = new JTextField();
        textTres.setBounds(130, 120, 80, 25);
        btnNumObs = new JButton("Calcular Observaciones");
        btnNumObs.setBounds(40, 150, 220, 35);
        btnNumObs.setIcon(UIUtility.getImageSizeIcon("./src/assets/clock2.png", 30, 30));
        btnNumObs.addActionListener(new ObservationListener());


        panel.setLayout(null);
      //  panel.setBorder(LineBorder.createBlackLineBorder());
        panel.setPreferredSize(new Dimension(295, 200));
        JScrollPane jScrollPane = new JScrollPane(panel);
      //  jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setBounds(3, 190, 295, 200);

        labelTitle4 = new JLabel("4.- Num");
        labelTitle4.setBounds(10, 400, 185, 20);


        this.add(labelUno1);
        this.add(spinner);
        this.add(labelUno2);

        this.add(labelDos1);
        this.add(spinnerDos);
        this.add(labelDos2);

        this.add(labelTres1);
        this.add(labelTres11);
        this.add(textTres);
        this.add(btnNumObs);
        this.add(jScrollPane);

        this.add(labelTitle4);
    }

    static class ObservationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.removeAll();
            Integer indexer = Integer.parseInt(textTres.getText());
            System.out.println("Las observaciones :"+ indexer);

            int position = 0;
            // Add labels and text fields
            for(int i = 0; i < indexer; i++)
            {
                Date date = new Date();
                SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);

                JLabel label = new JLabel( (i+1) + ". Hora inicio:");
                label.setBounds(3, 0+position, 80, 25);
                listOfLabels.add(label);
                panel.add(label);

                JSpinner spinner = new JSpinner(spinnerDateModel);
                JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
                spinner.setEditor(dateEditor);
                spinner.setBounds(80, 0+position, 70, 25);
                listOfTextFields.add(spinner);
                panel.add(spinner);

                JLabel label2 = new JLabel("Hora fin:");
                label2.setBounds(155, 0+position, 80, 25);
                listOfLabels.add(label2);
                panel.add(label2);

                JSpinner spinner2 = new JSpinner(spinnerDateModel);
                JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(spinner, "HH:mm:ss");
                spinner2.setEditor(dateEditor2);
                spinner2.setBounds(200, 0+position, 70, 25);
                listOfJSpinner.add(spinner2);
                panel.add(spinner2);

                position = position + 28;
                panel.updateUI();

            }

        }
    }
}
