
public class Galaxy extends Phones {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

	@Override
	public String ring() {
		// TODO Auto-generated method stub
		String s = "Galaxy " + this.getVersionNumber() + " says " + this.getRingTone();
		return s;
	}

	@Override
	public String unlock() {
		// TODO Auto-generated method stub
		return "Unlocking via finger print";
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		System.out.println("Galaxy " + this.getVersionNumber() + " from " + this.getCarrier());
		
	}

}
