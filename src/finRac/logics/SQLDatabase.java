package finRac.logics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabase {
	private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
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
    
    public Connection connect() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		this.connection = DriverManager.getConnection("jdbc:mysql://localhost/" + this.databaseName + 
					"?user=" + this.user + 
					"&password=" + this.password);
    		
            return this.connection;
    	} catch(Exception e) {
    		return null;
    	} finally {
    		close();
    	}
    }
    
	public void readDataBase(Connection connection, String sql) throws Exception {
        try {
            statement = this.connection.createStatement();
        	
            resultSet = statement.executeQuery("select * from finansijsko_racunovodstvo.korisnik");
            this.writeResultSet(resultSet);
            
            
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT korisnik_id, pravo_pristupa_id FROM finansijsko_racunovodstvo.dodeljeno_pravo");
            while(resultSet.next()) {
            	System.out.println("korisnik_id: " + resultSet.getString("korisnik_id"));
            	System.out.println("pravo_pristupa_id: " + resultSet.getShort("pravo_pristupa_id"));
            }
        }catch (Exception e) {
        	throw e;
        } finally {
        	close();
        }
   }
    
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
 
            System.out.println("Id: " + id);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }
    private void close() {
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
