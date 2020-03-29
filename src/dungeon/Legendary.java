package dungeon;

public class Legendary extends EquipmentDecorator {

	public Legendary(Equipment wrappedEquipment) {
		super(wrappedEquipment);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return "Legendary " + wrappedEquipment.getDescription();
	}

}
