/*
	Laboration 3 Del 1
	Grupp 20
	Josefin Ulfenborg
	Therese Sturesson
	Editor: Smultron
*/

/**
*Test class for CounterModel
*/
public class TestCounter{

	/**
	*Tests increment, decrement, reset, equals and getValue and prints results
	*@param args
	*/
	public static void main(String[] args){
		CounterInterface hour = new CounterModel(24);
		CounterInterface min  = new CounterModel(60);
		CounterInterface sec  = new CounterModel(60);
		
		//test of increment
		hour.increment();
		hour.increment();
		hour.increment();
		int result = hour.getValue();
		System.out.println("\nExpected answer: 3, actual result: " 
			+ result);
		if (result == 3){
			System.out.println("Test of increment successful\n");
		} else {
			System.out.println("Test of increment failed\n");
		}
		
		//min increment and test of equals
		min.increment();
		min.increment();
		min.increment();
		System.out.println("Are hour and minute equal? (expected result: True) "
			+ ", actual result: " + (hour.equals(min)));
		if ((hour.equals(min))){
			System.out.println("Test of equals successful\n");
		} else {
			System.out.println("Test of equals failed\n");
		}
		
		//test of reset
		hour.reset();
		result = hour.getValue();
		System.out.println("Expected answer: 0, actual result: "
			+ result);
		if (result == 0){
			System.out.println("Test of reset successful\n");
		} else {
			System.out.println("Test of reset failed\n");
		}
		
		//test of decrement
		sec.decrement();
		sec.decrement();
		sec.decrement();
		result = sec.getValue();
		System.out.println("Expected result: 57, actual result: "
			+ result);
		if (result == 57){
			System.out.println("Test of decrement successful\n");
		} else {
			System.out.println("Test of decrement failed\n");
		}
		
		CounterInterface[] counters = new CounterInterface[3];
		counters[0] = hour;
		counters[1] = min;
		counters[2] = sec;
		for(int i = 0; i < 3; i++){
			System.out.println(counters[i]);
		}
		System.out.println();
		changeValue((CounterModel)sec);
		
	}
	
	/**
	*Changes value of counter
	*@param cm is the CounterModel used as argument
	*/
	public static void changeValue(CounterModel cm){
		int temp = cm.getValue();
		
		cm.increment();
		cm.increment();
		cm.increment();
		temp = (temp+3)%(cm.getMod());
		
		cm.decrement();
		cm.decrement(); 
		temp = temp-2; 
		if (temp < 0){ 
			temp = cm.getMod()+temp;
		}
		System.out.println(cm.toString());
		
		if (temp == cm.getValue()){
			System.out.println("Test of changeValue successful\n");
		} else {
			System.out.println("Test of changeValue failed\n");
		}
		
	}

}

