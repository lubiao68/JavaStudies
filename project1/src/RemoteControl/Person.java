package RemoteControl;

public class Person {

	public static void main (String[] args) {
		
		Device projector = new Projector();
		Device tv  = new TV();
		Device sorroundSoundSystem = new SorroundSoundSystem();
		
        RemoteControl remoteControl = RemoteControl.getInstance();
		remoteControl.connectToDevice(projector);
		remoteControl.clickOnButon();
		
		remoteControl.connectToDevice(tv);
		remoteControl.clickOnButon();
		
		
	}
}


