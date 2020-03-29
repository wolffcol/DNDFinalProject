package dungeon;

public class Speed extends EquipmentDecorator{

	public Speed(Equipment wrappedEquipment) {
		super(wrappedEquipment);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return wrappedEquipment.getDescription() + " of Speed";
	}

}
