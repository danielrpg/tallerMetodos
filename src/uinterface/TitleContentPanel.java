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
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("assets/calendar.png"));
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageCalendar.setIcon(new ImageIcon(newImage));


        imageIngeniero = new JLabel();
        ImageIcon imageIconLeft = new ImageIcon(getClass().getClassLoader().getResource("assets/img4.jpg"));
        Image imageLeft = imageIconLeft.getImage();
        Image newImageLeft = imageLeft.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIngeniero.setIcon(new ImageIcon(newImageLeft));


        this.setLayout(new BorderLayout());
        this.add(mainTitle, BorderLayout.CENTER);
        this.add(imageCalendar, BorderLayout.WEST);
        this.add(imageIngeniero, BorderLayout.EAST);
        this.setBackground(Color.WHITE);
    }
}
