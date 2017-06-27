package uinterface;

import common.UIUtility;
import controller.CronogramaController;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
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
    static JSpinner spinner;
    private JTextField textUbo;


    private SpinnerDateModel spinnerDateModelDos;
    private JLabel labelDos1;
    private JLabel labelDos2;
    private JTextField textDos;
    private Date date2;
    static JSpinner spinnerDos;

    private JLabel labelTres1;
    private JLabel labelTres11;
    private JLabel labelTres2;
    static JTextField textTres;
    private JButton btnNumObs;
    private JButton limpiarRangos;


    static JPanel panel = new JPanel();
    static List<JLabel> listOfLabels = new ArrayList<JLabel>();
    static List<JSpinner> listOfJSpinner = new ArrayList<JSpinner>();
    static List<JSpinner> listOfJSpinner2 = new ArrayList<JSpinner>();

    private JLabel labelTitle4;
    static JTextField text4;
    private JLabel labelTitle5;
    static JTextField text5;
    private JLabel labelTitle6;
    static JTextField text6;
    private JButton generarTabla;

    static  CronogramaController cronogramaController;



    public DatosHorarioContentPanel(CronogramaController cronogramaController){
        super();
        this.cronogramaController = cronogramaController;
        this.setLayout(null);
        createFormData();
        this.setBorder(BorderFactory.createTitledBorder("DATOS DEL HORARIO"));
        this.setPreferredSize(new Dimension(330, 100));
    }

    private void createFormData(){
        Date in1 = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in1.toInstant(), ZoneId.systemDefault());
        date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
     //   System.out.println(date);
        spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);

        spinner = new JSpinner(spinnerDateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "HH:mm");
        spinner.setEditor(dateEditor);
        labelUno1 = new JLabel("1.- Hra. de inicio jornada:");
        labelUno1.setFont(UIUtility.getInstance().setFontLabel());
        labelUno1.setBounds(10, 30, 185, 20);
        //textUbo = new JTextField();
        spinner.setBounds(190, 30, 80, 25);
        labelUno2 = new JLabel("am.");
        labelUno2.setFont(UIUtility.getInstance().setFontLabel());
        labelUno2.setBounds(275, 30, 50, 20);

        Date in2 = new Date();
        LocalDateTime ldt1 = LocalDateTime.ofInstant(in2.toInstant(), ZoneId.systemDefault());
        date2 = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        spinnerDateModelDos = new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);

        spinnerDos = new JSpinner(spinnerDateModelDos);
        JSpinner.DateEditor dateEditor1 = new JSpinner.DateEditor(spinnerDos, "HH:mm");
        spinnerDos.setEditor(dateEditor1);
        spinnerDos.setFont(UIUtility.getInstance().setFontLabel());
        labelDos1 = new JLabel("2.- Hra. de fin jornada:");
        labelDos1.setBounds(10, 60, 185, 20);
        labelDos1.setFont(UIUtility.getInstance().setFontLabel());
        //textDos = new JTextField();
        spinnerDos.setBounds(190, 60, 80, 25);
        spinnerDos.setFont(UIUtility.getInstance().setFontLabel());
        labelDos2 = new JLabel("pm.");
        labelDos2.setFont(UIUtility.getInstance().setFontLabel());
        labelDos2.setBounds(275, 60, 50, 20);

        labelTres1 = new JLabel("3.- Numero de periodos en que no se puede realizar ");
        labelTres1.setBounds(10, 90, 300, 20);
        labelTres1.setFont(UIUtility.getInstance().setFontLabel());
        labelTres11 = new JLabel("observaciones : ");
        labelTres11.setBounds(30, 120, 100, 20);
        labelTres11.setFont(UIUtility.getInstance().setFontLabel());
        textTres = new JTextField("2");
        textTres.setBounds(130, 120, 80, 25);
        textTres.setFont(UIUtility.getInstance().setFontLabel());
        btnNumObs = new JButton("Generar Rango");
        btnNumObs.setBounds(10, 150, 190, 35);
        btnNumObs.setFont(UIUtility.getInstance().setFontLabel());
        ImageIcon imageClock2 = new ImageIcon(getClass().getClassLoader().getResource("assets/clock2.png"));
        Image imageClock2Left = imageClock2.getImage();
        Image newImageLeft = imageClock2Left.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        btnNumObs.setIcon(new ImageIcon(newImageLeft));
        btnNumObs.addActionListener(new ObservationListener());
       // establecerDefaul();

        limpiarRangos = new JButton();
        limpiarRangos.setBounds(210, 150, 50, 35);
        limpiarRangos.setFont(UIUtility.getInstance().setFontLabel());
        ImageIcon refreshImage = new ImageIcon(getClass().getClassLoader().getResource("assets/refresh.png"));
        Image imageRefreshLeft = refreshImage.getImage();
        Image refreshImg = imageRefreshLeft.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        limpiarRangos.setIcon(new ImageIcon(refreshImg));
        limpiarRangos.addActionListener(new RefreshListener());


        panel.setLayout(null);
      //  panel.setBorder(LineBorder.createBlackLineBorder());
        panel.setPreferredSize(new Dimension(305, 180));
        JScrollPane jScrollPane = new JScrollPane(panel);
      //  jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setBounds(3, 190, 310, 180);

        labelTitle4 = new JLabel("4.- Numero de observaciones requeridas por dia:");
        labelTitle4.setBounds(10, 370, 300, 20);
        labelTitle4.setFont(UIUtility.getInstance().setFontLabel());
        text4 = new JTextField("0");
        text4.setBounds(10, 400, 100, 25);
        text4.setFont(UIUtility.getInstance().setFontLabel());

        labelTitle5 = new JLabel("5.- Nombre del Analista: ");
        labelTitle5.setBounds(10, 430, 150, 25);
        labelTitle5.setFont(UIUtility.getInstance().setFontLabel());
        text5 = new JTextField();
        text5.setBounds(150, 430, 150, 25);
        text5.setFont(UIUtility.getInstance().setFontLabel());

        labelTitle6 = new JLabel("6.- Puesto o etapa del Analista: ");
        labelTitle6.setBounds(10, 460, 180, 25);
        labelTitle6.setFont(UIUtility.getInstance().setFontLabel());
        text6 = new JTextField();
        text6.setBounds(10, 485, 250, 23);
        text6.setFont(UIUtility.getInstance().setFontLabel());

        generarTabla = new JButton("Generar Cronograma");
        generarTabla.setBounds(10, 510, 190, 35);
        generarTabla.setFont(UIUtility.getInstance().setFontLabel());
        ImageIcon clipBoard = new ImageIcon(getClass().getClassLoader().getResource("assets/clipboard.png"));
        Image clipBoardLeft = clipBoard.getImage();
        Image newClipBoardLeft = clipBoardLeft.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        generarTabla.setIcon(new ImageIcon(newClipBoardLeft));
        generarTabla.addActionListener(new CronogramaListener());

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
        this.add(limpiarRangos);

        this.add(labelTitle4);
        this.add(text4);

        this.add(labelTitle5);
        this.add(text5);

        this.add(labelTitle6);
        this.add(text6);

        this.add(generarTabla);
    }




    static class RefreshListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.removeAll();
            panel.updateUI();
        }
    }

    static class CronogramaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Date datoSpinnerInicio = (Date) spinner.getValue();
            System.out.println(datoSpinnerInicio);
            Date datoSpinnerFin  = (Date) spinnerDos.getValue();
            System.out.println(datoSpinnerFin);
            Integer numeroObservaciones = 0;
            try {
                numeroObservaciones = Integer.parseInt(text4.getText());
            }catch (NumberFormatException numEx){
                JOptionPane.showMessageDialog(null, "Ingrese un valor entero valido para las observaciones",
                        "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }

            Integer nroNoObservaciones = 0;
            try{
                nroNoObservaciones = Integer.parseInt(textTres.getText());
            }catch (NumberFormatException nuEx){
                JOptionPane.showMessageDialog(null, "Ingrese un valor entero para las no observaciones",
                        "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }

            if(nroNoObservaciones != 0){
                cronogramaController.generarCronograma(datoSpinnerInicio, datoSpinnerFin, listOfJSpinner, listOfJSpinner2, numeroObservaciones);
            }else{
                cronogramaController.generarCronograma(datoSpinnerInicio, datoSpinnerFin, numeroObservaciones);
            }
            String nombreAnalista = text5.getText();
            String nombreEstacion = text6.getText();
            cronogramaController.setDatosCabecera(nombreAnalista, nombreEstacion);

        }
    }


    static class ObservationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           // establecerDefaul();
            panel.removeAll();
            Integer indexer = 0;
            try {
                indexer = Integer.parseInt(textTres.getText());
            }catch (NumberFormatException nunEx){
                JOptionPane.showMessageDialog(null, "Ingrese un valor entero valido",
                        "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }

            int position = 0;

            // Add labels and text fields
            for(int i = 0; i < indexer; i++)
            {
                Date date = new Date();
                SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);

                JLabel label = new JLabel( (i+1) + ". Hora inicio:");
                label.setBounds(3, 5+position, 80, 25);
                label.setFont(UIUtility.getInstance().setFontLabel());
                listOfLabels.add(label);
                panel.add(label);

                JSpinner spinner = new JSpinner(spinnerDateModel);
                JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "HH:mm");
                spinner.setEditor(dateEditor);
                spinner.setBounds(80, 5+position, 70, 25);
                spinner.setFont(UIUtility.getInstance().setFontLabel());
                listOfJSpinner.add(spinner);
                panel.add(spinner);

                JLabel label2 = new JLabel("Hora fin:");
                label2.setBounds(155, 5+position, 80, 25);
                label2.setFont(UIUtility.getInstance().setFontLabel());
                listOfLabels.add(label2);
                panel.add(label2);

                Date date2 = new Date();
                SpinnerDateModel spinnerDateModel2 = new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
                JSpinner spinner2 = new JSpinner(spinnerDateModel2);
                JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(spinner2, "HH:mm");
                spinner2.setEditor(dateEditor2);
                spinner2.setBounds(205, 5+position, 70, 25);
                spinner2.setFont(UIUtility.getInstance().setFontLabel());
                listOfJSpinner2.add(spinner2);
                panel.add(spinner2);

                position = position + 28;
                panel.updateUI();

            }

        }
    }
}
