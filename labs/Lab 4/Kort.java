import java.awt.*;
import javax.swing.*;

/*
Laboration 4
Grupp 20
Josefin Ulfenborg
Therese Sturesson
Editor: Smultron
*/

public class Kort extends JColorfulButton{
	private Icon icon;
	public enum Status {DOLT, SYNLIGT, SAKNAS};
	private Status stat;
	
	public Kort(Icon icon){
		stat = Status.SAKNAS;
		setStatus(stat);
		this.icon = icon;
	}
	
	public Kort(Icon icon, Status stat){
		this.icon = icon;
		setStatus(stat);
		this.stat = stat;
	}
	
	public void setStatus(Status stat){
		/*Beroende på kortets status sätts kortets backgrund, men om kortet
		är synligt visas istället ikonen*/
		this.stat = stat;
		if(stat == Status.DOLT) {
			setBackground(Color.BLUE);
			setIcon(null);
		} else if (stat == Status.SAKNAS) {
			setBackground(Color.WHITE);
			setIcon(null);
		} else if (stat == Status.SYNLIGT) {
			setIcon(icon);
		}
	}
	
	public Status getStatus(){
		return stat;
	}
	
	public Kort copy(){
		return new Kort(icon, stat); 
	}
	
	public boolean sammaBild(Kort kort){
		if (kort == null){
			return false;
		}
		if(kort.getIcon() == this.getIcon()){
			return true;
		}
		return false;
	}
}