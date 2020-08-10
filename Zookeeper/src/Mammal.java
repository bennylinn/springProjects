
public class Mammal {
	int energyLevel;
	
	public Mammal() {
		this.setEnergyLevel(0);
	}
	
	public Mammal(int e) {
		this.setEnergyLevel(e);
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	
}
