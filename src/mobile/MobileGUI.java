package mobile;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MobileGUI extends MIDlet implements CommandListener, Runnable {
	
	private EntryScreen entry;
	private AllocationScreen alloc;
	
	private Command yescommand;
	private Command nocommand;
//	private Command backcommand;
	private Command okcommand;
	private Command clearcommand;
	

	public MobileGUI() {
		super();
		entry = new EntryScreen();
		alloc = new AllocationScreen();
		
		yescommand = new Command("yes",Command.OK,0);
		nocommand = new Command("no",Command.CANCEL, 0);
		okcommand = new Command("ok", Command.OK, 0);
		clearcommand = new Command("clear", Command.BACK, 0);
		
		alloc.addCommand(yescommand);
		alloc.addCommand(nocommand);
		entry.addCommand(okcommand);
		entry.addCommand(clearcommand);
		
		alloc.setCommandListener(this);
		entry.setCommandListener(this);		
	}
	
	public void run(){
		if(entry.test()){
			System.out.println("In here for some reason");
			Display.getDisplay(this).setCurrent(alloc);
			alloc.allocateHits(entry.getHits());
		}
		reset();
	}

	protected void startApp() throws MIDletStateChangeException {
		Display.getDisplay(this).setCurrent(entry);

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
		notifyDestroyed();

	}
	
	public void reset(){
		entry.clear();
		Display.getDisplay(this).setCurrent(entry);
	}

	public void commandAction(Command c, Displayable d) {
		
		if(c == clearcommand){
			entry.clear();
		}
		else if(c == okcommand){
			new Thread(this).start();
		}
		else if(c == yescommand){
			alloc.setResponse(true);
		}
		else if(c == nocommand){
			alloc.setResponse(false);
		}
		
	}

}
