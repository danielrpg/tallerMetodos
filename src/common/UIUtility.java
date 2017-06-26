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
        Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public static ImageIcon getImageSizeIcon(final String urlImage, final int width, final int height){
        ImageIcon imageIcon = new ImageIcon(urlImage);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public  Font setFontLabel(){
        return new Font("Arial", Font.BOLD, 12);
    }

    public String getCurrentDate(){
        Calendar calendar = GregorianCalendar.getInstance();
        Date fecha = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(fecha);
    }

    public Integer getTimeToDate(Date fecha){
        Integer hour = fecha.getHours();
        Integer minute = fecha.getMinutes();
        Integer hora = Integer.parseInt(hour +""+ minute);
        System.out.println(">>> Hora  : "+ hour+":"+minute);
        return hora;
    }

    public String getHoraString(Integer hora){
        String cadenaHora = String.valueOf(hora);
        Integer size = cadenaHora.length();
        char[] horaChart = cadenaHora.toCharArray();
        String nuevaHora = "";
        if(size <= 3){
            nuevaHora = horaChart[size-3]+":"+horaChart[size-2]+""+horaChart[size-1];
        }else if(size <=4){
            nuevaHora = horaChart[size-3]+""+horaChart[size-3]+":"+horaChart[size-2]+""+horaChart[size-1];
        }

        return  nuevaHora;
    }

}
