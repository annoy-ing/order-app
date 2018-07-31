/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastorderapp;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author doomsayer
 */
public class test {
    public static void main(String[] args) {
        String strUserID = "kuro";
        String strPassword = "qwas";
        String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
        Connection myConnection;
        Statement stmt;
        try {
            
            myConnection = DriverManager.getConnection(dbURL,strUserID,strPassword);
            
            stmt = myConnection.createStatement();
            System.out.println("Connected");
            myConnection.close();
            
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("not connected");
            
        }
    }
}
