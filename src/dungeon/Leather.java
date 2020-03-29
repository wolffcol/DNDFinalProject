package dungeon;

public class Leather extends EquipmentDecorator{

	public Leather(Equipment wrappedEquipment) {
		super(wrappedEquipment);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return "Leather " + wrappedEquipment.getDescription();
	}

}
