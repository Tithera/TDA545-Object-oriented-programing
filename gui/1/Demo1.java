import java.awt.*;
import javax.swing.*;

public class Demo1{
	
	public static void main(String[] args){
		JFrame f = new JFrame("Demo 1");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //avslutar programmet när man trycket på krysset
		f.setSize(400,200); //bredd,höjd
		f.setLocation(500,300); //sidledes, höjd
		f.setVisible(true);
	}
}