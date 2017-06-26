import uinterface.SplashScreen;

import javax.swing.*;

/**
 * @author dfernandez
 */
public class Principal {
    public static void main(String[] arg){
        SplashScreen splash = new SplashScreen(10000);
        // Normally, we'd call splash.showSplash() and get on with the program.
        // But, since this is only a test...
        splash.showSplashAndExit();
       /* SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ObservacionAzarUI();
            }
        });*/
    }
}
