 /*
	Laboration 2 Del 2
	Grupp 20
	Josefin Ulfenborg
	Therese Sturesson
	Editor: Smultron
	*/

public class RatNum{
	private int a;
	private int b;
	
	public RatNum(){
		a = 0;
		b = 1;
	}
	
	public RatNum(int a){
		this.a = a;
		b = 1;
		
	}
	
	public RatNum (int a, int b){
		int c = gcd(a,b);
		if (a != 0){
			a = a/c;
			b = b/c;
		}
		
		if (a<0 && b<0 || a>0 && b<0 || a == 0 && b<0){
			a = a*(-1);
			b = b*(-1);
		}
		else if (b == 0){
			throw new NumberFormatException("Denominator = 0");
		}
		
		this.a = a;
		this.b = b;
	}
	
	public RatNum(RatNum r){
		a = r.getNumerator(); //r.a
		b = r.getDenominator();
	}
	
	public int getNumerator(){
		return a;
	}
	
	public int getDenominator(){
		return b;
	}
	
	public static int gcd(int a, int b){
		int r;
		
		if (a < 0){
			a = a*(-1);
		}
		if (b < 0){
			b = b*(-1);
		}
		
		if (a == 0 && b == 0){
			throw new IllegalArgumentException("Error");
		}
		else if(a == 0){
			return b;
		}
		else if(b == 0){
			return a;
		}
		else{
			r = a%b;
			if (r == 0){
				return b;
			}
			else{
				a = b;
				b = r;
			}
		}
		return (gcd(a,b));
	}

	public String toString(){
		return ("" + a + "/" + b);
	}
	
	public double toDouble(){
		return ((double)a/(double)b);
	}
	
	public static RatNum parse(String s){
		if(!s.contains("/")){
			s = s + "/1";
		}
		
		String[] parts = s.split("/", 2);
		String part1 = parts[0];
		String part2 = parts[1];
		
		if(part2.contains("/")){
			throw new NumberFormatException("Invalid denominator: " + part2);
		}
		
		if(part1.contains("-") && part1.indexOf("-") != 0){
			throw new NumberFormatException("Invalid numerator" + part1);
		}
		
		if(part2.contains("-") && part2.indexOf("-") != 0){
			throw new NumberFormatException("Invalid denominator" + part2);
		}

		int n = Integer.parseInt(part1);
		int d = Integer.parseInt(part2);
		
		RatNum r = new RatNum(n, d);
		return r;
	}
	
	
	public RatNum(String s){
		RatNum rn = parse(s);
		this.a = rn.getNumerator();
		this.b = rn.getDenominator();	
	}
	
	public boolean equals(Object r){
		if (r == null){
			return false;
		}
		if(r instanceof RatNum){
			RatNum x = (RatNum) r;
			if (x.getNumerator() == this.getNumerator() && x.getDenominator()
			== this.getDenominator()){
				return true;
			}
		}
		return false;
	}
	
	public boolean lessThan(RatNum r){
		int rn = (r.getNumerator())*(this.getDenominator());
		int tn = (this.getNumerator())*(r.getDenominator());
		
		if (tn < rn){
			return true;
		}
		return false;
	}
	
	public RatNum add(RatNum r){
		int rnum1 = (r.getNumerator())  *(this.getDenominator());
		int rnum2 = (r.getDenominator())*(this.getDenominator());
		
		int anum1 = (this.getNumerator())  *(r.getDenominator());
		int t = rnum1+anum1;
		
		RatNum a = new RatNum(t,rnum2);
		return a;
	}

	public RatNum sub(RatNum r){
		int rnum1 = (this.getNumerator())  *(r.getDenominator());
		int rnum2 = (r.getNumerator())*(this.getDenominator());
		
		RatNum s = new RatNum((rnum1-rnum2),(this.getDenominator()*r.getDenominator()));
		return s;
	}
	
	public RatNum mul(RatNum r){
		int rnum1 = (r.getNumerator())*(this.getNumerator());
		int rnum2 = (r.getDenominator())*(this.getDenominator());
		RatNum m = new RatNum(rnum1, rnum2);
		return m;
	}
	
	public RatNum div(RatNum r){
		int rnum1 = (this.getNumerator())*(r.getDenominator());
		int rnum2 = (this.getDenominator())*(r.getNumerator());
		RatNum d = new RatNum(rnum1, rnum2);
		return d;
	}
	
	public static void main(String[] args){
		RatNum r = new RatNum (5,4);
		
		System.out.println(r);
	}
}