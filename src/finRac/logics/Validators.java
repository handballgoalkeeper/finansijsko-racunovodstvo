package finRac.logics;

public class Validators {
	public static boolean validateLogIn(String username, String password) {
		if(username.equals("handballgoalkeeper") && password.equals("Kokorini34492")) {
			return true;
		}
		return false;
	}
}
