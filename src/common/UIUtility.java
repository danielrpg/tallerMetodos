package common;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public  Font setFontLabel(){
        return new Font("Arial", Font.BOLD, 11);
    }

    public String getCurrentDate(){
        Calendar calendar = GregorianCalendar.getInstance();
        Date fecha = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(fecha);
    }

}
