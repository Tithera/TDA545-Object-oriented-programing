 /*
	Laboration 2 Del 1
	Grupp 20
	Josefin Ulfenborg
	Therese Sturesson
	Editor: Smultron
*/

public class Rse{
	public static boolean allRowSumsEqual(int[][] m){
		if (m != null && m.length > 1){
			int temp = rowSum(m[0]);
			for (int i = 1; i < m.length; i++){
				if(temp != rowSum(m[i])){
					return false;
				} 
			}
		}
		return true;
	}
	
	public static int rowSum(int[] v){
		int sum = 0;
		if (v != null){
			for (int i = 0; i < v.length; i++){
				sum = sum + v[i];
			}
		}
		return sum;
	}
}