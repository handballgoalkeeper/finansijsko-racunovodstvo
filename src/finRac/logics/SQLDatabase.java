package finRac.logics;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabase {
	private Connection connection = null;
    private Statement statement = null;
//    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
	private String databaseName;
	private String user;
	private String password;
    
    public SQLDatabase(String databaseName, String user, String password) {
    	super();
    	this.databaseName = databaseName;
    	this.user = user;
    	this.password = password;
    }
    
	public ResultSet readDataBase(String sql) throws Exception {
        try {
            this.statement = this.connection.createStatement();
        	
            this.resultSet = statement.executeQuery(sql);
            return this.resultSet;
      
        }catch (Exception e) {
        	throw e;
        }
	}
    
	public void connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost/" + this.databaseName + 
				"?user=" + this.user + 
				"&password=" + this.password);
	}
	
	
//    private void writeResultSet(ResultSet resultSet) throws SQLException {
//        // ResultSet is initially before the first data set
//        while (resultSet.next()) {
//            // It is possible to get the columns via name
//            // also possible to get the columns via the column number
//            // which starts at 1
//            // e.g. resultSet.getSTring(2);
////            String id = resultSet.getString("id");
////            String username = resultSet.getString("username");
////            String password = resultSet.getString("password");
//// 
////            System.out.println("Id: " + id);
////            System.out.println("Username: " + username);
////            System.out.println("Password: " + password);
//        	System.out.println(resultSet.getString("id"));
//        }
//    }
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
    }
}
