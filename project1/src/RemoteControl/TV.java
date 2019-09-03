package RemoteControl;

public class TV implements Device {
	
   public void turnOn() {
	   System.out.println("TV has been turned on");
   }
    
    public void turnOff () {
		System.out.println("TV has been turned off!");
    }
	
    public String toString() {
    	return "TV";
    }
}
