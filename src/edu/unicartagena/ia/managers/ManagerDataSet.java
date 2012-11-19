/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.unicartagena.ia.managers;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Benlly
 */

public class ManagerDataSet {

    
    public ResultSet getResultSet(String sql) {

        ResultSet data = null;
        Connection con = null;
        Statement st = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/ide3";
            con = DriverManager.getConnection(url, "root", "");

            st = con.createStatement();

            data = st.executeQuery( sql );
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar el dataset.");
        } finally {
        }

        return data;
    }
}
