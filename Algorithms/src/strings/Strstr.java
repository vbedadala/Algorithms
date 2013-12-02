package strings;

public class Strstr {

	
	public static String strstr(String input, String key) {
		int i=0;	
		int j=0;
		while ( i <input.length()) {
			//check if the first occurance of target matches
			if(input.charAt(i) == key.charAt(j)) {
				while(j<key.length() && input.charAt(i)==key.charAt(j)){
					i++;
					j++;		
				}
				if(j==key.length())
				return input.substring(i);
			}
			j=0;
			i++;
		}	
		
		return null;
	}
	
	public static void main(String[] args) {

		System.out.println("StrStr : " + strstr("My House is Green", "is"));
	}
}
