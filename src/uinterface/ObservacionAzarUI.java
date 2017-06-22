package uinterface;

import common.Constants;
import model.ObservacionModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dany
 */
public class ObservacionAzarUI extends JFrame{

    private MainMenuBar mainMenuBar;


    public ObservacionAzarUI(){
        super();
        setLocation();
    }

    private void setLocation(){
        this.setTitle(Constants.MAIN_TITLE);
        this.setLayout(new BorderLayout());
        this.setLocation(0, 0);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setPreferredSize(new Dimension(1024, 750));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuBar = new MainMenuBar();
        this.setJMenuBar(mainMenuBar);
        createComponents();
        this.setVisible(true);
    }

    private void createComponents(){
        this.setBackground(Color.WHITE);
        this.add(new TitleContentPanel(), BorderLayout.NORTH);
        this.add(new DatosHorarioContentPanel(), BorderLayout.WEST);
        this.add(new InformationCronograma(), BorderLayout.CENTER);
        this.add(new ImprimirPanel(), BorderLayout.SOUTH);
        //this.add(new DatosHorarioContentPanel(), BorderLayout.EAST);
    }
}
