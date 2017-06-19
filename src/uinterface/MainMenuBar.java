package uinterface;

import common.Constants;

import javax.swing.*;

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
        menuArchivo.add(exitItem);
        menuHelp = new JMenu(Constants.MENU_HELP);
        helpItem = new JMenuItem(Constants.ITEM_HELP);
        menuHelp.add(helpItem);
        this.add(menuArchivo);
        this.add(menuHelp);
    }

}
