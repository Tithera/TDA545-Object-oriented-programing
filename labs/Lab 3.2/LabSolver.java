/*
	Laboration 3 Del 1
	Grupp 20
	Josefin Ulfenborg
	Therese Sturesson
	Editor: Smultron
*/

public class LabSolver {

    public static void main(String[] args) {
        int width = 20;
        int height = 10;
        if (args.length > 1) {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        }
        Labyrinth l = new Lab(width,height);
        System.out.println("\nCreated a random labyrinth:");
        System.out.println(l);
        boolean success = findPath(0,0,width-1,height-1,l);
        if (success) {
            System.out.println("Solution found:");
            System.out.println(l);
        } else {
            System.out.println("Failed to find a solution. (Bug in LabSolver.java)");
        }
    }

	public static boolean findPath(int x0, int y0, int x1, int y1, Labyrinth l) {
		boolean right = l.canMove(Labyrinth.Direction.RIGHT, x0, y0);
		boolean left  = l.canMove(Labyrinth.Direction.LEFT, x0, y0);
		boolean up    = l.canMove(Labyrinth.Direction.UP, x0, y0);
		boolean down  = l.canMove(Labyrinth.Direction.DOWN, x0, y0);
		l.setMark(x0, y0, true); /* Utgångsvärde och varje gång som vi kan gå åt
								 ett håll kommer vi lägga ut en markering */
		
		if ((x0 == x1) && (y0 == y1)) {
			return true;
		
		} else { 
			//Om vi kan gå åt höger OCH vi inte varit på den platsen förut:
			if(right && !l.getMark(x0+1, y0)) {
					//OCH om fP med nya koordinater kan vara på vägen till x1,y1
					if(findPath(x0+1, y0, x1, y1, l)) {
						//så returneras true för varje steg i rätt riktning
						return true;
					}
			}
			//och samma gäller här fast åt vänster/upp/ner
			if(left && !l.getMark(x0-1, y0)) {
					if(findPath(x0-1, y0, x1, y1, l)) {
						return true;
					}
			}
			if(up && !l.getMark(x0, y0-1)) {
					if(findPath(x0, y0-1, x1, y1, l)){
						return true;
					}
			}
			if(down && !l.getMark(x0, y0+1)) {
					if(findPath(x0, y0+1, x1, y1, l)){
						return true;
					}
			}
		}
		//Om vi inte kan gå åt något håll tas den aktuella markering bort
		l.setMark(x0, y0, false);
		return false; //och eftersom då den vägen var felaktig returneras false
	}
}