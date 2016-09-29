package mobile;



import javax.microedition.lcdui.*;

import sfb.gameplay.rule.DamageAllocation;
import sfb.gameplay.rule.Damageable;

public class AllocationScreen extends Form implements Damageable {
	
	private int count, internals;
	private boolean input, response;
	private StringItem promptuser;
	private StringItem displaytotal;
	
	public AllocationScreen(){
		super("SFB Damage Allocator");
		
		count = internals = 0;
		input = response = false;
		
		displaytotal = new StringItem("", "");
		append(displaytotal);
		promptuser = new StringItem("Do you have system:", "SYSTEM?");
		append(promptuser);
		
		
	}
	
	public void allocateHits(int number){
		count = 1;
		internals = number;
		displaytotal.setText("/"+String.valueOf(internals));
		DamageAllocation.resolveDamage(this, internals);
	}
	
	public void setInternals(int n){
		internals = n;
	}
	
	public void setResponse(boolean r){
		input = true;
		response = r;
	}

	public boolean damageSystem(int system) {
		displaytotal.setLabel(String.valueOf(count));
		switch(system){
		case DamageAllocation.BRIDGE:
			promptuser.setText("BRIDGE?");
			break;
		case DamageAllocation.FLAGBRIDGE:
			promptuser.setText("FLAGBRIDGE?");
			break;
		case DamageAllocation.SENSOR:
			promptuser.setText("SENSOR?");
			break;
		case DamageAllocation.DAMAGECONTROL:
			promptuser.setText("DAMAGECONTROL?");
			break;
		case DamageAllocation.AFTHULL:
			promptuser.setText("AFTHULL?");
			break;
		case DamageAllocation.FORWARDHULL:
			promptuser.setText("FORWARDHULL?");
			break;
		case DamageAllocation.LEFTWARPENGINE:
			promptuser.setText("LEFTWARPENGINE?");
			break;
		case DamageAllocation.RIGHTWARPENGINE:
			promptuser.setText("RIGHTWARPENGINE?");
			break;
		case DamageAllocation.CENTERWARPENGINE:
			promptuser.setText("CENTERWARPENGINE?");
			break;
		case DamageAllocation.TRANSPORTER:
			promptuser.setText("TRANSPORTER?");
			break;
		case DamageAllocation.TRACTORBEAM:
			promptuser.setText("TRACTORBEAM?");
			break;
		case DamageAllocation.SHUTTLEBAY:
			promptuser.setText("SHUTTLEBAY?");
			break;
		case DamageAllocation.LAB:
			promptuser.setText("LAB?");
			break;
		case DamageAllocation.EXCESSDAMAGE:
			promptuser.setText("EXCESSDAMAGE?");
			break;
		case DamageAllocation.DRONERACK:
			promptuser.setText("DRONERACK?");
			break;
		case DamageAllocation.PHASER:
			promptuser.setText("PHASER?");
			break;
		case DamageAllocation.IMPULSEENGINE:
			promptuser.setText("IMPULSEENGINE?");
			break;
		case DamageAllocation.BATTERY:
			promptuser.setText("BATTERY?");
			break;
		case DamageAllocation.AUXILIARYPOWERREACTOR:
			promptuser.setText("AUXILIARY POWER REACTOR?");
			break;
		case DamageAllocation.PROBE:
			promptuser.setText("PROBE?");
			break;
		case DamageAllocation.CARGO:
			promptuser.setText("CARGO?");
			break;
		case DamageAllocation.TORPEDO:
			promptuser.setText("TORPEDO?");
			break;
		case DamageAllocation.ANYWEAPON:
			promptuser.setText("ANY WEAPON?");
			break;
		case DamageAllocation.ANYWARPENGINE:
			promptuser.setText("ANY WARP ENGINE?");
			break;
		case DamageAllocation.SCANNER:
			promptuser.setText("SCANNER?");
			break;
		case DamageAllocation.AUXILIARYCONTROL:
			promptuser.setText("AUXILIARY CONTROL?");
			break;
		case DamageAllocation.EMERGENCYBRIDGE:
			promptuser.setText("EMERGENCY BRIDGE?");
			break;
		default:
			System.out.println("Improper input!"); 
			return false; // TODO exit gracefully with error message
		}
		while (!input){ // wait for user input
			try{
				Thread.sleep(50);
			}catch(Exception e){
				
			}
		}
		if (response == true){
			count++;
		}
		input = false;
		return response;
	}
	
}
