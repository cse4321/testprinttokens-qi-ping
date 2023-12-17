import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PureNameCheck {	
	public static void main(String[] args)  {
		PureNameCheck namecheck= new PureNameCheck();		
		String name="";
		
		if (args.length == 1) {
			name = args[0]; // get name from args			
		}else {
			// get name from system.in
			name=namecheck.getNameFromSystemIn();
		}		
		namecheck.checkPureName(name);
		
		System.exit(0);
	}

	/**
	 * print whether a name is a pure name or not
	 * @param name
	 */
	public void checkPureName(String name) {
		if (name.matches(".*\\d.*")) {
			// if contains digits
			System.out.println("not pure name");
		}
		else {
			System.out.println("pure name");
		}
	}
	
	/**
	 * get name from system.in
	 * @return 
	 */
	public String getNameFromSystemIn() {		
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			return br.readLine();
		}
		catch(IOException e) {
			return "";
		}		
	}
	
}
