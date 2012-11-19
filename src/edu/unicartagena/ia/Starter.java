/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unicartagena.ia;

import edu.unicartagena.ia.gui.SplashWindow;
import edu.unicartagena.ia.gui.VistaCapturarDataSet;
import edu.unicartagena.ia.gui.VistaConsulta;
import java.awt.SplashScreen;
import java.net.URL;
import javax.swing.UIManager;

/**
 *
 * @author Benlly
 */
public class Starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        } catch (Exception ex) {
        }

        VistaCapturarDataSet vista = new VistaCapturarDataSet();

        //VistaConsulta vista = new VistaConsulta();
        //vista.setVisible(true);

        URL url = Starter.class.getResource( "/splash.JPG" );

        SplashWindow splashWindow = new SplashWindow(url, vista, 3000);

    }

}
