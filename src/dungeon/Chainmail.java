package dungeon;

public class Chainmail extends EquipmentDecorator{

	public Chainmail(Equipment wrappedEquipment) {
		super(wrappedEquipment);
		
	}

	@Override
	public String getDescription() {
		return "Chainmail " + wrappedEquipment.getDescription();
	}

}
