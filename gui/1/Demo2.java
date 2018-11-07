import java.awt.*;
import javax.swing.*;

//ett annat sätt att göra Demo1 på. Vi ärver från klassen JFrame, så då slipper vi
//anropa med f.setSize(), nu behöver vi endast skriva setSize();

public class Demo2 extends JFrame{	
	
	//konstruktor
	public Demo2(String title, int side, int height){
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);
		setLocation(side, height);
		setVisible(true);
	}
	
	//Vi slipper skapa en instans av typen JFrame
	public static void main(String[] args){
		Demo2 d1 = new Demo2("D1", 50,50);
		Demo2 d2 = new Demo2("D2", 500,500);
	}
}

/*
	Studera skillnaden mellan Demo1 och Demo2
	
	I Demo1 skapar vi en ny instans av typen JFrame och kallar den f,
	när vi sedan anropar metoderna så skickar vi in f
	
	I Demo2 ärver vi från JFrame och skapar en konstruktor. I konstruktorn
	anropar vi sedan metoderna. I main skapar vi en ny Demo2-instans, och 
	på så vis anropar vi konstruktorn som utför metoderna på demo
	
	Demo2 är en JFrame
	På det här viset slipper vi skriva två gånger om vi vill skapa två fönster
	slipper vi skriva två gånger
	
	Vi skulle också kunnat sätta innehållet i konstruktorn i main och skriva
	d1.setTitle, osv
	
*/