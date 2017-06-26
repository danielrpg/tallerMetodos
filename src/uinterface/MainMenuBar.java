package uinterface;

import common.Constants;
import common.UIUtility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author dany
 */
public class MainMenuBar extends JMenuBar{
    private JMenu menuArchivo, menuHelp;
    private JMenuItem exitItem, helpItem;

    public MainMenuBar(){
        super();
        createMenus();
    }

    private void createMenus(){
        menuArchivo = new JMenu(Constants.MENU_FILE);
        exitItem = new JMenuItem(Constants.ITEM_EXIT);
        exitItem.addActionListener(new ExitListener());
        exitItem.setIcon(UIUtility.getInstance().getImageSizeIcon("./src/assets/cancel.png", 20, 20));
        menuArchivo.add(exitItem);
        menuHelp = new JMenu(Constants.MENU_HELP);
        helpItem = new JMenuItem(Constants.ITEM_HELP);
        helpItem.addActionListener(new HelpListener());
        menuHelp.add(helpItem);
        this.add(menuArchivo);
        this.add(menuHelp);
    }
    static class HelpListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    static class ExitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
