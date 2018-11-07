import java.util.*;

/*
	Laboration 4
	Grupp 20
	Josefin Ulfenborg
	Therese Sturesson
	Editor: Smultron
*/

public class Verktyg {
	
	public static void slumpOrdning(Object[] arr) {
		//Förbereder en ny array
		Object[] temp = new Object[arr.length];
		Random generator = new Random();
		
		/*Vi slumpar ut en random plats och fyller den med arr:s element. Om 
		platsen redan är upptagen (null), ska den slumpa fram en ny plats*/
		for(int i = 0; i < arr.length; i++) {
			int r = generator.nextInt(arr.length);
			while(temp[r] != null) {
				r = generator.nextInt(arr.length);
			}
			temp[r] = arr[i];
		}
		
		//kopierar över temp till arr 
		for (int j = 0; j < temp.length; j++) {
			arr[j] = temp[j]; 
		}
	}
}

