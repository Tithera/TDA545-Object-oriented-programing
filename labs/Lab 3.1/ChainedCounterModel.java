/*
	Laboration 3 Del 1
	Grupp 20
	Josefin Ulfenborg
	Therese Sturesson
	Editor: Smultron
*/

/**
*A class which inherits from CounterModel with overriding increment method
*Makes sure that when a counter reaches modulus, the next time value increases by 1
*/
public class ChainedCounterModel extends CounterModel{
	private final CounterInterface next;
	
	/**
	*Constructor which sets modulus with superclass' constructor and sav
	*Takes starting value as a parameter and sets it accordingly
	*@param init is the starting value for the counter
	*@param modulus is the modulu for the counter (its "max value")
	*@param next is the next counter, i.e minutes if first counter is seconds
	*/
	public ChainedCounterModel(int init, int modulus, CounterInterface next){
		super(modulus);
		this.next = next;
		for (int i = 0; i < init; i++){
			super.increment();
		}
	}
	
	/**
	*Overriding method of superclass CounterModel
	*If counter is reset, next counter is increased by 1
	*/
	public void increment(){
		super.increment();
		if(getValue() == 0){
			next.increment();
		}
	}
}