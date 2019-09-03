package RemoteControl;

public class Projector implements Device {
	
   public void turnOn() {
	   System.out.println("Projector has been turned on");
   }
    
    public void turnOff () {
		System.out.println("Projector has been turned off!");
    }
	
    public String toString() {
    	return "new Projector";
    }
}

