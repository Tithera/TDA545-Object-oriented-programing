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
/*

Om vi kan gå ett steg åt höger, så försöker vi hitta en lösning därifrån med koordinaterna x0+1, y0
Om det inte lyckas, vill vi ta bort setMark (setMark(false))

Om vi däremot har varit där innan, vill vi inte gå tillbaka. if(!=) then setMark and try from new coordinates

Så först vill vi undersöka så vi inte varit där innan (annars kommer det sluta med att vi går höger-vänster-höger-vänster)
Om vi har varit där innan, vill vi gå vidare till nästa försök (left). 

getMark() kollar om det är en markering på angivna värden

Grejen med rekursion: det är som vilket annat metodanrop som helst. 
Jag trodde: När vi anropar findPath så hoppar vi ur metoden och börjar om från början
Det som egentligen hände: Vi anropar findPath, fortsätter köra metoden som vanligt MEN vi börjar OCKSÅ om från början med nya värden. 
På så vis kommer vi köra den flera gånger samtidigt. 


- if(!findPath()){ setMark(,,false);}
- else{setMark(,,false);}

--Vi vill: ta bort de misslyckade vägarna. Just nu skrivs alla försök ut, så även de felaktiga returneras. Vägen är fortfarande där, bara ej synlig. 
--Försök 1: Lade till l.setMark(x0,y0,false) innan return false: problemet är nu att de felaktiga lösningarna ligger kvar, bara syns ej
Om vi ändrar till return true, kommer endast sista punkten vid slutet synas (så l.setMark() tar bort allt just nu)
--Halvdant försök 2: if(!(right && left && up && down)){ l.setMark(x0, y0, false); }, gjorde något som inte var rätt
--3: Prövar att flytta upp den inuti else-satsen. Läget oförändrat
--4: Prövade att göra left/up/down till else-if och i else-satsen: else { l.setMark(x0,y0,false); } ... allting försvann

Om vi inte kan gå höger, vänster, upp eller ner så vill vi ta bort koordinaten. 

*/
