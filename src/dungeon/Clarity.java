package dungeon;

public class Clarity extends EquipmentDecorator{

	public Clarity(Equipment wrappedEquipment) {
		super(wrappedEquipment);
	}

	@Override
	public String getDescription() {
		return wrappedEquipment.getDescription() + " of Clarity";
	}

}
