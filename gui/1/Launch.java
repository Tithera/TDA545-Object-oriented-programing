import java.awt.event.*;
import javax.swing.*;

public class Launch implements ActionListener{
	private int i;
	private Timer t;
	
	public Launch(int i){
		this.i = i;
	}
	
	public void setTimer(Timer timer){
		t = timer;	
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println(i + " seconds left...");
		if (i == 0){
			System.out.println("Launch!");
			//t.stop();
			//System.exit(0);
				
		} else {
			i--;
		}
	}
	
	public static void main(String[] args){
		int i = Integer.parseInt(args[0]);
		Launch l = new Launch(i);
		
		Timer t = new Timer (1000,l);
		l.setTimer(t);
		//t.setRepeats(false);
		t.start();
		
		Launch l2 = new Launch(10);
		Timer t2 = new Timer (1000,l2);
		l2.setTimer(t2);
		//t2.setRepeats(false);
		t2.start();
		
	}
}