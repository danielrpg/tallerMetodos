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
        mainTitle.setFont(new Font("Arial", Font.BOLD, 28));

        imageCalendar = new JLabel();
        imageCalendar.setIcon(UIUtility.getInstance().getImageSizeIcon("./src/assets/calendar.png", 100, 100));


        imageIngeniero = new JLabel();
        imageIngeniero.setIcon(UIUtility.getImageIcon("./src/assets/img4.jpg"));


        this.setLayout(new BorderLayout());
        this.add(mainTitle, BorderLayout.CENTER);
        this.add(imageCalendar, BorderLayout.WEST);
        this.add(imageIngeniero, BorderLayout.EAST);
        this.setBackground(Color.WHITE);
    }
}
