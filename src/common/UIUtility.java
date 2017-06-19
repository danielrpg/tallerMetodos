package common;

import javax.swing.*;
import java.awt.*;

/**
 * @author dany
 */
public class UIUtility {
    private static  UIUtility uiUtility = null;

    public UIUtility(){}

    public static UIUtility getInstance(){
        if(uiUtility == null){
            uiUtility = new UIUtility();
        }
        return uiUtility;
    }

    public static int getRamdonNum(int ini, int limite){
        return (int) (Math.random()*limite + 1);
    }

    public  static ImageIcon getImageIcon(final String urlImage){
        ImageIcon imageIcon = new ImageIcon(urlImage);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public static ImageIcon getImageSizeIcon(final String urlImage, final int width, final int height){
        ImageIcon imageIcon = new ImageIcon(urlImage);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

}
