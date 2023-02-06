package finRac.logics;

import java.sql.ResultSet;
import java.util.*;

public class Validators {
	public static Hashtable<String, String> currentUser = null;
	public static boolean validateLogIn(String inputUsername, String inputPassword) {
		boolean flag = false;
		SQLDatabase sql = new SQLDatabase("finansijsko_racunovodstvo", "root", "Kokorini34492");
		ArrayList<Hashtable<String, String>> users = new ArrayList<Hashtable<String, String>>();
		try {
			sql.connect();
			ResultSet rs = sql.readDataBase("SELECT * FROM korisnik");
			
			while(rs.next()) {
				Hashtable<String, String> temp = new Hashtable<String, String>();
				String id = rs.getString("id");
				String username = rs.getString("username");
				byte[] decodedBytes = Base64.getDecoder().decode(rs.getString("password"));
				String password = new String(decodedBytes);
				temp.put("id", id);
				temp.put("username", username);
				temp.put("password", password);
				users.add(temp);
				
			}
			sql.close();
			
			for(int i = 0;i < users.size();i++) {
				if(inputUsername.equals(users.get(i).get("username")) && inputPassword.equals(users.get(i).get("password"))) {
					flag = true;
					currentUser = users.get(i);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
