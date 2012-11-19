/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unicartagena.ia.managers;

import edu.unicartagena.ia.logica.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import org.jdom.*;

/**
 *
 * @author Luis Miguel
 */
public class ManagerConsulta {

    public void consultarResultados(List<Condicion> condiciones) {

        try {

            ConsultorDeReglas cdr = new ConsultorDeReglas();
            List<String> result = cdr.getResultados(condiciones);

            if ( result == null ) {
                JOptionPane.showMessageDialog(null, "Resultado para la consulta: DESCONOCIDO",
                        "ID3", JOptionPane.ERROR_MESSAGE);
                return;
            }

            System.out.println("resultados: " + result.size());
            for (String value : result) {
                System.out.println( value );
            }

        } catch (JDOMException ex) {

            ex.printStackTrace();

        } catch (IOException ex) {

            ex.printStackTrace();

        }


    }
}
