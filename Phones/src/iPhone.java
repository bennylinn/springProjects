
public class iPhone extends Phones {

	public iPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

	@Override
	public String ring() {
		// TODO Auto-generated method stub
		String s = "iPhone " + this.getVersionNumber() + " says " + this.getRingTone();
		return s;
	}

	@Override
	public String unlock() {
		// TODO Auto-generated method stub
		return "Unlocking via facial recognition";
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		System.out.println("iPhone " + this.getVersionNumber() + " from " + this.getCarrier());
		
	}

}
