/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unicartagena.ia.logica;

import java.util.*;
import org.jdom.*;
import org.jdom.input.*;

/**
 *
 * @author Estudiante
 */
public class CargarAtributos {

    public CargarAtributos() {
    }

    public String[] getAtributos() {

        SAXBuilder in = new SAXBuilder();

        try {

            Document doc = in.build("misreglas.xml");
            Element raiz = doc.getRootElement();

            Element listaAtributos = raiz.getChild("lista-de-atributos");

            List list = listaAtributos.getChildren();

            String[] atributos = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                Element atrib = (Element) list.get(i);
                atributos[i] = atrib.getChildText("nombre");
            }

            doc = null;
            raiz = listaAtributos = null;
            list = null;

            return atributos;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            in = null;
        }

    }

    public String[] getValores(String atrib) {

        System.out.println("cargandpo...." + atrib);

        SAXBuilder in = new SAXBuilder();

        try {

            Document doc = in.build("misreglas.xml");
            Element raiz = doc.getRootElement();

            Element listaAtributos = raiz.getChild("lista-de-atributos");

            List list = listaAtributos.getChildren();

            String[] valores = null;

            for (int i = 0; i < list.size(); i++) {
                Element atr = (Element) list.get(i);
                String nombre = atr.getChildText("nombre");

                if ( ! nombre.equals(atrib) ) continue;

                atr = atr.getChild("lista-de-valores");
                List vals = atr.getChildren();

                valores = new String[vals.size()];

                for (int j = 0; j < vals.size(); j++) {
                    Element valor = (Element) vals.get(j);
                    valores[j] = valor.getText();

                    System.out.println("value......." + valores[j]);
                }

                break;

            }

            doc = null;
            raiz = listaAtributos = null;
            list = null;

            System.out.println("retirn..." + valores.length);

            return valores;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            in = null;
        }

    }
}
