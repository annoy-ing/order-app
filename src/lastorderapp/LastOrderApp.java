/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastorderapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author doomsayer
 */
public class LastOrderApp {

    /**
     * @param args the command line arguments
     */
    
    static String strUserID = "kuro";
    static String strPassword = "qwas";
    static String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
    static Connection myConnection;
    static Statement stmt;
    
    static {
        try {
            myConnection = DriverManager.getConnection(dbURL,strUserID,strPassword);
            stmt = myConnection.createStatement();
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("not connected");
        }

    }
    
    public static int getLastOrderID() throws SQLException {
        int lastOrderID = 0;

        try{
            ResultSet rs = stmt.executeQuery("select * from ORDERS");
            while (rs.next()){
                if (lastOrderID < rs.getInt(1)) lastOrderID = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastOrderID;
    }

    public static int getLastWorkerID() throws SQLException {
        int lastWorkerID = 0;

        try{
            ResultSet rs = stmt.executeQuery("select * from WORKERS");
            while (rs.next()){
                if (lastWorkerID < rs.getInt(1)) lastWorkerID = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastWorkerID;
    }

    public static int getLastToolID() throws SQLException {
        int lastToolID = 0;

        try{
            ResultSet rs = stmt.executeQuery("select * from TOOLS");
            while (rs.next()){
                if (lastToolID < rs.getInt(1)) lastToolID = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastToolID;
    }

    public static int getLastDepartmentID() throws SQLException {
        int lastDepartmentID = 0;

        try{
            ResultSet rs = stmt.executeQuery("select * from DEPARTMENTS");
            while (rs.next()){
                if (lastDepartmentID < rs.getInt(1)) lastDepartmentID = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastDepartmentID;
    }

    public static int getLastRoomID() throws SQLException {
        int lastRoomID = 0;


        try{
            ResultSet rs = stmt.executeQuery("select * from ROOMS");
            while (rs.next()){
                if (lastRoomID < rs.getInt(1)) lastRoomID = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastRoomID;
    }
    
    public static void addWorkerToDB(String workerName, String workerPosition, int departmentID) throws SQLException {

        String sqlCommand = "INSERT INTO WORKERS (WORKER_ID, WORKER_NAME, WORKER_POSITION, WORKER_DEPARTMENT) " +
                "VALUES (";

        int newWorkerID = getLastWorkerID() + 1;

        sqlCommand += "\'" + newWorkerID + "\', ";
        sqlCommand += "\'" + workerName + "\', ";
        sqlCommand += "\'" + workerPosition + "\', ";
        sqlCommand += "\'" + departmentID + "\')";
        System.out.println(sqlCommand);

        ResultSet rs=stmt.executeQuery(sqlCommand);

        System.out.println("\nnew worker added\n");
    }

    public static void addDepartmentToDB(String departmentName) throws SQLException {

        String sqlCommand = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME) " +
                "VALUES (";

        int newDepartmentID = getLastDepartmentID() + 1;

        sqlCommand += "\'" + newDepartmentID + "\', ";
        sqlCommand += "\'" + departmentName + "\')";
        System.out.println("\n" + sqlCommand);

        ResultSet rs=stmt.executeQuery(sqlCommand);

        System.out.println("\nnew department added\n");
    }
    
    public static void addToolToDB(String toolName) throws SQLException {

        String sqlCommand = "INSERT INTO TOOLS (TOOL_ID, TOOL_NAME) " +
                "VALUES (";

        int newToolID = getLastToolID() + 1;

        sqlCommand += "\'" + newToolID + "\', ";
        sqlCommand += "\'" + toolName + "\')";
        System.out.println("\n" + sqlCommand);

        ResultSet rs=stmt.executeQuery(sqlCommand);

        System.out.println("\nnew tool added\n");
    }
    
    public static void addRoomToDB(String roomName, String roomAdress) throws SQLException {

        String sqlCommand = "INSERT INTO Rooms (Room_ID, Room_NAME, Room_Adress) " +
                "VALUES (";

        int newRoomID = getLastRoomID() + 1;

        sqlCommand += "\'" + newRoomID + "\', ";
        sqlCommand += "\'" + roomName + "\',";
        sqlCommand += "\'" + roomAdress + "\')";
        System.out.println("\n" + sqlCommand);

        ResultSet rs=stmt.executeQuery(sqlCommand);

        System.out.println("\nnew room added\n");
    }
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    
    public static void createOrder(int depID, String workType, int jobIss, int jobAcc, int roomID, Calendar startDate, Calendar endDate) throws SQLException {

        int newOrderID = getLastOrderID() + 1;

        String sqlCommand = "INSERT INTO ORDERS (ID, DEPARTMENT_ID, WORK_TYPE, ISSUED_JOB_ID, ACCEPTED_JOB_ID, ROOM_ID, START_DATE, END_DATE) " +
                "VALUES (";


        sqlCommand += "\'" + newOrderID + "\', ";
        sqlCommand += "\'" + depID + "\', ";
        sqlCommand += "\'" + workType + "\',";
        sqlCommand += "\'" + jobIss + "\', ";
        sqlCommand += "\'" + jobAcc + "\', ";
        sqlCommand += "\'" + roomID + "\', ";
        sqlCommand += "\'" + sdf.format(startDate.getTime()) + "\', ";
        sqlCommand += "\'" + sdf.format(endDate.getTime()) + "\')";
        System.out.println("\n" + sqlCommand);

        ResultSet rs=stmt.executeQuery(sqlCommand);

        System.out.println("\nnew order added\n");
    }
    
    public static void addWorkersToOrders(int orderID, int ... workersIDs) throws SQLException {

        String sqlCommand = "";

        for (int w : workersIDs) {
            sqlCommand = "INSERT INTO ORDER_WORKERS(ORDER_ID, WORKER_ID) VALUES (";
            sqlCommand += "\'" + orderID + "\', ";
            sqlCommand += "\'" + w + "\')";

            System.out.println(sqlCommand);
            ResultSet rs=stmt.executeQuery(sqlCommand);
        }

        System.out.println("\nnew workers to order added\n");
    }
    
    public static void addToolsToOrders(int orderID, int ... toolsIDs) throws SQLException {

        String sqlCommand = "";

        for (int t : toolsIDs) {
            sqlCommand = "INSERT INTO TOOLS_ORDER(ORDER_ID, TOOL_ID) VALUES (";
            sqlCommand += "\'" + orderID + "\', ";
            sqlCommand += "\'" + t + "\')";
            System.out.println(sqlCommand);
            ResultSet rs=stmt.executeQuery(sqlCommand);
        }

        System.out.println("\nnew tools to order added\n");
    }
    
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        
    }
    
}
