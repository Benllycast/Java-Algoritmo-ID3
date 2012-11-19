/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unicartagena.ia.logica;

import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;

/**
 *
 * @author Estudiante
 */

public class ConsultorDeReglas {

    private final static String file = "misreglas.xml";
    private Document archivo;

    private void abrirArchivo() throws JDOMException, IOException {

        SAXBuilder in = new SAXBuilder();
        archivo = in.build( file );
    }

    public List<String> getResultados(List<Condicion> condiciones) throws JDOMException, IOException {

        abrirArchivo();

        Element id3 = archivo.getRootElement();

        Element add = id3.getChild("arbol-de-decision");

        return getResult(add, condiciones);

    }

    private List<String> getResult( Element root, List<Condicion> condiciones ) {
        
        Element ler = root.getChild("lista-de-resultados");

        if ( ler != null ) {

            List vals = ler.getChildren("resultado");
            List<String> resultados = new LinkedList<String>();
            for (int i = 0; i < vals.size(); i++) {
                Element result = (Element) vals.get(i);
                resultados.add( result.getText() );
            }

            return resultados;
        }

        Iterator it = root.getChildren("condicion").iterator();
        
        while (it.hasNext()) {

            Element cond = (Element) it.next();

            String atrib = cond.getChildText("atributo");
            String valor = cond.getChildText("valor");

            Condicion con = new Condicion(atrib, valor);

            for (Condicion condicion : condiciones) {

                if ( con.equals(condicion) ) {
                    condiciones.remove(condicion);
                    return getResult(cond, condiciones);
                }
            }
        }

        return null;
    }
}
