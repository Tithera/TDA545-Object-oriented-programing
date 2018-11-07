/*
	Laboration 3 Del 1
	Grupp 20
	Josefin Ulfenborg
	Therese Sturesson
	Editor: Smultron
*/

/**
*Class used to increase/decrease based on number of steps
*/
public class FastCounter extends CounterModel{
	private int steps;
	
	/**
	*Increases value by 1 [steps] times
	*/
	public void upMany(){
		for (int i = 0; i < steps; i++){
			super.increment();
		}
	}
	
	/**
	*Decreases value by 1 [steps] times
	*/
	public void downMany(){
		for (int i = 0; i < steps; i++){
			super.decrement();
		}
	}
	
	/**
	*@return string containing information from superclass and nbr of steps
	*/
	public String toString(){
		return (super.toString() + ", and steps: " + steps);
	}
	
	/**
	*Compares [steps] range and information from superclass between Object and counter
	*@param o is the Object used for comparing
	*@return true/false value based on identity between Object and counter
	*/
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		if(o.getClass() == this.getClass()){
			FastCounter fc = (FastCounter) o;
			
			boolean superResult = super.equals(fc);
			//Will compare both value and steps
			if (fc.getStep() == this.getStep() && superResult){
				return true;
			}
		}
		return false;
	}
	
	/**
	*@return steps range for counter
	*/
	public int getStep(){
		return steps;
	}
	
	/**
	*Constructor which initializes a new counter with standard modulus and steps values
	*/
	public FastCounter(){
		super(15);
		this.steps = 5;
	}
	
	/**
	*Constructor which initializes a new counter with modulus and steps values according to arguments
	*@param modulus is the modulus of the counter
	*@param steps is the range of which counter will increase/decrease
	*/
	public FastCounter(int modulus, int steps){
		super(modulus);
		this.steps = steps;
		
	}
}