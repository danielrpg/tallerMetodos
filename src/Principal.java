import uinterface.ObservacionAzarUI;

import javax.swing.*;

/**
 * @author dfernandez
 */
public class Principal {
    public static void main(String[] arg){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ObservacionAzarUI();
            }
        });
    }
}
