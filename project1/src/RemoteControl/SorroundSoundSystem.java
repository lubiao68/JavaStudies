package RemoteControl;

public class SorroundSoundSystem implements Device {
	
	   public void turnOn() {
		   System.out.println("SorroundSoundSystem has been turned on");
	   }
	    
	    public void turnOff () {
			System.out.println("SorroundSoundSystem has been turned off!");
	    }
		
	    public String toString() {
	    	return "SorroundSoundSystem";
	    }
}

