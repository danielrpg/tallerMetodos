package uinterface;

import common.Constants;
import common.UIUtility;

import javax.swing.*;
import java.awt.*;

/**
 * @author dany
 */
public class TitleContentPanel extends JPanel {

    private JLabel imageCalendar;
    private JLabel mainTitle;
    private JLabel imageIngeniero;

    public TitleContentPanel(){
        super();
        mainTitle = new JLabel(Constants.MAIN_JPANEL);
        mainTitle.setFont(new Font("Courier New", Font.ITALIC, 28));

        imageCalendar = new JLabel();
        imageCalendar.setIcon(UIUtility.getImageIcon("./src/assets/calenda1.png"));


        imageIngeniero = new JLabel();
        imageIngeniero.setIcon(UIUtility.getImageIcon("./src/assets/img4.jpg"));


        this.setLayout(new BorderLayout());
        this.add(mainTitle, BorderLayout.CENTER);
        this.add(imageCalendar, BorderLayout.WEST);
        this.add(imageIngeniero, BorderLayout.EAST);
        this.setBackground(Color.WHITE);
    }
}
