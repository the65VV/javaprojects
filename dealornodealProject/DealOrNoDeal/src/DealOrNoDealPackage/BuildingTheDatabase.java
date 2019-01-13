package DealOrNoDealPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */

public class BuildingTheDatabase {
   public Connection conn;
   public String url = "jdbc:derby://localhost:1527/BuildingTheDatabaseDB;create=true";   
   public String username = "Server";
   public String password = "Password";
   public String newTableName = "WINNERS";

    public void establishConnection(){
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(url + "   connected....");
        } 
        catch (SQLException ex) {
            Logger.getLogger(BuildingTheDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createTable(){
        try {
            Statement statement = conn.createStatement();
            
            String sqlCreate = "create table " + newTableName + " (FirstName varchar(20), LastName varchar(20)," + "Score int)";
            statement.executeUpdate(sqlCreate);

        } catch (SQLException ex) {
            Logger.getLogger(BuildingTheDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertTable(String userName, int score){
        try {
            Statement statement = conn.createStatement();
            
            String sqlInsert = "insert into " + newTableName + " values(" + userName + "," + score + "),";
            statement.executeUpdate(sqlInsert);

        } catch (SQLException ex) {
            Logger.getLogger(BuildingTheDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnections(){
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BuildingTheDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
