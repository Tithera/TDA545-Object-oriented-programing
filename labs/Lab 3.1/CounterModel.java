/*
	Laboration 3 Del 1
	Grupp 20
	Josefin Ulfenborg
	Therese Sturesson
	Editor: Smultron
*/

/**
*Class which is a model for a counter
*/
public class CounterModel implements CounterInterface{
	private int counterValue = 0;
	private static int nbrOfCounters = 0;
	private final int MOD;
	
	/**
	*Method which increases counter value by 1 with consideration to modulus
	*/
	public void increment(){
		counterValue = (counterValue+1)%MOD;
	}
	
	/**
	*Method which decreases counter value by 1 with consideration to modulus
	*If less than 0, value becomes max(modulus) value-1
	*/
	public void decrement(){
		counterValue--;
		if(counterValue < 0){
			counterValue = MOD-1;
		}
	}
	
	/**
	*Method which resets value to 0
	*/
	public void reset(){
		counterValue = 0;
	}
	
	/**
	*@return current value of counter
	*/
	public int getValue(){
		return counterValue;
	}
	
	/**
	*@return number of counters created
	*/
	public static int getNbrOfCounters(){
		return nbrOfCounters;
	}
	
	/**
	*Constructor which initializes a new counter with standard modulus value 
	*and increases number of counters by 1
	*/
	public CounterModel(){
		nbrOfCounters++;
		this.MOD = 10;
	}
	
	/**
	*Constructor which initializes a new counter with modulus according to argument
	*Increases number of counters by 1
	*@param modulus is the modulus ("max value") for the counter
	*@throws IllegalArgumentException if modulus is lesser than 0
	*/
	public CounterModel(int modulus){
		nbrOfCounters++;
		this.MOD = modulus;
		if (modulus < 0){
			throw new IllegalArgumentException ("Error: must be >= 0");
		}
	}
	
	/**
	*@return current modulus value
	*/
	public int getMod(){
		return MOD;
	}
	
	/**
	*@return string containing information of counter's modulus and current value
	*/
	public String toString(){
		return ("Mod is: " + this.getMod() + ", current value is: " + this.getValue());
	}
	
	/**
	*Compares classes and current value between Object and counter
	*@param o is the Object used for comparing
	*@return true/false value based on identity between Object and counter
	*/
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		if(o.getClass() == this.getClass()){
			CounterModel cm = (CounterModel) o;
			if (cm.getValue() == this.getValue()){
				return true;
			}
		}
		return false;
	}	

}