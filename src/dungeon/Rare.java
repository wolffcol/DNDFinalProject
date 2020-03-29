package dungeon;

public class Rare extends EquipmentDecorator{

	public Rare(Equipment wrappedEquipment) {
		super(wrappedEquipment);
		
	}

	@Override
	public String getDescription() {
		return "Rare " + wrappedEquipment.getDescription();
	}

}
