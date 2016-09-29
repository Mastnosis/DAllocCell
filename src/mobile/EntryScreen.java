package mobile;

import javax.microedition.lcdui.*;

public class EntryScreen extends Form {
	
	private TextField quantity;
	
	public EntryScreen(){
		super("SFB Damage Allocator");
		
		quantity = new TextField("Enter # of points to allocate:", "", 3, TextField.NUMERIC);
		append(quantity);
				
	}

	public int getHits(){
		return Integer.parseInt(quantity.getString());
	}
	
	public void clear(){
		quantity.setString("");
	}
	
	public boolean test(){
		System.out.println("*"+quantity.getString()+"*");
		if(!quantity.getString().equals("")){
			return true;
		}
		return false;
	}
}
